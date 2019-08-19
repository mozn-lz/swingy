package za.wethinkcode.swingy.view.console;

public class DrawMap {
	public DrawMap(String[][] map, int max ) {
		for (int i = 0; i < max ; i++) {
			for (int j = 0; j < max ; j++) {
				System.out.print(map[i][j] + "    ");
			}
			new PrintContent("\n");
		}
	}
}
