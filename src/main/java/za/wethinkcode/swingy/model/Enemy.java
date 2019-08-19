package za.wethinkcode.swingy.model;

import java.util.Random;

public class Enemy {

	private int level = new Hero().getHeroLevel() + 1;
	private int attack = getEnemy(20) * level;
	private int defense = getEnemy(20) * level;
	private int helm = getEnemy(20) * level;

	public Enemy(int level) {
		if (this.level <= 0) {
			this.level = 2;
		}
		this.level = level;
	}

	private int getEnemy(int max) {
		Random r = new Random();
		int rtn = r.nextInt(max) + (level + 1);
		return rtn;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getHelm() {
		return helm;
	}
}
