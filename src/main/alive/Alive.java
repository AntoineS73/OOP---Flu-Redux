package main.alive;

import main.disease.Disease;
import main.disease.State;
import main.map.Field;
import main.map.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing shared characteristics of alives.
 *
 * @author David J. Barnes, Michael Kölling, Axel Aiello and Antoine Steyer
 * @version 2016.01.05
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
    // The alive's immunities
    private Map<Disease, Boolean> immunities;

    /**
     * Create a new alive at location in field.
     *
     * @param field      The field currently occupied.
     * @param location   The location within the field.
     * @param resistance The alive's natural resistance
     * @param speed      The alive's speed
     * @param state      The alive's state
     * @param disease    The alive's disease
     * @param immunities The alive's immunities
     */
    public Alive(Field field, Location location, double resistance, double speed, State state, Disease disease, Map<Disease, Boolean> immunities) {
        this.field = field;
        setLocation(location);
        this.immunities = immunities;
        this.resistance = resistance;
        this.speed = speed;
        this.state = state;
        this.disease = disease;
        this.immunities = immunities;

    }

    public Alive(Field field, Location location, double resistance, double speed) {
        this(field, location, resistance, speed, State.HEALTHY, null, new HashMap<>());
    }

    /**
     * Make this alive act - that is: make it do
     * whatever it wants/needs to do.
     *
     * @param newAlives A list to receive newly born alives.
     */
    abstract public void act(List<Alive> newAlives);


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

    public void beHealed() {
        this.state = State.HEALTHY;
        this.disease = null;
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

    /**
     * Return the alive's state
     *
     * @return the alive's state
     */
    public State getState() {
        return this.state;
    }

    /**
     * Change the alive's state
     *
     * @param state The new alive's state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Return the alive's speed
     *
     * @return the alive's speed
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Change the alive's speed
     *
     * @param speed The new alive's speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Return the alive's resistance
     *
     * @return the alive's resistance
     */
    public double getResistance() {
        return this.resistance;
    }

    /**
     * Change the alive's resistance
     *
     * @param resistance The new alive's resistance
     */
    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    /**
     * Return the alive's disease
     *
     * @return the alive's disease
     */
    public Disease getDisease() {
        return this.disease;
    }

    /**
     * Change the alive's disease
     *
     * @param disease the new alive's disease
     */
    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    /**
     * Return the alive's immunities
     *
     * @return the alive's immunities
     */
    public Map<Disease, Boolean> getImmunities() {
        return immunities;
    }

    /**
     * Check whether the alive is immune to a disease
     *
     * @param disease the disease to check
     * @return true if the alive is immune
     */
    public boolean getDiseaseImmunity(Disease disease) {
        return immunities.get(disease);
    }

    /**
     * Change the alive's immunities
     *
     * @param immunities The new alive's immunities
     */
    public void setImmunities(Map<Disease, Boolean> immunities) {
        this.immunities = immunities;
    }

    /**
     * Change the alive's immunity for one disease
     *
     * @param disease  The disease to change the immunity
     * @param immunity The new immunity for this disease
     */
    public void setDiseaseImmunity(Disease disease, boolean immunity) {
        this.immunities.replace(disease, immunity);
    }

    /**
     * Create an alive's immunity for disease
     *
     * @param disease  The new disease discovered
     * @param immunity The immunity for this disease
     */
    public void createDiseaseImmunity(Disease disease, boolean immunity) {
        if (this.immunities.containsKey(disease)) setDiseaseImmunity(disease, immunity);
        else this.immunities.put(disease, immunity);
    }
}
