package main.utils;

import main.disease.State;

import java.awt.*;
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

    /**
     * Define the colors for all alives
     */
    public Colors(){

        // Define colors for Human's different states
        this.HumanColors.put(State.HEALTHY, Color.BLACK);
        this.HumanColors.put(State.SICK, Color.LIGHT_GRAY);
        this.HumanColors.put(State.CONTAGIOUS, Color.GRAY);
        this.HumanColors.put(State.RECOVERING, new Color(84,79,79));

        // Define colors for Chicken's different states
        this.ChickenColors.put(State.HEALTHY, Color.RED);
        this.ChickenColors.put(State.SICK, Color.PINK);
        this.ChickenColors.put(State.CONTAGIOUS, Color.ORANGE);
        this.ChickenColors.put(State.RECOVERING, Color.MAGENTA);

        // Define colors for Duck's different states
        this.DuckColors.put(State.HEALTHY, new Color(2, 154, 40));
        this.DuckColors.put(State.SICK, new Color(108, 156, 45));
        this.DuckColors.put(State.CONTAGIOUS, Color.GREEN);
        this.DuckColors.put(State.RECOVERING, new Color(70, 116, 41));

        // Define colors for Pig's different states
        this.PigColors.put(State.HEALTHY, new Color(39, 11, 164));
        this.PigColors.put(State.SICK, Color.CYAN);
        this.PigColors.put(State.CONTAGIOUS, Color.BLUE);
        this.PigColors.put(State.RECOVERING, new Color(94, 53,133));
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
