package model;

import controller.Action;
import view.DrawMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
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
	Action act = new Action();
//	Hero hero = new Hero();
	boolean endGame = false;

	public PlayGame(Hero hero, String[][] map, int mapSize) {
		while (endGame == false) {
			new DrawMap(map, mapSize);
			act.move(hero, map);
			if (hero.getCoordenateY() < 0 || hero.getCoordenateY() > mapSize || hero.getCoordenateX() < 0 || hero.getCoordenateX() > mapSize) {
				System.out.println("Congradualtions, You survived this round!!!");
				System.out.println("*hero.getCoordenateY() = " + hero.getCoordenateY());
				System.out.println("*hero.getCoordenateX() = " + hero.getCoordenateX());
				System.out.println("mapSize = " + mapSize);
				System.out.println("hero.getDefense()	  = " + hero.getDefense());
				System.out.println("hero.getExp()		  = " + hero.getExp());
				System.out.println("hero.getAttack()	  = " + hero.getAttack());

				endGame = true;
				System.out.println();
			}
		}
		System.out.println("Exiting for no reason");
	}

}
