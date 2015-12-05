package main.disease;

public class Disease {

  private double contagiousness; //contagiosité passage santé-->porteur
  private double incubation;     //incubation passage porteur-->malade
  private double virulence;      //virulence passage malade-->mort
  private double recovery;       //récupération passage malade-->santé
  private double evolution;       //caracthère évolutif

  public Disease(double con, double inc, double vir, double rec, double evolution, double evo) {
    this.contagiousness = con;
    this.incubation = inc;
    this.virulence = vir;
    this.recovery = rec;
    this.evolution = evo;
  }

  public double getContagiousness() {
    return this.contagiousness;
  }

  public double getIncubation() {
    return this.incubation;
  }

  public double getVirulence() {
    return this.virulence;
  }

  public double getRecovery() {
    return this.recovery;
  }

  public double getEvolution() {
    return this.evolution;
  }

  public Disease Mutation() {
    double con = this.contagiousness + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    double inc = this.incubation + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    double vir = this.virulence + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    double rec = this.recover + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    double evo = this.evolution + Math.random()*(this.evolution * 0.1) - Math.random()*(this.evolution * 0.1);
    if (con < 0) {con = 0;}
    if (inc < 0) {inc = 0;}
    if (vir < 0) {vir = 0;}
    if (rec < 0) {rec = 0;}
    if (evo < 0) {evo = 0;}
    Disease newDisease = new Disease(con, inc, vir, rec, evo);
    return newDisease;
  }

}
