package main.alive;

import main.disease.*;

public class Human extends Alive {

  public Human(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Human(double res, double spe) {
    super(res, spe, State.Healthy, new NullDisease());
  }

  public Human(State sta, Disease mal) {
    super(0.7, 1, sta, mal);
  }

  public Human() {
    super(0.7, 1, State.Healthy, new NullDisease());
  }

  public static void main(String[] argv) {
    Alive george = new Human();
    System.out.println(george.getResistance());
    System.out.println(george.getSpeed());
  }

}
