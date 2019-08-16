package model;

import view.console.PrintContent;

import java.util.ArrayList;
import java.util.Scanner;

public class InitHero {

    private static ArrayList<String> heroes = new ArrayList<>();

    public InitHero() {
    }

    public ArrayList<String> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<String> arrHeros) {
        heroes = arrHeros;
    }

    public void selectHero() {
        Scanner in = new Scanner(System.in);
        Hero hero = new Hero();
        String newName = null;
        int classIndex = 0;

        for (boolean i = false; i == false; ) {
            String [][] heroList =  displayHeroList(heroes);
            new PrintContent("Select a hero number or 0 to create a custom hero");
            int choice = in.nextInt();
            if (choice >=1 && choice <= heroList.length) {
                choice--;
                hero.setName(heroList[choice][0]);
                hero.setHeroClass(heroList[choice][1]);
                hero.setExp(Integer.parseInt( heroList[choice][3]));
                hero.setAttack(Integer.parseInt( heroList[choice][4]));
                hero.setDefense(Integer.parseInt( heroList[choice][5]));
                hero.setHelm(Integer.parseInt( heroList[choice][6]));
                hero.setHeroLevel(Integer.parseInt( heroList[choice][2]));
                new PrintContent("You chose " + hero.getName() + " of class "+ hero.getHeroClass() + "\tlevel " + hero.getHeroLevel());
                new PrintContent("\t\tEXP of " + hero.getExp() + "\nAtack " + hero.getAttack() +"\tDefense "+ hero.getDefense() + "\tHelm "+ hero.getHelm());
                return;
            }
            if (choice - 1 == -1) {
                while (!(newName == null) || !(classIndex < 0 && classIndex > heroes.size())) {
                    newName = null;
                    classIndex = 0;
                    new PrintContent("Hero name?");
                    String nchoice = in.nextLine();
                    newName = in.nextLine();
                    new PrintContent("Hero class?");
                    for (int j = 0; j < heroes.size(); j++) {
                        System.out.print(j+1 + ". " + heroList[j][1] + "\t");
                    }
                    new PrintContent();
                    classIndex = in.nextInt();
                    System.out.print("newName = " + newName);
                    new PrintContent(", classIndex = " + heroList[classIndex - 1][1]);
                }
                System.out.print("newName = " + newName);
                new PrintContent(", classIndex = " + classIndex);
                String [] newhero =  createHero(newName.replaceAll("\\s+",""), heroList[classIndex-1]);
                heroes.add(String.valueOf(newhero));
            }
        }
    }

    private String[] createHero(String newName, String[] loadHero) {
        String [] newHero = null;

        new PrintContent("weolcoe: ");
        new PrintContent("newName = " + newName);
        newHero[0] = newName;      //  name
        newHero[1] = loadHero[1];  //  class
        newHero[2] = loadHero[2];  //  level
        newHero[3] = "0";  //  exp
        newHero[4] = loadHero[4];  //  atack
        newHero[5] = loadHero[5];  //  defence
        newHero[6] = loadHero[6];  //  hit
        return newHero;
    }

    private String[][] displayHeroList(ArrayList<String> heroes) {
        String [][] list = new String[heroes.size()][7];
        for (int i = 0; i < heroes.size(); i++) {
            list[i] = heroes.get(i).split("\t");
        }
        new PrintContent("\t\t_____Hero List_____");
        for (int i = 0; i < heroes.size(); i++) {
            new PrintContent((i + 1) + ". " + list[i][0] +
                    " of Class " + list[i][1] +
                    "\tLevel : " + list[i][2] +
                    "\tEXP : " + list[i][3] +
                    "\tAttack: " + list[i][4] +
                    "\tDefence: " + list[i][5] +
                    "\tHit Points: " + list[i][6]);
        }
        return list;
    }

    public void updateHeroes(Hero hero) {
        String currentHero = hero.getName() + "\t" +
                hero.getHeroClass() + "\t" +
                hero.getHeroLevel() + "\t" +
                hero.getExp() + "\t" +
                hero.getAttack() + "\t" +
                hero.getDefense() + "\t" +
                hero.getHelm();
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i) == currentHero) {
                heroes.set(i, currentHero);
            }
        }
    }
}
