package main.alive;

import main.disease.*;

/**
 *
 */
public class Chicken extends Alive {

    /**
     *
     * @param res
     * @param spe
     * @param sta
     * @param mal
     */
    public Chicken(double res, double spe, State sta, Disease mal) {
        super(res, spe, sta, mal);
    }

    /**
     *
     * @param res
     * @param spe
     */
    public Chicken(double res, double spe) {
        super(res, spe, State.Healthy, new NullDisease());
    }

    /**
     *
     * @param sta
     * @param mal
     */
    public Chicken(State sta, Disease mal) {
        super(0.5, 0, sta, mal);
    }

    /**
     *
     */
    public Chicken() {
        super(0.5, 0, State.Healthy, new NullDisease());
    }

}
