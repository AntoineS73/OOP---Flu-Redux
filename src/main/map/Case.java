package main.map;

public class Case {

  int x;
  int y;
  Alive george;

  public Case(int posX, int posY, Alive alive) {
    this.x = posX;
    this.y = posY;
    this.george = new Alive();
    this.george = alive;
  }

  public int getX() {
    return this.x; 
  }

  public int getY() {
    return this.y;
  }

  public Alive getGeorge() {
    return this.george;
  }

  public void setGeorge(Alive p) {
    this.george = p;
  }
}
