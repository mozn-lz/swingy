package view;

public class DrawMap {
	public DrawMap(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.println('*');
			}
		}
	}
}
