package model;

public class Hero {

	static String name = null;
	static String heroClass = null;
	static int heroLevel = 0;
	static int exp = 0;
	static int attack = 50;
	static int defense = 50;
	static int hitPoints = 50;
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
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		System.out.println("exp = " + exp);
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
		if (this.attack > 100) {
			this.attack = 100;
		}
		System.out.println("attack = " + attack);
		}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		if (this.defense < 0) {
			dead();
		} else if (this.defense > 100) {
			this.defense = 100;
		}
		System.out.println("defense = " + defense);
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		if (hitPoints > 100){
			hitPoints = 100;
		}
		System.out.println("hitPoints = " + this.hitPoints);
	}

}
