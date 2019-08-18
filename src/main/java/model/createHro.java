package model;

import view.console.PrintContent;

import java.util.ArrayList;
import java.util.Scanner;

public class createHro {

	String newName = null;
	String classIndex = null;
	String newhero = null;
	Scanner in = new Scanner(System.in);

	public createHro(){}

	public String createHero(ArrayList<String> heroes, String[][] heroList) {
		while (newhero == null) {
//			while (!(newName == null) || !(classIndex < 0 && classIndex > heroes.size())) {
			new PrintContent("'x' to exit\nEnter hero name.");
//				String donothing = in.nextLine();							// this is here because the input after this was ignored
			newName = in.nextLine().replaceAll("\\s+","").toLowerCase();
			if (newName.length() > 6) {
				newName = newName.substring(0,5) + ".";
			}
			if (newName == "x") {
				return newhero = null;
			}
			if (newName.length() != 0 && newName != null) {
				new PrintContent("Hero class?");
				for (int j = 0; j < heroes.size(); j++) {
					System.out.print(j+1 + ". " + heroList[j][1] + "\t");
				}
				new PrintContent("");
				classIndex = in.nextLine().replaceAll("\\s+","").toLowerCase();
//				System.out.print("newName = " + newName);
				if (classIndex.length() != 0 && classIndex != null) {
					switch (classIndex) {
						case "1":  newhero = initializeHero(newName, heroList[0]);
						break;
						case "2":  newhero = initializeHero(newName, heroList[1]);
						break;
						case "3":  newhero = initializeHero(newName, heroList[2]);
						break;
						case "4":  newhero = initializeHero(newName, heroList[3]);
						break;
						case "5":  newhero = initializeHero(newName, heroList[4]);
						break;
						case "6":  newhero = initializeHero(newName, heroList[5]);
						break;
						case "x":  return newhero = null;
						default:
							new PrintContent("Invalid input '" + classIndex + "'");
							newhero = null;
					}
				}
			} else {
				new PrintContent("Invalid hero name");
			}
			newName = null;
			classIndex = null;
		}

		new PrintContent("newName = " + newName + ", classIndex = " + classIndex);
//		new createHro().createHero(heroes, heroList);
//		String [] newhero =  initializeHero(newName.replaceAll("\\s+",""), heroList[classIndex-1]);
//		heroes.add(String.valueOf(newhero));

		return (newhero);
	}

	private String initializeHero(String newName, String[] loadHero) {
//		String [] newHero = null;
//
//		new PrintContent("weolcoe: ");
//		new PrintContent("newName = " + newName);
//		newHero[0] = newName;      //  name
//		newHero[1] = loadHero[1];  //  class
//		newHero[2] = loadHero[2];  //  level
//		newHero[3] = "0";  //  exp
//		newHero[4] = loadHero[4];  //  atack
//		newHero[5] = loadHero[5];  //  defence
//		newHero[6] = loadHero[6];  //  hit
		String heroString = newName + "\t" + loadHero[1] + "\t" + loadHero[2] + "\t" + "0" + "\t" +
				loadHero[4] + "\t" + loadHero[5] + "\t" + loadHero[6];
		return heroString;
	}
}
