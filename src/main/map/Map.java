package main.map;

import main.*;
import main.alive.*;
import main.disease.*;

public class Map {

  private int size;
  private Case tab[][];

  public Map(int n) {
    this.size = n;
    this.tab = new Case[this.size][this.size];
    for (int y = 0; y < this.size; y++) {
      for (int x = 0; x < this.size; x++) {
        Alive george = new NullAlive();
        this.tab[y][x] = new Case(x, y, george);
      }
    }

  }
  
  public Case[][] getMap() {
    return this.tab;
  }

  public Case getCase(int x, int y) {
    return this.tab[x][y];
  }

  public int counterState(Case cellule, State sta) {
    int counter = 0;
    int x = cellule.getX();
    int y = cellule.getY();
    
    if (x == 0 && y == 0) {
      if (this.tab[0][1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][0].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (x == this.size-1 && y == 0) {
      if (this.tab[0][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][this.size-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (x == 0 && y == this.size-1) {
      if (this.tab[this.size-1][1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][0].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (x == this.size-1 && y == this.size-1) { 
      if (this.tab[this.size-2][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-1][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][this.size-1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (y == 0) {
      if (this.tab[0][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[0][x+1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[1][x].getGeorge().getEtat().equals(sta))
        counter++; 
      if (this.tab[1][x+1].getGeorge().getEtat().equals(sta))
        counter++; 
    }
    else if (y == this.size-1) {
      if (this.tab[this.size-1][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-1][x+1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][x].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[this.size-2][x+1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (x == 0) {
      if (this.tab[y-1][0].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][0].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y-1][1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y][1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else if (x == this.size-1) {
      if (this.tab[y-1][this.size-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][this.size-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y-1][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][this.size-2].getGeorge().getEtat().equals(sta))
        counter++;
    }
    else {
      if (this.tab[y-1][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y-1][x].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y-1][x+1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y][x+1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][x-1].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][x].getGeorge().getEtat().equals(sta))
        counter++;
      if (this.tab[y+1][x+1].getGeorge().getEtat().equals(sta))
        counter++;
    }
    return counter;
  }

  public static void main(String [] argv) {
    Map map = new Map(100);
    map.getCase(1, 1).setGeorge(new NullAlive());
    System.out.println(map.counterState(map.getCase(0,0), State.Healthy));
    System.out.println(map.counterState(map.getCase(99,0), State.Healthy));
    System.out.println(map.counterState(map.getCase(0,99), State.Healthy));
    System.out.println(map.counterState(map.getCase(99,99), State.Healthy));
    System.out.println(map.counterState(map.getCase(0,50), State.Healthy));
    System.out.println(map.counterState(map.getCase(99,50), State.Healthy));
    System.out.println(map.counterState(map.getCase(50,99), State.Healthy));
    System.out.println(map.counterState(map.getCase(50,0), State.Healthy));
    System.out.println(map.counterState(map.getCase(50,50), State.Healthy));
    System.out.println("ok"); 
    System.out.println(map.counterState(map.getCase(50,50), State.Dead));
    System.out.println(map.counterState(map.getCase(0,0), State.NullState));
  }

}
