package main.alive;

public class Chicken extends Alive {


  public Chicken(double res, double spe, State sta, Disease mal) {
    super(res, spe, sta, mal);
  }

  public Chicken(double res, double spe) {
    super(res, spe, State.Healthy, null);
  }

  public Chicken(State sta, Disease mal) {
    super(0.5, 0, sta, mal);
  }

  public Chicken() {
    super(0.5, 0, State.Healthy, null);
  }

}
