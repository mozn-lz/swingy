package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.view.console.PrintContent;

import java.util.Scanner;

public class Shop {
	Hero hero = new Hero();

	public Shop() {
		/*
		• Weapon - increases the attack
		• Armor - increases defense
		• Helm - increases hit points
		*/

		String todo = null;
		Scanner in = new Scanner(System.in);

		for (boolean i = false; i == false; ) {
			new PrintContent("\n\n\n");
			new PrintContent("\t\t_____Welcome to the SHOP_____\n\t _where you can increase your stats_ ");
			new PrintContent("\t*EXP : " + hero.getExp() + "*" + "\n\tHelm : " + hero.getHelm() + "\tDefense : " + hero.getDefense() + "\tAttack : " + hero.getAttack() + "\n");
			new PrintContent("'W' to restore your Weapon(Atack), 'A' to restore Amor(Defense), 'H' to resrore Helm(Hit Points) and 'X' to exit");
			todo = in.nextLine();
			switch (todo.toLowerCase()) {
				case "w":
					buyWeapon();
					break;
				case "a":
					buyArmor();
					break;
				case "h":
					buyHelm();
					break;
				case "x":
					new PrintContent("exiting shop...");
					i = true;
					break;
				default:
					new PrintContent("Invalid option '" + todo + "'");
			}
			new Save(hero); 
		}
		new PrintContent("\n\n");
	}

	private void buyWeapon() {
		Scanner in = new Scanner(System.in);
		String topUp = null;

		new PrintContent("Would you like to top up your Weapon with your exp?\n yes (Y) no(N)");
		topUp = in.nextLine();
		switch (topUp.toLowerCase()) {
			case "y":
				if (hero.getExp() - (100 - hero.getAttack()) > 0) {
					hero.setExp(hero.getExp() - (100 - hero.getAttack()));
					hero.setAttack(100);
				} else if (hero.getExp() > 0) {
					hero.setAttack(hero.getExp());
					hero.setExp(0);
				} else {
					new PrintContent("Not enough Exp to restore health");
				}
				break;
			case "n":
				new Shop();
				break;
			default:
				new PrintContent("Invalid comand");
				buyWeapon();
				break;
		}
	}
	private void buyArmor() {
		Scanner in = new Scanner(System.in);
		String topUp = null;

		new PrintContent("Would you like to top up your Armor with your exp?\n yes (Y) no(N)");
		topUp = in.nextLine();
		switch (topUp.toLowerCase()) {
			case "y":
				if (hero.getExp() - (100 - hero.getDefense()) > 0) {
					hero.setExp(hero.getExp() - (100 - hero.getDefense()));
					hero.setDefense(100);
				} else if (hero.getExp() > 0) {
					hero.setDefense(hero.getExp());
					hero.setExp(0);
				} else {
					new PrintContent("Not enough EXP to restore Armor");
				}
				break;
			case "n":
				new Shop();
			default:
				new PrintContent("Invalid comand");
				buyArmor();
				break;
		}
	}
	private void buyHelm() {
		Scanner in = new Scanner(System.in);
		String topUp = null;

		new PrintContent("Would you like to top up your Helm with your exp?\n yes (Y) no(N)");
		topUp = in.nextLine();
		switch (topUp.toLowerCase()) {
			case "y":
				if (hero.getExp() - (100 - hero.getHelm()) > 0) {
					hero.setExp(hero.getExp() - (100 - hero.getHelm()));
					hero.setHelm(100);
				} else if (hero.getExp() > 0) {
					hero.setHelm(hero.getExp());
					hero.setExp(0);
				} else {
					new PrintContent("Not enough EXP to restore helm");
				}
				break;
			case "n":
				new Shop();
			default:
				new PrintContent("Invalid comand");
				buyHelm();
				break;
		}
	}
}
