package za.wethinkcode.swingy.model;

import za.wethinkcode.swingy.view.console.PrintContent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Terminate {
    Hero hero = new Hero();
    public static PrintWriter writer = null;

    public Terminate(String result) {
        new InitHero().updateHeroes(hero);
        ArrayList<String> arrListHeroes = new InitHero().getHeroes();

        //        WRITE PLAYER DATA TO FILE
        try {
            System.out.println("writing");
            writer = new PrintWriter(new File("../SwingyGameSave.log"));
            for (int i = 0; i < arrListHeroes.size(); i++) {
                writer.write(arrListHeroes.get(i) + "\n");
                writer.flush();
            }
            writer.close(); // close file writer
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
                new PrintContent("lol, minor crush, the game will restart now.");
        }
        new InitGame();
    }
}
