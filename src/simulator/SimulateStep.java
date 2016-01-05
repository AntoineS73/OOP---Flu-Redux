package simulator;

import java.util.TimerTask;

public class SimulateStep extends TimerTask {

    private Simulator simulator;

    public SimulateStep(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void run() {
        if (!simulator.allHealthy()) {
            simulator.simulateOneStep();
        }
    }
}
