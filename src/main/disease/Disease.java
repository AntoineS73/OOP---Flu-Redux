package main.disease;

import main.map.*;
import main.alive.*;
import main.*;

/**
 *
 */
public class Disease {

    private double contagiousness; //contagiosité passage santé-->porteur
    private double incubation;     //incubation passage porteur-->malade
    private double virulence;      //virulence passage malade-->mort
    private double recovery;       //récupération passage malade-->santé
    private double evolution;      //caractère évolutif

    /**
     *
     * @param con
     * @param inc
     * @param vir
     * @param rec
     * @param evolution
     * @param evo
     */
    public Disease(double con, double inc, double vir, double rec, double evolution, double evo) {
        this.contagiousness = con;
        this.incubation = inc;
        this.virulence = vir;
        this.recovery = rec;
        this.evolution = evo;
    }

    /**
     *
     * @return
     */
    public double getContagiousness() {
        return this.contagiousness;
    }

    /**
     *
     * @return
     */
    public double getIncubation() {
        return this.incubation;
    }

    /**
     *
     * @return
     */
    public double getVirulence() {
        return this.virulence;
    }

    /**
     *
     * @return
     */
    public double getRecovery() {
        return this.recovery;
    }

    /**
     *
     * @return
     */
    public double getEvolution() {
        return this.evolution;
    }

    public boolean equals(Disease disease) {
        if(this.contagiousness == disease.getContagiousness() && this.incubation == disease.getIncubation()
             && this.virulence == disease.getVirulence() && this.recovery == disease.getRecovery()
             && this.evolution == disease.getEvolution()) {return true;}
        else {return false;}

    }

    /**
     *
     */
    public void Mutation() {
        this.contagiousness = this.contagiousness + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.incubation = this.incubation + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.virulence = this.virulence + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.recovery = this.recovery + Math.random() * (this.evolution) - Math.random() * (this.evolution);
        this.evolution = this.evolution + Math.random() * (this.evolution * 0.1) - Math.random() * (this.evolution * 0.1);
        if (this.contagiousness < 0) {
            this.contagiousness = 0;
        }
        if (this.incubation < 0) {
            this.incubation = 0;
        }
        if (this.virulence < 0) {
            this.virulence = 0;
        }
        if (this.recovery < 0) {
            this.recovery = 0;
        }
        if (this.evolution < 0) {
            this.evolution = 0;
        }
    }

}
