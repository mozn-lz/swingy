package view;

import view.console.PrintContent;
import view.gui.CreatePlayer;
import view.gui.SelectPlayer;

import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    public GuiMain(String panel) {
        new PrintContent("Hello from GuiMain");
        new PrintContent("1. panel = " + panel);
        new PrintContent("2. panel = " + panel);
        switch (panel) {
            case "selectPlayer":
                new PrintContent("going to selectPlayer()");
                new PrintContent("panel = " + panel);
                SelectPlayer selectPlayer = new SelectPlayer();
                selectPlayer.createMap();
                getContentPane().add(selectPlayer.selectPlayerPanel);
            break;
            case "CreatePlayer":
                new PrintContent("panel = " + panel);
                getContentPane().add(new CreatePlayer().heroDetails);
            break;
            default:
                new PrintContent("Done");
        }
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swingy");
        setResizable(false);
        setVisible(true);
    }
}
