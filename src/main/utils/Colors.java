package main.utils;

import main.disease.State;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * An util class to define and store the colors for the representation
 * of all types of alives depends of their states
 *
 * @author Axel Aiello and Antoine Steyer
 * @version 2016.01.02
 */
public class Colors {

    private Map<State, Color> HumanColors;
    private Map<State, Color> ChickenColors;
    private Map<State, Color> DuckColors;
    private Map<State, Color> PigColors;

    private static final Color DARK_GRAY = new Color(84, 79, 79);
    private static final Color DARK_GREEN = new Color(2, 154, 40);
    private static final Color OLIVE = new Color(108, 156, 45);
    private static final Color KAKI = new Color(70, 116, 41);
    private static final Color NIGHT_BLUE = new Color(39, 11, 164);
    private static final Color PURPLE = new Color(94, 53, 133);


    /**
     * Define the colors for all alives
     */
    public Colors() {

        HumanColors = new HashMap<>();
        ChickenColors = new HashMap<>();
        DuckColors = new HashMap<>();
        PigColors = new HashMap<>();

        // Define colors for Human's different states
        HumanColors.put(State.HEALTHY, Color.BLACK);
        HumanColors.put(State.SICK, Color.LIGHT_GRAY);
        HumanColors.put(State.CONTAGIOUS, Color.GRAY);
        HumanColors.put(State.RECOVERING, DARK_GRAY);

        // Define colors for Chicken's different states
        ChickenColors.put(State.HEALTHY, Color.RED);
        ChickenColors.put(State.SICK, Color.PINK);
        ChickenColors.put(State.CONTAGIOUS, Color.ORANGE);
        ChickenColors.put(State.RECOVERING, Color.MAGENTA);

        // Define colors for Duck's different states
        DuckColors.put(State.HEALTHY, DARK_GREEN);
        DuckColors.put(State.SICK, OLIVE);
        DuckColors.put(State.CONTAGIOUS, Color.GREEN);
        DuckColors.put(State.RECOVERING, KAKI);

        // Define colors for Pig's different states
        PigColors.put(State.HEALTHY, NIGHT_BLUE);
        PigColors.put(State.SICK, Color.CYAN);
        PigColors.put(State.CONTAGIOUS, Color.BLUE);
        PigColors.put(State.RECOVERING, PURPLE);
    }


    public Map<State, Color> getHumanColors() {
        return HumanColors;
    }

    public Map<State, Color> getChickenColors() {
        return ChickenColors;
    }

    public Map<State, Color> getDuckColors() {
        return DuckColors;
    }

    public Map<State, Color> getPigColors() {
        return PigColors;
    }

}
