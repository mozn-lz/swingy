package view.console;

import model.Hero;

public class PrintContent {
	public PrintContent() {
	}
//	public heroStats(Hero hero) {
//	}

	public PrintContent(String message) {
		System.out.println(message);
	}
	public void printContentInline(String message) {
		System.out.print(message);
	}
}
