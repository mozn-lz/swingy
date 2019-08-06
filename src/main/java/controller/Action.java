package controller;

import model.Hero;
import model.PlayGame;

import java.util.Scanner;

public class Action {
    Hero hero = new Hero();
    public Action() {
//        Action act = new Action();
        String choice = null;
        Scanner input = new Scanner(System.in);

        System.out.println();
        while(choice == null) {
            System.out.println("You have encountered an enemy, Do you want to fight or run?");
            choice = input.nextLine();
            switch (choice.toLowerCase()) {
                case "fight": fight(hero);
                    break;
                case "run":
                    run(hero);
                    break;
                default:
//                    System.out.println("Invalid option");
                    choice = null;
            }
        }
    }
    public void move(Hero hero, String[][] map) {
        Scanner in = new Scanner(System.in);
        String direction = null;
        this.hero = hero;

        while (direction  == null) {
            System.out.println("Type 'W' to go up, 'A' to go left, 'D' to go right and 'S' to go down");
            direction = in.nextLine();
            switch (direction.toLowerCase()) {
                case"w":
//                    System.out.println("hero.getCoordenateY() = " + hero.getCoordenateY());
                    if (map[hero.getCoordenateY() -1][hero.getCoordenateX()] == "E") {
                        new Action();
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateY(hero.getCoordenateY() -1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"a":
                    if (map[hero.getCoordenateY()][hero.getCoordenateX() -1] == "E") {
                        new Action();
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateX(hero.getCoordenateX() -1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"s":
                    if (map[hero.getCoordenateY() + 1][hero.getCoordenateX()] == "E") {
                        new Action();
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateY(hero.getCoordenateY() + 1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"d":
                    if (map[hero.getCoordenateY()][hero.getCoordenateX() + 1] == "E") {
                        new Action();
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateX(hero.getCoordenateX() + 1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                default:
                    System.out.println("Invalid input '" + direction + "'");
                    direction = null;
            }
        }
        System.out.println();
    }

    public void fight(Hero hero) {
        hero.setAttack(hero.getAttack() - 10);
        hero.setDefense(hero.getDefense() - 20);
        if (hero.getDefense() > 0) {		// if hero Survives
            hero.setExp(hero.getExp() + 500);
        } else if (hero.getDefense() <= 0) {		// if hero gets Killed
            hero.setExp(0);
            hero.setDefense(0);
        }
    }

    public void run(Hero hero) {
        if (hero.getDefense() > 0) {		// if hero Survives
            if ((hero.getExp() - 10) < 0) {
                hero.setExp(hero.getExp() - 10);
            }
            else {
                hero.setExp(0);
            }
        } else if (hero.getDefense() <= 0) {		// if hero gets Killed
            hero.setExp(0);
            hero.setDefense(0);
        }
    }
}
