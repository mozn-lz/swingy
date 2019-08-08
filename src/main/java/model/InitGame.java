package model;

import java.util.Random;

public class InitGame {

    Hero hero = new Hero();
    int mapSize = setMapSize(hero.heroLevel);
    private String[][] map = new String[mapSize][mapSize];

    public InitGame() {
        hero.setCoordenateX(mapSize/2);
        hero.setCoordenateY(mapSize/2);
        createMap(mapSize);
        new PlayGame(hero, map, mapSize);
    }

    public int setMapSize(int level) {
        int mapSize = (level - 1) * 5 + 10 - (level % 2);
        System.out.println("mapSize = " + mapSize);
        return (mapSize);
    }

    public void createMap(int size) {
//        Hero hero = new Hero();

        int enemyCout = size/3;
        boolean findIndicator = false;
        String heroSym = "H";
        String enemySym = "E";
        String blank = "*";

        if (enemyCout <= 0){
            enemyCout++;
        }
        System.out.println("enemyCout = " + enemyCout);
        int enemies[] = new int [enemyCout];
        new Random(size);

        for (int i = 0; i < size; i++) {
            for (int l = 0; l < enemyCout; l++) {
                enemies[l] = getEnemy(size);
            }
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < enemyCout; k++) {		// if hero position
                    if ((i == hero.getCoordenateY() && j == hero.getCoordenateX()) && (j == enemies[k])) {       //  if an enemy is encoutered
                        findIndicator = true;
                    }
                    if (i == hero.getCoordenateY() && j == hero.getCoordenateX()) {
                        map[i][j] = heroSym;
                    } else if (j == enemies[k]) {    // if enemy position
                        map[i][j] = enemySym;
                    } else {
                        map[i][j] = blank;
                    }
                }
            }
            System.out.println();
        }
//        if (findIndicator == true) {
//            new Action();
//        }
    }

    private int getEnemy(int max) {
        Random r = new Random();
        int rtn = r.nextInt(max);
        return rtn;
    }
}
