package controller;

import model.Hero;
import model.PlayGame;

import java.util.Scanner;

public class Action {
    public Action() {
//        Action act = new Action();
        PlayGame playGame = new PlayGame();
        String choice = null;
        Scanner input = new Scanner(System.in);

        System.out.println();
        while(choice == null) {
            System.out.println("You have encountered an enemy, Do you want to fight or run?");
            choice = input.nextLine();
            switch (choice) {
                case "fight": playGame.fight(new Hero());
                    break;
                case "run":
                    break;
                default:
//                    System.out.println("Invalid option");
                    choice = null;
            }
        }
    }
    public void move() {
        System.out.println("Type up to go 'UP', left to go 'LEFT', right to go 'RIGHT' and down to go 'DOWN'");
        System.out.println();
    }
}
