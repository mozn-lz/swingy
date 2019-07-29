package model;

import java.util.ArrayList;
import java.util.List;

public class InitGame {
    public InitGame(String heroName) {
        System.out.println("heroName = " + heroName);
    }
//    private ArrayList <String> hero = new ArrayList<String>();

    public int setMapSize(int level) {
        int mapSize =  (level - 1) * 5 + 10 - (level % 2);
        System.out.println("mapSize = " + mapSize);
        return (mapSize);
    }
}
