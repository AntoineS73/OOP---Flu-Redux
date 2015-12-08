package main.alive;

import main.disease.*;

public class NullAlive extends Alive {

  public NullAlive() {
    super(0, 0, State.NullState, new NullDisease());
  }

}

