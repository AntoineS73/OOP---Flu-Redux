package main.disease;

import main.alive.Chicken;
import main.alive.Duck;
import main.alive.Human;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Representation of the disease H5N1
 *
 * @author Axel Aiello and Antoine Steyer
 * @version 2016.01.05
 */
public class FluH5N1 extends Disease {

    private static final double CONTAGIOUS = 0.6;
    private static final int INCUBATION_TIME = 8;
    private static final double VIRULENCE = 0.25;
    private static final double RECOVERY = 0.3;
    private static final int RECOVERY_TIME = 10;
    private static final double EVOLUTION = 0;
    private static final List<Class> COMPATIBLE =
            Collections.unmodifiableList(Arrays.asList(Chicken.class, Duck.class, Human.class));

    public FluH5N1() {
        super(CONTAGIOUS, INCUBATION_TIME, VIRULENCE, RECOVERY, RECOVERY_TIME, EVOLUTION, COMPATIBLE);
    }
}
