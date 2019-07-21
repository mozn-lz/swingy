package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newGame {
    private JPanel panel1;
    private JTextField heroNameTextField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField DefenseTextField;
    private JTextField attackTextField;
    private JTextField levelTextField;
    private JTextField expTextField;
    private JButton saveButton;
    private JButton backButton;

    public newGame() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                opends player window -> newGame()
                new SelectPlayer();
            }
        });
    }
}
