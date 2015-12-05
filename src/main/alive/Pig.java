package main.alive;

public class Pig extends Alive {

  public Pig(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Pig(double res, double spe) {
    super(res, spe, State.Healthy, null);
  }

  public Pig(State sta, Disease mal) {
    super(0.5, 0, sta, mal);
  }

  public Pig() {
    super(0.5, 0, State.Healthy, null);
  }


}
