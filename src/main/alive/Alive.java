package main.alive;

import main.*;
import main.disease.*;

public class Alive {

  double resistance;
  State etat;
  Disease maladie;
  double speed;

  public Alive(double res, double spe, State sta, Disease mal) {
    this.resistance = res * (1 + Math.random()*(0.2) - Math.random()*(0.2));
    this.speed = spe * (1 + Math.random()*(0.2) - Math.random()*(0.2));
    this.etat = sta;
    this.maladie = mal;
  }

  public Alive(double res, double spe) {
    this(res, spe, State.Healthy, new NullDisease());
  }

  public State getEtat() {
    return this.etat;
  }

  public double getSpeed() {
    return this.speed;
  }

  public double getResistance() {
    return this.resistance;
  }

  public Disease getMaladie() {
    return this.maladie;
  }

  public void setEtat(State e) {
    this.etat = e;
  }

  public void setSpeed(double s) {
    this.speed = s;
  }

  public void setResistance(double r) {
    this.resistance = r;
  }

  public void setMaladie(Disease mal) {
    this.maladie = mal;
  }

}
