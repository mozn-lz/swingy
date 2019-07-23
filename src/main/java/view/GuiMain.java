package view;

import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    public GuiMain() {
        SelectPlayer player = new SelectPlayer();
        player.createMap();

        getContentPane().add(player.selectPlayerPanel);
//        getContentPane().add(player.heroStatsPanel);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swingy");
        setResizable(false);
        setVisible(true);
    }
}
