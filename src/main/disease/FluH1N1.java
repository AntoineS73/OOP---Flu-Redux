package main.disease;

import main.alive.Human;
import main.alive.Pig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Representation of the disease H1N1
 *
 * @author Axel Aiello and Antoine Steyer
 * @version 2016.01.04
 */
public class FluH1N1 extends Disease {

    private static final double CONTAGIOUS = 0;
    private static final double INCUBATION = 0;
    private static final double VIRULENCE = 0;
    private static final double RECOVERY = 0;
    private static final double EVOLUTION = 0;
    private static final List<Class> COMPATIBLE =
            Collections.unmodifiableList(Arrays.asList(Pig.class, Human.class));

    public FluH1N1() {
        super(CONTAGIOUS, INCUBATION, VIRULENCE, RECOVERY, EVOLUTION, COMPATIBLE);
    }
}
