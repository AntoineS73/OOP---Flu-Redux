package disease;

import alive.Human;
import alive.Pig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Representation of the disease H1N1
 *
 * @author Axel Aiello and Antoine Steyer
 * @version 2016.01.05
 */
public class FluH1N1 extends Disease {

    private static final double CONTAGIOUS = 0.9;
    private static final int INCUBATION_TIME = 5;
    private static final double VIRULENCE = 0.6;
    private static final double RECOVERY = 0.05;
    private static final int RECOVERY_TIME = 20;
    private static final double EVOLUTION = 0;
    private static final List<Class> COMPATIBLE =
            Collections.unmodifiableList(Arrays.asList(Pig.class, Human.class));

    public FluH1N1() {
        super(CONTAGIOUS, INCUBATION_TIME, VIRULENCE, RECOVERY, RECOVERY_TIME, EVOLUTION, COMPATIBLE);
    }
}
