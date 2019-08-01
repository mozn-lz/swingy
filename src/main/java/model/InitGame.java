package model;

import view.DrawMap;

import java.util.ArrayList;
import java.util.List;

public class InitGame {
    public InitGame() {
        Hero hero = new Hero();
        int mapSize = setMapSize(hero.heroLevel);
        hero.setCoordenateX((mapSize/2));
        hero.setCoordenateY((mapSize/2));
        new DrawMap(mapSize);
    }
//    private ArrayList <String> hero = new ArrayList<String>();

    public int setMapSize(int level) {
        int mapSize =  (level - 1) * 5 + 10 - (level % 2);
        System.out.println("mapSize = " + mapSize);
        return (mapSize);
    }
}
