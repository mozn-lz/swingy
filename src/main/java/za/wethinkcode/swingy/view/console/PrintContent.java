package za.wethinkcode.swingy.view.console;

import za.wethinkcode.swingy.model.Hero;

public class PrintContent {
	public PrintContent() {
	}

	public PrintContent(String message) {
		System.out.println(message);
	}
	public void printContentInline(String message) {
		System.out.print(message);
	}
}
