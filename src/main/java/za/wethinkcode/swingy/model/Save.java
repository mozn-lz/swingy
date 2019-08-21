package za.wethinkcode.swingy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {

    PrintWriter writer = null;

    public Save (Hero hero) {
        // Hero hero = new Hero();
        new InitHero().updateHeroes();
        ArrayList<String> arrListHeroes = new InitHero().getHeroes();

        //        WRITE PLAYER DATA TO FILE
        if (hero.getName() != null) {
            try {
                writer = new PrintWriter(new File("../SwingyGameSave.log"));
                for (int i = 0; i < arrListHeroes.size(); i++) {
                    writer.write(arrListHeroes.get(i) + "\n");
                    writer.flush();
                }
                writer.close(); // close file writer
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}