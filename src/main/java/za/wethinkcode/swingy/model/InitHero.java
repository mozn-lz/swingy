package za.wethinkcode.swingy.model;
import za.wethinkcode.swingy.view.console.PrintContent;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InitHero {

	Hero hero = new Hero();

	private static ArrayList<String> heroesArrList = new ArrayList<String>();

	public InitHero() {
	}

	public ArrayList<String> getHeroes() {
		return heroesArrList;
	}

	public void setHeroes(ArrayList<String> arrHeros) {
		heroesArrList = arrHeros;
	}

	public void selectHero() {
		Scanner in = new Scanner(System.in);

		for (int i = 0; i <= 5; i++) {
			String [][] heroList =  displayHeroList(heroesArrList);
			new PrintContent("'1 - "+ heroesArrList.size() +"' to Select a hero number.\n'0' to Create a custom hero.");
			int choice = 42;
			try {
				choice = in.nextInt();
				if (choice >=1 && choice <= heroList.length) {
					choice--;
					hero.setName(heroList[choice][0]);
					hero.setHeroClass(heroList[choice][1]);
					hero.setExp(Integer.parseInt( heroList[choice][3]));
					hero.setAttack(Integer.parseInt( heroList[choice][4]));
					hero.setDefense(Integer.parseInt( heroList[choice][5]));
					hero.setHitPoints(Integer.parseInt( heroList[choice][6]));
					hero.setHeroLevel(Integer.parseInt( heroList[choice][2]));
					hero.setIndex(choice);
					new PrintContent("\n\n");
					return;
				}
			} catch (InputMismatchException e) {
				new PrintContent("Invalid choice");
			}
			if (choice - 1 == -1) {     //  create hero
				String newHero = new createHro().createHero(heroesArrList, heroList);
				heroesArrList.add(String.valueOf(newHero));
			}
		}
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

	public void updateHeroes() {
		String currentHero = hero.getName() + "\t" +
				hero.getHeroClass() + "\t" +
				hero.getHeroLevel() + "\t" +
				hero.getExp() + "\t" +
				hero.getAttack() + "\t" +
				hero.getDefense() + "\t" +
				hero.getHitPoints();
		heroesArrList.set(hero.getIndex(), currentHero);
		new PrintContent("\n");
	}
}
