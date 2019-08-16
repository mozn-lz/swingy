package model;

import controller.Action;
import view.console.DrawMap;
import view.console.PrintContent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlayGame {
	Action action = new Action();
	boolean endGame = false;
	Scanner in = new Scanner(System.in);
	String choice= null;
//	public static PrintWriter writer = null;

	public PlayGame(Hero hero, String[][] map, int mapSize) {
//		try {
//			writer = new PrintWriter(new File("./simulation.txt"));
//			for (int i = 0; i <arrHeroes.size() ; i++) {
//				writer.write(arrHeroes(i));
//				writer.flush();
//			}
//			writer.close(); // close file writer
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		for (boolean i = false; i == false; ) {
			if (hero.getName() != null){
				new PrintContent("Current stats:\n\tHero Defense : " + hero.getDefense() + "\t\t" + "Hero Exp : " + hero.getExp() + "\t\t" + "Hero Attack : " + hero.getAttack());
			}
			new PrintContent("'Select' to Select hero\n'shop' to Increase hero stats\n'start' to Start Game and \n'exit' to exit");
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
		new PrintContent("Exiting Game");
	}
	private void startGame(Hero hero, String[][] map, int mapSize){
		while (endGame == false) {
			new PrintContent("\n\n\n\n");
			new PrintContent("Level : " + hero.getHeroLevel());
			new DrawMap(map, mapSize);
			new PrintContent("Hero Defense : " + hero.getDefense() + "\t\t" + "Hero Exp : " + hero.getExp() + "\t\t" + "Hero Attack : " + hero.getAttack() + "\n");
			action.move(hero, map);
		}
	}
}
