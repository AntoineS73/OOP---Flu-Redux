package main.map;

public class Map {

  int size;
  Case tab[][];

  public Map(int n) {
    this.size = n;
    this.tab = new Case[this.size][this.size];
    for (int y = 0; y < this.size; y++) {
      for (int x = 0; x < this.size, x++) {
        this.tab[y][x] = new Case(x, y);
      }
    }

  }
  
  public Case[][] getMap() {
    return this.tab;
  }
}
