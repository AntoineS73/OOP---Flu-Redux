package main.disease;

public class Disease {

  private double contagiousness; //contagiosité passage santé-->porteur
  private double incubation;     //incubation passage porteur-->malade
  private double virulence;      //virulence passage malade-->mort
  private double recovery;       //récupération passage malade-->santé
  private double evolution;      //caracthère évolutif

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

  public void Mutation() {
    this.contagiousness = this.contagiousness + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    this.incubation = this.incubation + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    this.virulence = this.virulence + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    this.recovery = this.recovery + Math.random()*(this.evolution) - Math.random()*(this.evolution);
    this.evolution = this.evolution + Math.random()*(this.evolution * 0.1) - Math.random()*(this.evolution * 0.1);
    if (this.contagiousness < 0) {this.contagiousness = 0;}
    if (this.incubation < 0) {this.incubation = 0;}
    if (this.virulence < 0) {this.virulence = 0;}
    if (this.recovery < 0) {this.recovery = 0;}
    if (this.evolution < 0) {this.evolution = 0;}
  }

}
