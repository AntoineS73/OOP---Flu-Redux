package main.alive;

import java.util.List;
import java.util.Random;

import main.map.*;
import main.disease.*;
import main.utils.Randomizer;

/**
 * A simple model of a duck.
 * Ducks age, move, breed, and die.
 *
 * @author David J. Barnes, Michael Kölling, Axel Aiello and Antoine Steyer
 * @version 2015.12.21
 */
public class Duck extends Alive {
    // Characteristics shared by all ducks (class variables).

    // The age at which a duck can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a duck can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a duck breeding.
    private static final double BREEDING_PROBABILITY = 0.09;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    private static final double RESISTANCE_DEFAULT = 0.5;
    private static final double SPEED_DEFAULT = 0;
    // The duck's age.
    private int age;

    /**
     * Create a new duck. A duck may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the duck will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Duck(boolean randomAge, Field field, Location location, State sta, Disease mal) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT, sta, mal);
        age = rand.nextInt(MAX_AGE);
    }
    
    public Duck(Field field, Location location) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT );
        age = 0;
    }

    /**
     * This is what the duck does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     * @param newDucks A list to return newly born ducks.
     */
    public void act(List<Alive> newDucks)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newDucks);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Increase the age.
     * This could result in the duck's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Check whether or not this duck is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newDucks A list to return newly born ducks.
     */
    private void giveBirth(List<Alive> newDucks)
    {
        // New ducks are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Duck young = new Duck(field, loc);
            newDucks.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A duck can breed if it has reached the breeding age.
     * @return true if the duck can breed, false otherwise.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }
}
