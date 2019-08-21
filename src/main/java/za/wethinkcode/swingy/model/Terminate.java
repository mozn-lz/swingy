package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.view.console.PrintContent;

import java.io.PrintWriter;

public class Terminate {
    Hero hero = new Hero();
    
    public Terminate(String result) {
        new Save(hero);
        switch (result) {
            case "dead":
                new PrintContent("Your dead. Your defence is " + hero.getDefense());
                break;
            case "win":
                new PrintContent("Congratulations, you win the game.");
                break;
            case "exit":
                new PrintContent("Thank you for playing today.\n Exiting....\n\n\n\n\n\n\n\n\n");
                System.exit(0);
                break;
            default:
                // new PrintContent("2. lol, minor crush, the game will restart now.");
        }
        // new InitGame();
        new PlayGame();
    }
}
