package controller;

import model.Enemy;
import model.Hero;
import model.PlayGame;
import model.Terminate;
import view.console.PrintContent;

import java.util.Scanner;

public class Action {
    Hero hero = new Hero();
    Enemy enemy = new Enemy(hero.getHeroLevel());
    private int attack  = 0;
    private int defense = 0;
    private int helm    = 0;
    public Action() {
    }

    public Action(Hero hero) {//        Action act = new Action();
        String choice = null;
        Scanner input = new Scanner(System.in);

//        PrintContent();
        while(choice == null) {
//            PrintContent();
            new PrintContent("You have encountered an enemy, Do you want to fight or run?");
//            hero Spects
            new PrintContent("Hero Attack:" + hero.getAttack() + "\t" + "Hero Defence: " + hero.getDefense() + "\t" + "Hero Helm: " + hero.getHelm());
//            enemy Spects
            attack = enemy.getAttack();
            defense = enemy.getDefense();
            helm = enemy.getHelm();
//            PrintContent();
            new PrintContent("Enemy Attack:" + attack + "\t" + "Enemy Defence: " + defense + "\t" + "Enemy Helm: " + helm);
//            PrintContent();
            choice = input.nextLine();
            switch (choice.toLowerCase()) {
                case "fight": fight(hero);
                    break;
                case "run":
                    run(hero);
                    break;
                default:
                    new PrintContent("Invalid option");
                    choice = null;
            }
        }
    }

    public void move(Hero hero, String[][] map) {
        Scanner in = new Scanner(System.in);
        String direction = null;
        this.hero = hero;

        while (direction  == null) {
            new PrintContent("Type 'W' to go up, 'A' to go left, 'D' to go right and 'S' to go down");
            direction = in.nextLine();
            switch (direction.toLowerCase()) {
                case"w":
                    if (hero.getCoordenateY() -1 < 0) {
                        new Terminate("win");
                    }
                    if (map[hero.getCoordenateY() -1][hero.getCoordenateX()] == "E") {
                        new Action(hero);
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateY(hero.getCoordenateY() -1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"a":
                    if (hero.getCoordenateX() -1 < 0) {
                        new Terminate("win");
                    }
                    if (map[hero.getCoordenateY()][hero.getCoordenateX() -1] == "E") {
                        new Action(hero);
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateX(hero.getCoordenateX() -1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"s":
                    if (hero.getCoordenateY() +1 >= map.length) {
                        new Terminate("win");
                    }
                    if (map[hero.getCoordenateY() + 1][hero.getCoordenateX()] == "E") {
                        new Action(hero);
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateY(hero.getCoordenateY() + 1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                case"d":
                    if (hero.getCoordenateX() +1 >= map.length) {
                        new Terminate("win");
                    }
                    if (map[hero.getCoordenateY()][hero.getCoordenateX() + 1] == "E") {
                        new Action(hero);
                    }
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "*";
                    hero.setCoordenateX(hero.getCoordenateX() + 1);
                    map[hero.getCoordenateY()][hero.getCoordenateX()] = "H";
                    break;
                default:
                    new PrintContent("Invalid input '" + direction + "'");
                    direction = null;
            }
        }
        new PrintContent();
    }

    public void fight(Hero hero) {
        hero.setAttack(hero.getAttack() - enemy.getDefense());
        hero.setDefense(hero.getDefense() - enemy.getAttack());
        if (hero.getDefense() > 0) {		// if hero Survives
            hero.setExp(hero.getExp() + 500);
        } else if (hero.getDefense() <= 0) {		// if hero gets Killed
            hero.setExp(hero.getExp() - 250);
            hero.setDefense(0);
        }
    }

    public void run(Hero hero) {
        if (hero.getDefense() > 0) {		// if hero Survives
            if (hero.getExp() - (enemy.getAttack()/2) < 0) {
                hero.setExp(hero.getExp() + 10);
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