package main.alive;

public class Chicken extends Animal {

  int resistance;
  State etat;
  int speed;

  public Human() {
    this.resistance = 0.7 * (1 + Math.random()*(0.2) - Math.random()*(0.2));
    this.speed = 0;
    this.etat = State.Healthy;
  }

  public State getEtat() {
    return this.etat;
  }

  public int getSpeed() {
    return this.speed;
  }

  public int getResistance() {
    return this.resistance;
  }

  public void setEtat(State e) {
    this.etat = e;
  }


}
