package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.view.console.PrintContent;

import java.io.PrintWriter;
import java.util.Scanner;

public class Terminate {
    Hero hero = new Hero();
    
    public Terminate(String result) {
        new Save(hero);
        switch (result) {
            case "dead":
				new PrintContent("Your dead. Your defence is " + hero.getDefense());
				hero.setAttackMax ();
				hero.setDefenseMax ();
				hero.setHitPointsMax ();
                break;
            case "win":
				new PrintContent("Congratulations, you win the game.");
				findArtefact();
                break;
            case "exit":
				new PrintContent("Thank you for playing today.\n Exiting....\n\n\n\n\n\n\n\n\n");
				hero.setAttackMax ();
				hero.setDefenseMax ();
				hero.setHitPointsMax ();
                System.exit(0);
                break;
        }
        new PlayGame();
	}

	private void findArtefact() {
		Scanner in = new Scanner(System.in);
		String[] arrArtefact = {"Attack", "Defense", "Hit Points"};
		int score = (hero.getAttack() + hero.getDefense() + hero.getHitPoints()) % 5;
		if (score >= 0 && score < 3) {
			new PrintContent("!!!CONGRADULATIONS!!\tYou qualify for " + arrArtefact[score] + " bonus\t!!CONGRADULATIONS!!!");
			new PrintContent("yes(Y), no(N)");
			String getArtefact = in.nextLine();
			if (getArtefact.toLowerCase() == "y") {
				String artefact = hero.getArtefact();
				if (artefact == "attack" || artefact == "defense" || artefact == "hitPoints") {
					new PrintContent("!!!CONGRADULATIONS!!\tYou have " + artefact + " bonus\t!!CONGRADULATIONS!!!");
				}
			}
		}
	}
}
