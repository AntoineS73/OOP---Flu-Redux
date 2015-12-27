package main;

import main.map.*;
import main.alive.*;
import main.disease.*;

public class Main {

    public static void main(String[] args) {
        Simulator s = new Simulator();
        s.simulate(1000);
    }
}
