package alive;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import map.*;
import disease.*;
import utils.Randomizer;

/**
 * A simple model of a Human.
 * Humans age, move, breed, and die.
 *
 * @author David J. Barnes, Michael Kölling, Axel Aiello and Antoine Steyer
 * @version 2016.01.05
 */
public class Human extends Alive {
    // Characteristics shared by all humans (class variables).

    // The age at which a human can start to breed.
    private static final int BREEDING_AGE = 600;
    // The age to which a human can live.
    private static final int MAX_AGE = 1500;
    // The likelihood of a human breeding.
    private static final double BREEDING_PROBABILITY = 0.0005;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 1;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    // Individual characteristics (instance fields).
    private static final double RESISTANCE_DEFAULT = 0.7;
    private static final double SPEED_DEFAULT = 1;
    // The human's age.
    private int age;
    // A counter for days
    private int nbDays;

    /**
     * Create a new human. A human may be created with age
     * zero (a new born) or with a random age.
     *
     * @param randomAge If true, the human will have a random age.
     * @param field     The field currently occupied.
     * @param location  The location within the field.
     * @param sta       The human's state
     * @param dis       The human's disease
     * @param nbDays    The number of days passed into the simulation
     */
    public Human(boolean randomAge, Field field, Location location, State sta, Disease dis, int nbDays) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT, sta, dis, new HashMap<>());
        this.nbDays = nbDays;
        if (randomAge) age = rand.nextInt(MAX_AGE);
    }

    public Human(boolean randomAge, Field field, Location location) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT, State.HEALTHY, null, new HashMap<>());
        if (randomAge) age = rand.nextInt(MAX_AGE);
        nbDays = 0;
    }

    public Human(Field field, Location location) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT);
        age = 0;
        nbDays = 0;
    }

    /**
     * This is what the human does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     *
     * @param newHumans A list to return newly born humans.
     */
    public void act(List<Alive> newHumans) {
        incrementAge();
        if (isAlive()) {
            giveBirth(newHumans);
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            }
            changeState(getState());

        }
    }

    /**
     * Determine how the human's state will change
     *
     * @param state the actual state of the human
     */
    private void changeState(State state) {

        switch (state) {
            case HEALTHY:
                infection();
                break;
            case SICK:
                if (nbDays < getDisease().getIncubationTime()) {
                    nbDays++;
                } else {
                    setState(State.CONTAGIOUS);
                    nbDays = 0;
                }
                break;
            case CONTAGIOUS:
                if (rand.nextDouble() >= getDisease().getRecoveryRate()) {
                    setState(State.RECOVERING);
                    setDiseaseImmunity(getDisease(), true);
                    nbDays = 0;
                } else if (rand.nextDouble() <= getDisease().getVirulenceRate()) {
                    setDead();
                }
                break;
            case RECOVERING:
                if (nbDays < getDisease().getRecoveryTime()) {
                    nbDays++;
                } else {
                    setState(State.HEALTHY);
                    nbDays = 0;
                }
                break;
            case DEAD:
                break;
        }
    }

    /**
     * Determine if the human is infected by his neighbourhoods
     */
    private void infection() {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        for (Location loc : adjacent) {
            Object aliveObject = field.getObjectAt(loc);
            if (aliveObject instanceof Alive) {
                Alive alive = (Alive) aliveObject;
                Disease disease = alive.getDisease();
                if (disease != null && disease.isCompatible(this) && alive.isContagious()) {
                    createDiseaseImmunity(disease, false);
                    if (!getImmunities().get(disease) && rand.nextDouble() <= disease.getContagiousnessRate()) {
                        setState(State.SICK);
                        setDisease(disease);
                    }
                }

            }
        }
    }

    /**
     * Increase the age.
     * This could result in the human's death.
     */
    private void incrementAge() {
        age++;
        if (age > MAX_AGE) {
            setDead();
        }
    }

    /**
     * Check whether or not this human is to give birth at this step.
     * New births will be made into free adjacent locations.
     *
     * @param newHumans A list to return newly born humans.
     */
    private void giveBirth(List<Alive> newHumans) {
        // New humans are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Human young = new Human(field, loc);
            newHumans.add(young);
        }
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     *
     * @return The number of births (may be zero).
     */
    private int breed() {
        int births = 0;
        if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A human can breed if it has reached the breeding age.
     *
     * @return true if the human can breed, false otherwise.
     */
    private boolean canBreed() {
        return age >= BREEDING_AGE;
    }
}
