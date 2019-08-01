package view;

import view.gui.CreatePlayer;

import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    public GuiMain(String panel) {
        System.out.println("Hello from GuiMain");
        System.out.println("1. panel = " + panel);
        System.out.println("2. panel = " + panel);
        switch (panel) {
            case "selectPlayer":
                System.out.println("going to selectPlayer()");
                System.out.println("panel = " + panel);
                SelectPlayer selectPlayer = new SelectPlayer();
                selectPlayer.createMap();
                getContentPane().add(selectPlayer.selectPlayerPanel);
            break;
            case "CreatePlayer":
                System.out.println("panel = " + panel);
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
