package main.map;

import main.alive.*;
import main.disease.*;
//import java.lang.reflect.Type;

/**
 *
 */
public class Map {

    private int size;
    private Case tab[][];

    /**
     * @param n
     */
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

    /**
     * @return
     */
    public Case[][] getMap() {
        return this.tab;
    }

    /**
     * @param x
     * @param y
     * @return
     */
    public Case getCase(int y, int x) {
        return this.tab[y][x];
    }

    public void initialMap() {
      initialMap((int) (0.05 * this.size * this.size), (int) (0.05 * this.size * this.size), (int) (0.05 * this.size * this.size), (int) (0.35 * this.size * this.size), (int) (0.05 * this.size * this.size));
    }

    public void initialMap(int nbrPig, int nbrDuck, int nbrChicken, int nbrHuman, int nbrDisease) {
      insert(Pig.class, nbrPig);
      insert(Duck.class, nbrDuck);
      insert(Chicken.class, nbrChicken);
      System.out.println("\nCreation de la map : 25% \n");
      for (int i = 0; i < (int) (0.4 * this.size);) {
         int x = (int) (Math.random() * (this.size));
         int y = (int) (Math.random() * (this.size));
         if (this.tab[y][x].getGeorge().equals(new NullAlive())) {
           this.tab[y][x].setGeorge(new Human());
           i++;
         }
      }
      System.out.println("Creation de la map : 50% \n");
      for (int i = 0; i < (nbrHuman - (int) (0.4 * this.size));) {
         int x = (int) (Math.random() * (this.size));
         int y = (int) (Math.random() * (this.size));
         if (this.tab[y][x].getGeorge().equals(new NullAlive()) && counterState(this.tab[y][x], State.NullState) != 8) {
           this.tab[y][x].setGeorge(new Human());
           i++;
         }
      }
      System.out.println("Creation de la map : 100% \n");
    }


    public void insert(Class alive, int nbr) {
      for (int i = 0; i < nbr;) {
         int x = (int) (Math.random() * (this.size)); 
         int y = (int) (Math.random() * (this.size));
         try {
           if (this.tab[y][x].getGeorge().equals(new NullAlive())) {
             this.tab[y][x].setGeorge((Alive) alive.newInstance());
             i++;
           }
         }
         catch (Exception e) {
           throw new RuntimeException(e);
         }
      }
    }

    public void move(Case cellule) {
      int x = cellule.getX();
      int y = cellule.getY();
      Alive george = cellule.getGeorge();
      for (int i = -1; i < 2; i++) {
        for (int j = -1; j < 2; j++) {
        } 
      }
    }

    public int caseEmpty(Case cellule, State sta) {
        int x = cellule.getX();
        int y = cellule.getY();
	ArrayList<int> list = new ArrayList<int>();

        if (x == 0 && y == 0) {
            if (this.tab[0][1].getGeorge().equals(new NullAlive))
                list.add(0 * this.size + 1);
            if (this.tab[1][0].getGeorge().equals(new NullAlive))
                list.add(1 * this.size + 0);
            if (this.tab[1][1].getGeorge().getEtat().equals(sta))
                list.add(1 * this.size + 1);
        } else if (x == this.size - 1 && y == 0) {
            if (this.tab[0][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == 0 && y == this.size - 1) {
            if (this.tab[this.size - 1][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == this.size - 1 && y == this.size - 1) {
            if (this.tab[this.size - 2][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (y == 0) {
            if (this.tab[0][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[0][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (y == this.size - 1) {
            if (this.tab[this.size - 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == 0) {
            if (this.tab[y - 1][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == this.size - 1) {
            if (this.tab[y - 1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
        } else {
            if (this.tab[y - 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        }
        return counter;
    }



    /**
     * @param cellule
     * @param sta
     * @return
     */
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
        } else if (x == this.size - 1 && y == 0) {
            if (this.tab[0][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == 0 && y == this.size - 1) {
            if (this.tab[this.size - 1][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == this.size - 1 && y == this.size - 1) {
            if (this.tab[this.size - 2][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (y == 0) {
            if (this.tab[0][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[0][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (y == this.size - 1) {
            if (this.tab[this.size - 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[this.size - 2][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == 0) {
            if (this.tab[y - 1][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][0].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][1].getGeorge().getEtat().equals(sta))
                counter++;
        } else if (x == this.size - 1) {
            if (this.tab[y - 1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][this.size - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][this.size - 2].getGeorge().getEtat().equals(sta))
                counter++;
        } else {
            if (this.tab[y - 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y - 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x - 1].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x].getGeorge().getEtat().equals(sta))
                counter++;
            if (this.tab[y + 1][x + 1].getGeorge().getEtat().equals(sta))
                counter++;
        }
        return counter;
    }


}
