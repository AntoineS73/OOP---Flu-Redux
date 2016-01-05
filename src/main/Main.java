package main;

import main.simulator.SimulateStep;
import main.simulator.Simulator;

import java.util.Timer;

public class Main {

    static Timer timer;

    public static void main(String[] args) {

        timer = new Timer();
        SimulateStep s = new SimulateStep(new Simulator());

        timer.scheduleAtFixedRate(s, 0, 1000);


    }
}
