package za.wethinkcode.swingy.view.gui;

import za.wethinkcode.swingy.view.GuiMain;
import za.wethinkcode.swingy.view.console.PrintContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePlayer {
	public JPanel heroDetails;
	private JTextField heroNameTextField;
	private JComboBox heroClass;
	private JTextField attackTextField;
	private JTextField levelTextField;
	private JTextField expTextField;
	private JTextField textField3;
	private JTextField DefenseTextField;
	private JButton saveButton;
	private JButton backButton;
	private JLabel createPlayer;

	public CreatePlayer() {
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PrintContent("heroNameTextField = " + heroNameTextField.getText());
			}
		});
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PrintContent("Going back to Select Player");
				new GuiMain("selectPlayer");
			}
		});
	}

}
