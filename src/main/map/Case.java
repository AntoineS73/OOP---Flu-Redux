package main.map;

import main.alive.*;
import main.disease.*;

/**
 *
 */
public class Case {

    int x;
    int y;
    Alive george;

    /**
     *
     * @param posX
     * @param posY
     * @param alive
     */
    public Case(int posX, int posY, Alive alive) {
        this.x = posX;
        this.y = posY;
        this.george = alive;
    }

    /**
     *
     * @param posX
     * @param posY
     */
    public Case(int posX, int posY) {
        this.x = posX;
        this.y = posY;
        this.george = new NullAlive();
    }

    /**
     *
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     *
     * @return
     */
    public Alive getGeorge() {
        return this.george;
    }

    /**
     *
     * @param p
     */
    public void setGeorge(Alive p) {
        this.george = p;
    }
}
