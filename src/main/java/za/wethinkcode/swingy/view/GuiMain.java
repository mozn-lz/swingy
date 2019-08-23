package za.wethinkcode.swingy.view;

import za.wethinkcode.swingy.view.console.PrintContent;
import za.wethinkcode.swingy.view.gui.CreatePlayer;
import za.wethinkcode.swingy.view.gui.SelectPlayer;

import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    public GuiMain(String panel) {
        new PrintContent("Hello from GuiMain");
        new PrintContent("1. panel = " + panel);
		new PrintContent("2. panel = " + panel);
		panel = "CreatePlayer";
        switch (panel) {
            case "CreatePlayer":
				new PrintContent("GuiMain() -> panel = " + panel);
				// CreatePlayer createPlayer = new CreatePlayer();
                getContentPane().add(new CreatePlayer().heroDetails);
            break;
            case "selectPlayer":
                new PrintContent("going to selectPlayer()");
                new PrintContent("panel = " + panel);
                SelectPlayer selectPlayer = new SelectPlayer();
                selectPlayer.createMap();
                getContentPane().add(selectPlayer.selectPlayerPanel);
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
