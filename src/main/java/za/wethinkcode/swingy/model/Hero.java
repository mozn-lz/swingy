package za.wethinkcode.swingy.model;
import za.wethinkcode.swingy.view.console.PrintContent;

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
	static int mapSize = 0;
	static int index = 0;
	static int attackMax = 100;
	static int defenseMax = 100;
	static int hitPointsMax = 100;

	public String getArtefact() {
		int score = (attack + defense + hitPoints) % 5;
		
		if (score == 0) {
			attack = attackMax = 100 + attack * heroLevel;
			defenseMax = 100;
			hitPointsMax = 100;
			return ("attack");
		} else if (score == 1) {
			defense = defenseMax = 100 + defense * heroLevel;
			attackMax = 100;
			hitPointsMax = 100;
			return ("defense");
		} else if (score == 2) {
			hitPoints = hitPointsMax = 100 + hitPoints * heroLevel;
			attackMax = 100;
			defenseMax = 100;
			return ("hit Points");
		} else {
			attackMax = 100;
			defenseMax = 100;
			hitPointsMax = 100;
		}
		return ("noBonus");
	}

	public void setAttackMax () {
		this.attackMax = 100;
	}
	public void setDefenseMax () {
		this.defenseMax = 100;
	}
	public void setHitPointsMax () {
		this.hitPointsMax = 100;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Hero.index = index;
	}

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
		if (this.heroLevel <= 0) {
			this.heroLevel++;
		}
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
		} else if (this.attack > attackMax) {
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
		} else if (this.defense > defenseMax) {
			this.defense = 100;
		}
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		if (hitPoints < 0){
			this.hitPoints = 0;
		} else if (this.hitPoints > hitPointsMax){
		this.hitPoints = 100;
		}
	}

	public static void setMapSize(int mapSize) {
		Hero.mapSize = mapSize;
	}
}
