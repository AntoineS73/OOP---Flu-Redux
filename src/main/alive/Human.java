package main.alive;

public class Human extends Alive {

  public Human(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Human(double res, double spe) {
    super(res, spe, State.Healthy, null);
  }

  public Human(State sta, Disease mal) {
    super(0.7, 1, sta, mal);
  }

  public Human() {
    super(0.7, 1, State.Healthy, mal);
  }

}
