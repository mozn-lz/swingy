package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.view.GuiMain;
import za.wethinkcode.swingy.view.console.PrintContent;
import za.wethinkcode.swingy.view.gui.*;

import java.util.Random;

public class InitGame {

    Hero hero = new Hero();
    int mapSize = setMapSize(hero.heroLevel);
    private String[][] map = new String[mapSize][mapSize];
    private static int playMode = 0;

    public InitGame() {
        hero.setCoordenateX(mapSize/2);
		hero.setCoordenateY(mapSize/2);
	}
	
	public int setMapSize(int level) {
		int mapSize = (level - 1) * 5 + 10 - (level % 2);
        hero.setMapSize(mapSize);
        return (mapSize);
    }

    public String[][] createMap(String[][] map, int size) {
        int enemyCout = size/3;
        String heroSym = "H";
        String enemySym = "E";
        String blank = "*";

        if (enemyCout <= 0){
            enemyCout++;
        }
        int enemies[] = new int [enemyCout];
        for (int i = 0; i < size; i++) {
            for (int l = 0; l < enemyCout; l++) {       //  Get/Create enemy locations
                enemies[l] = getEnemy(size);
            }
            for (int j = 0; j < size; j++) {        //  PLACE COMPONENTS ONTO MAP
                map[i][j] = blank;
                for (int k = 0; k < enemyCout; k++) {
                    if (j == enemies[k]) {    // if enemy position
                        map[i][j] = enemySym;
                    }
                }
                if (i == hero.getCoordenateY() && j == hero.getCoordenateX()) {		// if hero position
                    map[i][j] = heroSym;
                }
            }
		}
		return map;
    }

    private int getEnemy(int max) {
        Random r = new Random();
        int rtn = r.nextInt(max);
        return rtn;
    }
}
