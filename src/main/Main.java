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
        this.map = new Map(50);
        this.map.initialMap();
        readMap(50);
    }
    
    public void readMap(int size) {
      String str = "";
      for (int y = 0; y < size; y++) {
        for (int x = 0; x < size; x++) {
          str = str + "- ";
        }
        str = str + "\n";
        for (int x = 0; x < size; x++) {
          if (this.map.getCase(y,x).getGeorge().equals(new NullAlive())) 
            str = str + " |";
          else 
            str = str + "X|";
        }
        str = str + "\n";
      }
      System.out.println(str);
    }

    /**
     *
     * @param argv
     */
    public static void main(String[] argv) {
        Main main = new Main();
    }

}
