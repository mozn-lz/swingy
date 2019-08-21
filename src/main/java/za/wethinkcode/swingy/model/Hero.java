package za.wethinkcode.swingy.model;
import za.wethinkcode.swingy.view.console.PrintContent;

public class Hero {

	static String name = null;
	static String heroClass = null;
	static int heroLevel = 0;
	static int exp = 0;
	static int attack = 50;
	static int defense = 50;
	static int helm = 50;
	static int coordenateX = 0;
	static int coordenateY = 0;
	static int mapSize = 0;

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Hero.index = index;
	}

	static int index = 0;

	public int getCoordenateX() {
		return coordenateX;
	}

	public void setCoordenateX(int coordenateX) {
		this.coordenateX = coordenateX;
		if (coordenateX < 0 && coordenateX >= mapSize) {
			if (this.coordenateX < 0) {
				this.coordenateX = 0;
			}
			new Terminate("win");
		}
	}

	public int getCoordenateY() {
		return coordenateY;
	}

	public void setCoordenateY(int coordenateY) {
		this.coordenateY = coordenateY;
		if (coordenateY < 0 && coordenateY >= mapSize) {
			if (this.coordenateY < 0) {
				this.coordenateY = 0;
			}
			new Terminate("win");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}

	public int getHeroLevel() {
		setHeroLevel(exp);
		return heroLevel;
	}

	public void setHeroLevel(int heroLevel) {
		this.heroLevel = heroLevel;
		if (exp > 0 && exp <= 1000){
			this.heroLevel = 1;
		} else if (exp > 1000 &&  exp <= 2450) {
			this.heroLevel = 2;
		} else if (exp > 2450 &&  exp <= 4800){
			this.heroLevel = 3;
		} else if (exp > 4800 &&  exp <= 8050){
			this.heroLevel = 4;
		} else if (exp > 8050 &&  exp <= 12200){
			this.heroLevel = 5;
		} else {
			this.heroLevel = 0;
//			new PrintContent("level unknown");
		}
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		if (this.exp < 0) {
			this.exp = 0;
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
		if (this.attack < 0) {
			this.attack = 0;
		} else if (this.attack > 100) {
				this.attack = 100;
		}
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		if (this.defense < 0) {
//			dead();
			this.defense = 0;
			new Terminate("dead");
		} else if (this.defense > 100) {
			this.defense = 100;
		}
	}

	public int getHelm() {
		return helm;
	}

	public void setHelm(int helm) {
		this.helm = helm;
		if (helm < 0){
			this.helm = 0;
		} else if (this.helm > 100){
		this.helm = 100;
		}
	}

	public static void setMapSize(int mapSize) {
		Hero.mapSize = mapSize;
	}
}
