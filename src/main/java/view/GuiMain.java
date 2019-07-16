package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiMain extends JFrame {

//	createHero();
//	selectHero();

	public GuiMain() {

		createMap();
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Swingy");
		setResizable(false);
		setVisible(true);
	}

	private void createMap() {
		JPanel heroList = new JPanel();
//		heroList.setBounds(0, 0, -100, 100);
		JLabel heroListTitle = new JLabel("Our Brave Heroes");
		heroList.add(heroListTitle);
		heroList.setBackground(Color.GRAY);
		heroList.setBorder(BorderFactory.createLoweredBevelBorder());
		//	list start
			DefaultListModel listModel = new DefaultListModel();
				listModel.addElement("Jasmine Mehra");
				listModel.addElement("Ankit Mishra");
				listModel.addElement("Madhuri Sanghvi");
				listModel.addElement("Alok Kumar");
				listModel.addElement("Rohit Bothra");
				listModel.addElement("Rahul Aggarwal");
		
			//Create the list and put it in a scroll pane.
			JList list = new JList(listModel); 	
		//	List End
			heroList.add(list);
		getContentPane().add(heroList);

		JPanel heroStats = new JPanel();
//		heroStats.setBounds(150, 5, 230, 300);
		JLabel heroStatsTitle = new JLabel("Stats");
		heroStats.add(heroStatsTitle);
		heroStats.setBackground(Color.GRAY);
		heroStats.setBorder(BorderFactory.createLoweredBevelBorder());
		getContentPane().add(heroStats);

		add(heroList);
		add(heroStats);
		setLayout(new GridLayout(1,2, 5, 1));
	}

}
