package model;

public class Hero {

	static String name = null;
	static String heroClass = null;
	static int heroLevel = 0;
	static int exp = 0;
	static int attack = 0;
	static int defense = 0;
	static int hitPoints = 0;
	static int coordenateX = 0;
	static int coordenateY = 0;

	public int getCoordenateX() {
		return coordenateX;
	}

	public void setCoordenateX(int coordenateX) {
		System.out.println("coordenateX = " + coordenateX);
		this.coordenateX = coordenateX;
		if (this.coordenateX < 0) {
			this.coordenateX = 0;
		}
	}

	public int getCoordenateY() {
		return coordenateY;
	}

	public void setCoordenateY(int coordenateY) {
		System.out.println("coordenateY = " + coordenateY);
		this.coordenateY = coordenateY;
		if (this.coordenateY < 0) {
			this.coordenateY = 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("name = " + name);
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
		System.out.println("heroClass = " + this.heroClass);
	}

	public int getHeroLevel() {
		return heroLevel;
	}

	public void setHeroLevel(int heroLevel) {
		this.heroLevel = heroLevel;
		System.out.println("heroLevel = " + heroLevel);
		if (heroLevel <= 0) {
			heroLevel = 0;
		}
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		System.out.println("exp = " + exp);
		if (exp < 0) {
			exp = 0;
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
		System.out.println("attack = " + attack);
		if (this.attack < 0) {
			this.attack = 0;
		}
		if (this.attack > 100) {
			this.attack = 100;
		}
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		System.out.println("defense = " + defense);
		if (this.defense < 0) {
			this.defense = 0;
		}
		if (this.defense > 100) {
			this.defense = 100;
		}
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		System.out.println("hitPoints = " + this.hitPoints);
		if (this.hitPoints < 0) {
			this.hitPoints = 0;
		}
		if (this.hitPoints > 100) {
			this.hitPoints = 100;
		}
	}

}
