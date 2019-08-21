package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.controller.Action;
import za.wethinkcode.swingy.view.console.*;
import za.wethinkcode.swingy.view.console.PrintContent;

import java.io.IOException;
import java.util.Scanner;

public class PlayGame {
	Action action = new Action();
	boolean endGame = false;
	Scanner in = new Scanner(System.in);
	String choice= null;

	public PlayGame(Hero hero, String[][] map, int mapSize) {

		for (boolean i = false; i == false; ) {
			// new PrintContent("\n\n\n\n");
			new PrintContent("\t\t************");
			new PrintContent("\t\t*  SWINGY  *");
			new PrintContent("\t\t************\n\n");
			if (hero.getName() != null){
				new PrintContent(hero.getName() + "\t\tEXP of " + hero.getExp() + "\t\tLevel "+hero.getHeroLevel() + "\nAtack " + hero.getAttack() +"\t\tDefense "+ hero.getDefense() + "\t\tHit Points "+ hero.getHelm());
			}
			new PrintContent("'Select' to Select hero\n'shop' to Increase hero stats\n'start' to Start Game and \n'exit' to Exit");
			choice = in.nextLine();
			switch (choice.toLowerCase()) {
				case "select":
					new InitHero().selectHero();
					break;
				case "shop":
					if (hero.getName() != null) {
						new Shop();
					} else {
						new PrintContent("Please select hero first");
					}
					break;
				case "start":
					if (hero.getName() != null) {
						startGame(hero, map, mapSize);
					} else {
						new PrintContent("Please select hero first");
					}
					break;
				case "exit":
					new Terminate("exit");
					new PrintContent("Exiting game...");
				default: new PrintContent("Invalid choice");
			}
		}
	}
	private void startGame(Hero hero, String[][] map, int mapSize){
		while (endGame == false) {
			new PrintContent("\n\n\n\n");
			new PrintContent("Level : " + hero.getHeroLevel());
			new DrawMap(map, mapSize);
			new PrintContent(hero.getName() + "\t\tEXP of " + hero.getExp() + "\t\tLevel "+hero.getHeroLevel() + "\nAtack " + hero.getAttack() +"\t\tDefense "+ hero.getDefense() + "\t\tHit Points "+ hero.getHelm());
			action.move(hero, map);
		}
	}
}
