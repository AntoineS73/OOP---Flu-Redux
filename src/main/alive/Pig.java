package main.alive;

import java.util.List;
import java.util.Random;

import main.Randomizer;
import main.disease.*;
import main.map.*;


/**
 * A simple model of a pig.
 * pig age, move, breed, and die.
 * 
 * @author David J. Barnes, Michael Kölling, Axel Aiello and Antoine Steyer
 * @version 2015.12.21
 */
public class Pig extends Alive {
    // Characteristics shared by all pigs (class variables).

    // The age at which a pig can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a pig can live.
    private static final int MAX_AGE = 100;
    // The likelihood of a pig breeding.
    private static final double BREEDING_PROBABILITY = 0.09;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    // Individual characteristics (instance fields).
    private static final double RESISTANCE_DEFAULT = 0.5;
    private static final double SPEED_DEFAULT = 0;
    // The pig's age.
    private int age;

    /**
     * Create a new pig. A pig may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the pig will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Pig(boolean randomAge, Field field, Location location, State sta, Disease mal) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT, sta, mal);
        age = rand.nextInt(MAX_AGE);
    }
    
    public Pig(Field field, Location location) {
        super(field, location, RESISTANCE_DEFAULT, SPEED_DEFAULT );
        age = 0;
    }

    /**
     * This is what the pig does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     * @param newPigs A list to return newly born pigs.
     */
    public void act(List<Alive> newPigs)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newPigs);            
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
     * This could result in the pig's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }
    
    /**
     * Check whether or not this pig is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newPigs A list to return newly born pigs.
     */
    private void giveBirth(List<Alive> newPigs)
    {
        // New pigs are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Pig young = new Pig(field, loc);
            newPigs.add(young);
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
     * A pig can breed if it has reached the breeding age.
     * @return true if the pig can breed, false otherwise.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }
}
