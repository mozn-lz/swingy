package model;

import java.util.Scanner;

public class Shop {
    Hero hero = new Hero();
    private final int weapon = 50;
	private final int armor = 50;
    private final int helm = 50;

    public Shop() {
        /*
        • Weapon - increases the attack
		• Armor - increases defense
		• Helm - increases hit points
        */
        String todo = null;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the SHOP where you can increase ");
        todo = in.nextLine();
        switch (todo.toLowerCase()) {
            case "w": buyWeapon();
            break;
            case "a": buyArmor();
            break;
            case "h": buyHelm();
            break;
            default:
                System.out.println("Invalid option '" + todo + "'");
        }
    }

    private void buyWeapon() {
        Scanner in = new Scanner(System.in);
        String topUp = null;

        System.out.println("Would you like to top up your Weapon with your exp?\n yes (Y) no(N)");
        topUp = in.nextLine();
        switch (topUp.toLowerCase()) {
            case "y":
                hero.setExp(hero.getExp() - (100 - hero.getAttack()));
                hero.setAttack(100);

//                hero.exp = hero.weapon - 100;
//                hero.weapon = 100;
                break;
            case "n":
                new Shop();
                default:
                System.out.println("Invalid comand");
                buyWeapon();
                break;

        }
    }
    private void buyArmor() {
        Scanner in = new Scanner(System.in);
        String topUp = null;

        System.out.println("Would you like to top up your Armor with your exp?\n yes (Y) no(N)");
        topUp = in.nextLine();
        switch (topUp.toLowerCase()) {
            case "y":
                hero.setExp(hero.getExp() - (100 - hero.getDefense()));
                hero.setDefense(100);
//                hero.setExp(hero.getExp() - 100);
//                hero.setDefense(100);;
                break;
            case "n":
                new Shop();
                default:
                System.out.println("Invalid comand");
                buyArmor();
                break;

        }
    }
    private void buyHelm() {
        Scanner in = new Scanner(System.in);
        String topUp = null;

        System.out.println("Would you like to top up your Helm with your exp?\n yes (Y) no(N)");
        topUp = in.nextLine();
        switch (topUp.toLowerCase()) {
            case "y":
                hero.setExp(hero.getExp() - (100 - hero.getHelm()));
                hero.setHelm(100);
//                hero.exp = hero.Helm - 100;
//                hero.Helm = 100;
                break;
            case "n":
                new Shop();
                default:
                System.out.println("Invalid comand");
                buyHelm();
                break;

        }
    }
}
