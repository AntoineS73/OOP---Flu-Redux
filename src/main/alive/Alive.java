package main.alive;

import main.disease.Disease;
import main.disease.State;
import main.map.Field;
import main.map.Location;

import java.util.List;

/**
 * A class representing shared characteristics of alives.
 *
 * @author David J. Barnes, Michael Kölling, Axel Aiello and Antoine Steyer
 * @version 2015.12.31
 */
public abstract class Alive {

    // The alive's natural resistance
    private double resistance;
    // The alive's state
    private State state;
    // The alive's disease
    private Disease disease;
    // The alive's speed
    private double speed;
    // The alive's field.
    private Field field;
    // The alive's position in the field.
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
        this.state = sta;
        this.disease = mal;
        this.field = field;
        setLocation(location);
    }

    public Alive(Field field, Location location, double res, double spe) {
        this(field, location, res, spe, State.HEALTHY, null);
    }

    /**
     * Make this alive act - that is: make it do
     * whatever it wants/needs to do.
     *
     * @param newAlives A list to receive newly born alives.
     */
    abstract public void act(List<Alive> newAlives);

    protected State getState() {
        return this.state;
    }

    protected double getSpeed() {
        return this.speed;
    }

    protected double getResistance() {
        return this.resistance;
    }

    protected Disease getDisease() {
        return this.disease;
    }

    protected void setState(State e) {
        this.state = e;
    }

    protected void setSpeed(double s) {
        this.speed = s;
    }

    protected void setResistance(double r) {
        this.resistance = r;
    }

    protected void setDisease(Disease mal) {
        this.disease = mal;
    }

    /**
     * Check whether the "alive" is alive or not.
     *
     * @return true if the alive is still alive.
     */
    public boolean isAlive() {
        return !this.state.equals(State.DEAD);
    }

    /**
     * Indicate that the alive is no longer alive.
     * It is removed from the field.
     */
    protected void setDead() {
        this.state = State.DEAD;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the alive's location.
     *
     * @return The alive's location.
     */
    protected Location getLocation() {
        return location;
    }

    /**
     * Place the alive at the new location in the given field.
     *
     * @param newLocation The alive's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the alive's field.
     *
     * @return The alive's field.
     */
    protected Field getField() {
        return field;
    }

}
