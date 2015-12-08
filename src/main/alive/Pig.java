package main.alive;

import main.*;
import main.disease.*;

public class Pig extends Alive {

  public Pig(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Pig(double res, double spe) {
    super(res, spe, State.Healthy, new NullDisease());
  }

  public Pig(State sta, Disease mal) {
    super(0.5, 0, sta, mal);
  }

  public Pig() {
    super(0.5, 0, State.Healthy, new NullDisease());
  }


}
