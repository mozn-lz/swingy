package model;

import controller.Action;
import view.console.DrawMap;

import java.util.Scanner;
/*
In either case, the player can see the hero stats:
	 	• Hero name
		• Hero class
		• Level
		• Experience
		• Attack
		• Defense
		• Hit Points

Hero stats are affected by the hero level and artifacts. There are 3 types of artefacs:
		• Weapon - increases the attack
		• Armor - increases defense
		• Helm - increases hit points
*/

/**
 * "Hero name" "Hero class" "Level" "Experience" "Attack" "Defense" "Hit Points"
 * 
 * "Weapon" "Armor" "Hel
 * 
 */

public class PlayGame {
	Action action = new Action();
	boolean endGame = false;
	Scanner in = new Scanner(System.in);
	String levelUpStats = null;

	public PlayGame(Hero hero, String[][] map, int mapSize) {
		System.out.println("Current stats:\n\tHero Defense : " + hero.getDefense() + "\t\t" + "Hero Exp : " + hero.getExp() + "\t\t" + "Hero Attack : " + hero.getAttack());
		System.out.println("Do you want to increase your player stats?  yes(Y)");
		levelUpStats = in.nextLine();
		System.out.println("levelUpStats = " + levelUpStats.toLowerCase());
//		if (levelUpStats.toLowerCase() == "y") {
			new Shop();
//		}

		while (endGame == false) {
            System.out.println("\n\n\n\n");
            System.out.println("Level : " + hero.getHeroLevel());
			new DrawMap(map, mapSize);
            System.out.println("Hero Defense : " + hero.getDefense() + "\t\t" + "Hero Exp : " + hero.getExp() + "\t\t" + "Hero Attack : " + hero.getAttack() + "\n");
			action.move(hero, map);
		}
		System.out.println("Exiting for no reason");
	}

}
