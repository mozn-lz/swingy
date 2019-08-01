package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
/*
In either case, the player can see the hero stats:
	 	• Hero name
		• Hero class
		• Level
		• Experience
		• Attack
		• Defense
		• Hit Points

Hero stats are affected by the hero level and artifacts. There are 3 types of artefacs:
		• Weapon - increases the attack
		• Armor - increases defense
		• Helm - increases hit points
*/

/**
 * "Hero name" "Hero class" "Level" "Experience" "Attack" "Defense" "Hit Points"
 * 
 * "Weapon" "Armor" "Hel
 * 
 */

public class PlayGame {
	public void getPlayer() {
		try {
			String username = "admin", password = "123456", fname = "Shubhendu", ip = "12345", lname = "Goswami";
			String up = "username=" + username + "&password=" + password + "&fname=" + fname + "&lname=" + lname + "&ip=" + ip;
			URL url = new URL("http://127.0.0.1:3306/alias1/index.php?" + up);
			URLConnection urlc = url.openConnection();
			urlc.connect();
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			String str;
			while ((str = buffRead.readLine()) != null) {
				System.out.print(str);
			}

			buffRead.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fight(Hero hero) {
		hero.setAttack(hero.getAttack() - 10);
		hero.setDefense(hero.getDefense() - 20);
		if (hero.getDefense() > 0) {		// if hero Survives
			hero.setExp(hero.getExp() + 500);
		} else if (hero.getDefense() <= 0) {		// if hero gets Killed
			hero.setExp(0);
			hero.setDefense(0);
		}
	}

	public void run(Hero hero) {
		if (hero.getDefense() > 0) {		// if hero Survives
			if ((hero.getExp() - 10) < 0) {
				hero.setExp(hero.getExp() - 10);
			}
			else {
				hero.setExp(0);
			}
		} else if (hero.getDefense() <= 0) {		// if hero gets Killed
			hero.setExp(0);
			hero.setDefense(0);
		}
	}
}
