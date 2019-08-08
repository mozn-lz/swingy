package view.gui;

import model.InitHero;
import view.GuiMain;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPlayer  {

	public SelectPlayer() {
	}

	public JPanel selectPlayerPanel = new JPanel();
	JPanel heroListPanel = new JPanel();
	JLabel heroListTitle = new JLabel("Our Brave Heroes");
	JPanel heroStatsPanel = new JPanel();
	JLabel heroStatsTitle = new JLabel("Stats");
	JTextArea diaplayStats = new JTextArea();
	JButton goHeroButton, newHeroButton;
	JList  heroJList = new JList();
	String chosenHero = null;
	String[] heroes = {"Ichigo", "Vegeta", "Naruto", "Sitama", "Eren", "Kirito"};
//	String[] demoHeroes = {
//		// name  cls   lv   xp  At  Df  ht
//		"Ichigo	death	0	0	50	20	40", "Vegeta	Saiyan	0	0	50	40	40",
//		"Naruto	Ninja	0	0	50	40	40", "Sitama	Human	0	0	100	10	100",
//		"Eren	Titan	0	0	40	40	30","Kirito	Gamer	0	0	30	70	50"}
//		;

        String [] demoHeroes = new InitHero().getHeroes();      // untested code    -> if any errors delete this and uncomment above
//        String[] heroes  = new InitHero().getHeroes().names;

	public void createMap() {
/**************************** HERO LIST PANEL ****************************/
		heroListPanel.add(heroListTitle);
		heroListPanel.setBackground(Color.GRAY);
		heroListPanel.setBorder(BorderFactory.createLoweredBevelBorder());

		 heroJList.setModel(new AbstractListModel() {			//	+list start
			public int getSize() {
				return heroes.length;
			}
			public Object getElementAt(int i) {
				return heroes[i];
			}
		});
		 heroJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				heroListValueChanged(evt);
			}
		});			//	-List End
		heroJList.setVisibleRowCount(20);
		heroListPanel.add( heroJList);
		final JTextField createHeroTexfield = new JTextField(20);
		createHeroTexfield.setText("New Hero Name");
		heroListPanel.add(createHeroTexfield);
		heroListPanel.add(newHeroButton = new JButton("Create new Hero"));
		newHeroButton.addActionListener(new ActionListener(){		//	Selecthero button
			@Override
			public void actionPerformed(ActionEvent e) {
				String newHero = createHeroTexfield.getText().replaceAll("\\s","");
				System.out.println("newHero = " + newHero);
				if (newHero != null) {
					System.out.println("going to CreatePlayer()");
					new GuiMain("CreatePlayer");
					JOptionPane.showMessageDialog(null, newHero + "... fearsome name.");
				} else {
					JOptionPane.showMessageDialog(null, "It appears there is an error on your Heroes name");
				}
			}
		});
/**************************** HERO STATS PANEL ****************************/
		heroStatsPanel.add(heroStatsTitle);
		heroStatsPanel.setBackground(Color.GRAY);
		heroStatsPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		//	+Jtextarea Start
		diaplayStats.setEnabled(false);
		heroStatsPanel.add(diaplayStats);
		//	-JTtextarea End
		heroStatsPanel.add(goHeroButton = new JButton("Select Hero"));
		goHeroButton.addActionListener(new ActionListener(){		//	Selecthero button		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenHero != null) {
					JOptionPane.showMessageDialog(null, chosenHero + " good choice");
				} else {
					JOptionPane.showMessageDialog(null, "Choose a charecter first");
				}
			}
		});
		selectPlayerPanel.add(heroListPanel);
		selectPlayerPanel.add(heroStatsPanel);
		selectPlayerPanel.setLayout(new GridLayout(1,2, 5, 1));
	}

//	SELECT HERO ACTIONLISTNER
	protected void heroListValueChanged(ListSelectionEvent evt) {
		String[] heroAttr = null;
		String str1 = null, disp = null;
		if (! heroJList.getValueIsAdjusting()) {
			for (int i = 0; i < heroes.length; i++) {
				if ( heroJList.getSelectedValue() == heroes[i]) {
					str1 = demoHeroes[i];
					heroAttr = str1.split("\t");
					disp = "HeroName: \t" + heroAttr[0] + "\n" + "HeroClass: \t" + heroAttr[1] + "\n" + "Level: \t" + heroAttr[2] + "\n" + "Experience: \t" + 
						heroAttr[3] + "\n" + "Attack: \t" + heroAttr[4] + "\n" + "Defense: \t" + heroAttr[5] + "\n" + "HitPoints: \t" + heroAttr[6];
					chosenHero = heroAttr[0];
				}
			}
			if (disp != null) {
				diaplayStats.setText((String) disp);
			} else{
				diaplayStats.setText("Error displaying player stats");
			}
		}
	}
}
