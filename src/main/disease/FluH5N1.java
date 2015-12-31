package main.disease;

import main.alive.Chicken;
import main.alive.Duck;
import main.alive.Human;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Antoine on 30/12/2015.
 */
public class FluH5N1 extends Disease {

    private static final double CONTAGIOUS = 0;
    private static final double INCUBATION = 0;
    private static final double VIRULENCE = 0;
    private static final double RECOVERY = 0;
    private static final double EVOLUTION = 0;
    private static final List<Class> COMPATIBLE =
            Collections.unmodifiableList(Arrays.asList(Chicken.class, Duck.class, Human.class));

    public FluH5N1() {
        super(CONTAGIOUS, INCUBATION, VIRULENCE, RECOVERY, EVOLUTION, COMPATIBLE);
    }
}
