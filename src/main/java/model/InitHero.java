package model;

import java.util.ArrayList;

public class InitHero {

    /*

    contains hero array and is where selectHero begins
    Select hero
    set hero

     */


    private static String[] heroes = null;
//    private static ArrayList<String> herloList = new ArrayList<String>();

    public InitHero() {

    }

    public String[] getHeroes() {
        return heroes;
    }

    public void setHeroes(String[] demoHeroes) {
        this.heroes = demoHeroes;
    }
}
