package main;

import main.alive.*;
import main.disease.*;
import main.map.*;

/**
 *
 */
public class Main {

    private Map map;

    /**
     *
     */
    public Main() {
        this.map = new Map(100);
        map.getCase(1, 1).setGeorge(new NullAlive());
        System.out.println(map.counterState(map.getCase(0, 0), State.Healthy));
        System.out.println(map.counterState(map.getCase(99, 0), State.Healthy));
        System.out.println(map.counterState(map.getCase(0, 99), State.Healthy));
        System.out.println(map.counterState(map.getCase(99, 99), State.Healthy));
        System.out.println(map.counterState(map.getCase(0, 50), State.Healthy));
        System.out.println(map.counterState(map.getCase(99, 50), State.Healthy));
        System.out.println(map.counterState(map.getCase(50, 99), State.Healthy));
        System.out.println(map.counterState(map.getCase(50, 0), State.Healthy));
        System.out.println(map.counterState(map.getCase(50, 50), State.Healthy));
        System.out.println("ok");
        System.out.println(map.counterState(map.getCase(50, 50), State.Dead));
        System.out.println(map.counterState(map.getCase(0, 0), State.NullState));
    }

    /**
     *
     * @param argv
     */
    public static void main(String[] argv) {
        Main main = new Main();
    }

}
