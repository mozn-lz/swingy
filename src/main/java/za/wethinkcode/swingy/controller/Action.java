package za.wethinkcode.swingy.controller;

import za.wethinkcode.swingy.model.Enemy;
import za.wethinkcode.swingy.model.Hero;
import za.wethinkcode.swingy.model.PlayGame;
import za.wethinkcode.swingy.model.Save;
import za.wethinkcode.swingy.model.Terminate;
import za.wethinkcode.swingy.view.console.PrintContent;

import java.util.Scanner;

public class Action {
	Hero hero = new Hero();
	Enemy enemy = new Enemy(hero.getHeroLevel());

	private int attack			= 0;
	private int defense			= 0;
	private int hitPoints		= 0;

	public Action() {
	}

	public Action(Hero hero) {//        Action act = new Action();
		String choice = null;
		Scanner input = new Scanner(System.in);

		while(choice == null) {
			new PrintContent("You have encountered an enemy, Do you want to fight or run?");
//            Hero Spects
			new PrintContent("Hero Attack:" + hero.getAttack() + "\t" + "Hero Defence: " + hero.getDefense() + "\t" + "Hero hitPoints: " + hero.getHitPoints());
//            Enemy Spects
			attack = enemy.getAttack();
			defense = enemy.getDefense();
			hitPoints = enemy.getHitPoints();
			new PrintContent("Enemy Attack:" + attack + "\t" + "Enemy Defence: " + defense + "\t" + "Enemy hitPoints: " + hitPoints);
			choice = input.nextLine();
			switch (choice.toLowerCase()) {
				case "fight": 
					fight(hero);
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
		hero.setHitPoints(hero.getHitPoints() - enemy.getHitPoints());

		if (hero.getDefense() > 0) {		// if hero Survives
			if (hero.getAttack() > 0){
				hero.setExp(hero.getExp() + (enemy.getAttack()*10));
			} else{
				new PrintContent("!!!!! You are out of attack points !!!!!");
			}
		} else if (hero.getDefense() <= 0) {		// if hero gets Killed
			hero.setExp(hero.getExp()/3);
			hero.setDefense(0);
			new Terminate("dead");
		}
	}

	public void run(Hero hero) {
		hero.setDefense(hero.getDefense() - enemy.getAttack()/3);
		
		if (hero.getDefense() > 0) {		// if hero is Alive
			hero.setExp(hero.getExp() + enemy.getAttack()/2);
		} else if (hero.getDefense() <= 0) {		// if hero is dead Killed
			hero.setExp(hero.getExp()/2);
			hero.setDefense(0);
			new Terminate("dead");
		}
	}
}