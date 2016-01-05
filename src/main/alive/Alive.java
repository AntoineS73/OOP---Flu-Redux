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
    public Alive(Field field, Location location, double resistance, double speed, State state, Disease disease) {
        this.resistance = resistance * (1 + Math.random() * (0.2) - Math.random() * (0.2));
        this.speed = speed * (1 + Math.random() * (0.2) - Math.random() * (0.2));
        this.state = state;
        this.disease = disease;
        this.field = field;
        setLocation(location);
    }

    public Alive(Field field, Location location, double resistance, double speed) {
        this(field, location, resistance, speed, State.HEALTHY, null);
    }

    /**
     * Make this alive act - that is: make it do
     * whatever it wants/needs to do.
     *
     * @param newAlives A list to receive newly born alives.
     */
    abstract public void act(List<Alive> newAlives);

    public State getState() {
        return this.state;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getResistance() {
        return this.resistance;
    }

    public Disease getDisease() {
        return this.disease;
    }

    public void setState(State e) {
        this.state = e;
    }

    public void setSpeed(double s) {
        this.speed = s;
    }

    public void setResistance(double r) {
        this.resistance = r;
    }

    public void setDisease(Disease mal) {
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
     * Check whether the "alive" is recovering or not.
     *
     * @return true if the alive is recovering.
     */
    public boolean isHealthy() {
        return this.state.equals(State.HEALTHY);
    }

    /**
     * Check whether the "alive" is sick or not.
     *
     * @return true if the alive is sick.
     */
    public boolean isSick() {
        return this.state.equals(State.SICK);
    }

    /**
     * Check whether the "alive" is contagious or not.
     *
     * @return true if the alive is contagious.
     */
    public boolean isContagious() {
        return this.state.equals(State.CONTAGIOUS);
    }

    /**
     * Check whether the "alive" is recovering or not.
     *
     * @return true if the alive is recovering.
     */
    public boolean isRecovering() {
        return this.state.equals(State.RECOVERING);
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
