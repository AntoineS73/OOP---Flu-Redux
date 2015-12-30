package main.alive;

import main.disease.Disease;
import main.disease.State;
import main.map.Field;
import main.map.Location;

import java.util.List;

/**
 * A class representing shared characteristics of animals.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public abstract class Alive {

    private double resistance;
    private State etat;
    private Disease maladie;
    private double speed;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;

    /**
     * Create a new alive at location in field.
     *
     * @param field    The field currently occupied.
     * @param location The location within the field.
     */
    public Alive(Field field, Location location, double res, double spe, State sta, Disease mal) {
        this.resistance = res * (1 + Math.random() * (0.2) - Math.random() * (0.2));
        this.speed = spe * (1 + Math.random() * (0.2) - Math.random() * (0.2));
        this.etat = sta;
        this.maladie = mal;
        this.field = field;
        setLocation(location);
    }

    public Alive(Field field, Location location, double res, double spe) {
        this(field, location, res, spe, State.HEALTHY, null);
    }

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     *
     * @param newAlives A list to receive newly born animals.
     */
    abstract public void act(List<Alive> newAlives);

    protected State getEtat() {
        return this.etat;
    }

    protected double getSpeed() {
        return this.speed;
    }

    protected double getResistance() {
        return this.resistance;
    }

    protected Disease getMaladie() {
        return this.maladie;
    }

    protected void setEtat(State e) {
        this.etat = e;
    }

    protected void setSpeed(double s) {
        this.speed = s;
    }

    protected void setResistance(double r) {
        this.resistance = r;
    }

    protected void setMaladie(Disease mal) {
        this.maladie = mal;
    }

    /**
     * Check whether the animal is alive or not.
     *
     * @return true if the animal is still alive.
     */
    public boolean isAlive() {
        return !this.etat.equals(State.DEAD);
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead() {
        this.etat = State.DEAD;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     *
     * @return The animal's location.
     */
    protected Location getLocation() {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     *
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the animal's field.
     *
     * @return The animal's field.
     */
    protected Field getField() {
        return field;
    }

}
