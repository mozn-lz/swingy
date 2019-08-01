package view;

import controller.Action;
import model.Hero;

import java.util.Random;

public class DrawMap {
	public DrawMap(int size) {
		Hero hero = new Hero();

		int enemyCout = size/3;
		boolean findIndicator = false;
//		String heroSym = "i";
		String heroSym = "H";
//		String enemySym = "O";
		String enemySym = "E";
		String blank = "*";

		if (enemyCout <= 0){
			enemyCout++;
		}
		System.out.println("enemyCout = " + enemyCout);
		int enemies[] = new int [enemyCout];
		new Random(size);

		for (int i = 0; i < size; i++) {
			for (int l = 0; l < enemyCout; l++) {
				enemies[l] = getEnemy(size);
			}
//			if (i <=8){
//				System.out.print("0");
//			}
//			System.out.print(i + 1 + " ");
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < enemyCout; k++) {		// if hero position
					if ((i == hero.getCoordenateY() && j == hero.getCoordenateX()) && (j == enemies[k])) {
						findIndicator = true;
					}
					if (i == hero.getCoordenateY() && j == hero.getCoordenateX()) {
						System.out.print(heroSym +"   ");
					} else if (j == enemies[k]) {    // if enemy position
						System.out.print(enemySym + "   ");
					} else {
						System.out.print(blank + "   ");
					}
				}
			}
			System.out.println();
		}
		if (findIndicator == true) {
			new Action();
		}
	}

	private int getEnemy(int max) {
		int min = 0;
		Random r = new Random();
		int rtn = r.nextInt(max);
//		System.out.println("rtn = " + rtn);
		return rtn;
	}
}
