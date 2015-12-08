package main.alive;

import main.disease.*;

public class Duck extends Alive {

  public Duck(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Duck(double res, double spe) {
    super(res, spe, State.Healthy, new NullDisease());
  }

  public Duck(State sta, Disease mal) {
    super(0.5, 0, sta, mal);
  }

  public Duck() {
    super(0.5, 0, State.Healthy, new NullDisease());
  }

}
