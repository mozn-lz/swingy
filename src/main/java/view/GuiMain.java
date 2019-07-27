package view;

import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    public GuiMain(String panel) {
        System.out.println("Hello from GuiMain");
        System.out.println("1. panel = " + panel);
//        SelectPlayer selectPlayer = new SelectPlayer();
        System.out.println("2. panel = " + panel);
//        CreatePlayer createPLayer = new CreatePlayer();

//        getContentPane().add(player.heroStatsPanel);
        switch (panel) {
            case "selectPlayer":
                System.out.println("going to selectPlayer()");
                System.out.println("panel = " + panel);
                new SelectPlayer.createMap();
//                getContentPane().add(selectPlayer.selectPlayerPanel);
                getContentPane().add(new SelectPlayer().selectPlayerPanel);
            break;
            case "CreatePlayer":
                System.out.println("panel = " + panel);
//                new CreatePlayer();
//                getContentPane().add(createPLayer.heroDetails);
                getContentPane().add(new CreatePlayer().heroDetails);
            break;
            default:
                System.out.println("Done");
        }
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swingy");
        setResizable(false);
        setVisible(true);
    }

}
