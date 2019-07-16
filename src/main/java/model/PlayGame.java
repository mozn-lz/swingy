package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
/*
		• Create a hero
		• Select a previously created hero.

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
 * 
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
}
