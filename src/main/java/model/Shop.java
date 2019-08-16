package model;

import view.console.PrintContent;

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
            new PrintContent("Welcome to the SHOP where you can increase ");
            System.out.print("*EXP : " + hero.getExp() + "*");
            System.out.print("\t\tHelm : " + hero.getHelm());
            System.out.print("\tDefense : " + hero.getDefense());
            new PrintContent("\tAttack : " + hero.getAttack());
            new PrintContent("'W' to restore your weapon, 'A' to restore Amor, 'H' to resrore helm and 'X' to exit");
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
        }
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
