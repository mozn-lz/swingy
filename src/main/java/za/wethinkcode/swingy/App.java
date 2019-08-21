package za.wethinkcode.swingy;

import za.wethinkcode.swingy.model.InitGame;
import za.wethinkcode.swingy.model.InitHero;
import za.wethinkcode.swingy.view.console.PrintContent;

import java.io.*;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		String[] heroes = {
				// name  cls   lv   xp  At  Df  ht
				"Ichigo	death	0	0	50	20	40", "Vegeta	Saiyan	0	0	50	40	40",
				"Naruto	Ninja	0	0	50	40	40", "Sitama	Human	0	0	100	10	100",
				"Erren.	Titan	0	0	40	40	30", "Kirito	Gamer	0	0	30	70	50"};

		ArrayList<String> arrHeros = new ArrayList<String>();
		File gameSave = new File("../SwingyGameSave.log");		// The name of the file to open.

		if (gameSave.exists()) {
			// This will reference one line at a time
			String line = null;
			try {
				FileReader fileReader = new FileReader(gameSave);		//	FileReader reads text files in the default encoding.
				BufferedReader bufferedReader = new BufferedReader(fileReader);			//	Always wrap FileReader in BufferedReader.

				while ((line = bufferedReader.readLine()) != null) {
					String[] parts = line.split("\t");
					if (parts[0] != null && !parts[0].isEmpty() && parts[1] != null && !parts[1].isEmpty() && isInteger(parts[2]) &&
							isInteger(parts[3]) && isInteger(parts[4]) && isInteger(parts[5]) && isInteger(parts[6])) {
								// System.out.println( parts[0] + parts[1] +parts[2] + parts[3] + parts[4] + parts[5] + parts[6] );
						arrHeros.add(line);
					}
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			new PrintContent("Game save not found... Creating new one.");
			for (int i = 0; i < heroes.length; i++) {
				arrHeros.add(heroes[i]);
			}
		}
		new InitHero().setHeroes(arrHeros);        //	set push heroes from file to program 'hero lost'
		String view = null;
		if (args.length != 1) {
			view = "console";
		} else if (args.length == 1) {
			if (args[0].toLowerCase() == "console" || args[0].toLowerCase() == "gui") {
				view = args[0].toLowerCase();
			} else {
				view = "console";
			}
		}
		switch (view) {
			case "console":
				new InitGame("console");
				break;
			case "gui":
				new InitGame("gui");
				break;
			default:
					new InitGame("console");
		}
		new PrintContent("Main: Swing missed you Mk");
	}

	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);
			isValidInteger = true;
		}
		catch (NumberFormatException e) {
			new PrintContent("Error: " + s+ " is not a number :: " + e);
		}
		return isValidInteger;
	}
}
