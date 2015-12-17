package main.alive;

import main.disease.*;

/**
 *
 */
public class Human extends Alive {
    /**
     *
     * @param res
     * @param spe
     * @param sta
     * @param mal
     */
    public Human(double res, double spe, State sta, Disease mal) {
        super(res, spe, sta, mal);
    }

    /**
     *
     * @param res
     * @param spe
     */
    public Human(double res, double spe) {
        super(res, spe, State.Healthy, new NullDisease());
    }

    /**
     *
     * @param sta
     * @param mal
     */
    public Human(State sta, Disease mal) {
        super(0.7, 1, sta, mal);
    }

    /**
     *
     */
    public Human() {
        super(0.7, 1, State.Healthy, new NullDisease());
    }

}
