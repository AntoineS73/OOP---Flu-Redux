package main.disease;

import main.alive.Alive;

import java.util.List;

/**
 * A class representing shared characteristics of diseases.
 *
 * @author Axel Aiello and Antoine Steyer
 * @version 2016.01.05
 */
public abstract class Disease {

    // The disease's rate of contagiousness
    private double contagiousnessRate;
    // The number of days corresponding of the disease's incubation
    private int incubationTime;
    // The disease's rate of virulence
    private double virulenceRate;
    // The disease's rate of recovery
    private double recoveryRate;
    // The number of days corresponding of the disease's recovery
    private int recoveryTime;
    // List of all compatibles species for the disease
    private List<Class> compatibles;

    // The disease's rate of evolution
    private double evolution;


    /**
     * Create a new disease
     *
     * @param contagiousness The disease's rate of contagiousness
     * @param incubationTime The number of days corresponding of the disease's incubation
     * @param virulence      The disease's rate of virulence
     * @param recovery       The disease's rate of recovery
     * @param recoveryTime   The number of days corresponding of the disease's recovery
     * @param evolution      The disease's rate of evolution
     * @param compatibles    List of all compatibles species for the disease
     */
    public Disease(double contagiousness, int incubationTime, double virulence, double recovery, int recoveryTime, double evolution, List<Class> compatibles) {
        this.contagiousnessRate = contagiousness;
        this.incubationTime = incubationTime;
        this.virulenceRate = virulence;
        this.recoveryRate = recovery;
        this.recoveryTime = recoveryTime;
        this.evolution = evolution;
        this.compatibles = compatibles;
    }

    /**
     * Check whether the disease is equal to another
     *
     * @param disease The disease to check
     * @return true if the diseases are equal
     */
    public boolean equals(Disease disease) {
        return this.contagiousnessRate == disease.getContagiousnessRate() && this.incubationTime == disease.getIncubationTime()
                && this.virulenceRate == disease.getVirulenceRate() && this.recoveryRate == disease.getRecoveryRate()
                && this.evolution == disease.getEvolution();

    }

    /**
     * Determine a random evolution of the disease
     */
    public void Mutation() {
        this.contagiousnessRate = this.contagiousnessRate + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.virulenceRate = this.virulenceRate + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.recoveryRate = this.recoveryRate + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.evolution = this.evolution + Math.random() * (this.evolution * 0.1) - Math.random() * (this.evolution * 0.1);
        if (this.contagiousnessRate < 0) {
            this.contagiousnessRate = 0;
        }
        if (this.virulenceRate < 0) {
            this.virulenceRate = 0;
        }
        if (this.recoveryRate < 0) {
            this.recoveryRate = 0;
        }
        if (this.evolution < 0) {
            this.evolution = 0;
        }
    }

    /**
     * Check if an alive is compatible with the disease
     *
     * @param alive The alive to check
     * @return true if the alive is compatible
     */
    public boolean isCompatible(Alive alive) {
        for (Class compatible : this.compatibles) {
            if (compatible.equals(alive)) return true;
        }
        return false;
    }

    /**
     * Return the disease's contagiousness rate
     *
     * @return the disease's contagiousness rate
     */
    protected double getContagiousnessRate() {
        return this.contagiousnessRate;
    }

    /**
     * Return the disease's incubation time
     *
     * @return the disease's incubation time
     */
    protected int getIncubationTime() {
        return this.incubationTime;
    }

    /**
     * Return the disease's virulence rate
     *
     * @return the disease's virulence rate
     */
    protected double getVirulenceRate() {
        return this.virulenceRate;
    }

    /**
     * Return tbe disease's recovery rate
     *
     * @return the disease's recovery rate
     */
    protected double getRecoveryRate() {
        return this.recoveryRate;
    }

    /**
     * Return the disease's recovery time
     *
     * @return the disease's recovery time
     */
    protected double getRecoveryTime() {
        return this.recoveryTime;
    }

    /**
     * Return the disease's evolution rate
     *
     * @return the disease's evolution rate
     */
    protected double getEvolution() {
        return this.evolution;
    }

    /**
     * Return the disease's compatibles list
     *
     * @return the disease's compatibles list
     */
    protected List<Class> getCompatibles() {
        return this.compatibles;
    }

}
