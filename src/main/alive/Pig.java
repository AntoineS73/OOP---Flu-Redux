package main.alive;

import main.disease.*;

/**
 *
 */
public class Pig extends Alive {
    /**
     *
     * @param res
     * @param spe
     * @param sta
     * @param mal
     */
    public Pig(double res, double spe, State sta, Disease mal) {
        super(res, spe, sta, mal);
    }

    /**
     *
     * @param res
     * @param spe
     */
    public Pig(double res, double spe) {
        super(res, spe, State.Healthy, new NullDisease());
    }

    /**
     *
     * @param sta
     * @param mal
     */
    public Pig(State sta, Disease mal) {
        super(0.5, 0, sta, mal);
    }

    /**
     *
     */
    public Pig() {
        super(0.5, 0, State.Healthy, new NullDisease());
    }


}
