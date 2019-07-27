import view.CreatePlayer;
import view.GuiMain;
import view.SelectPlayer;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello Swingy world, did you miss me?");

//		System.out.println("Do you want to play on the console or gui?");
//
//		Scanner scanner = new Scanner(System.in);
//		String guiChoice = scanner.nextLine();
//
//		switch (guiChoice.toLowerCase()) {
//			case "console":
//				System.out.println("you chose console");
//				break;
//			case "gui":
				System.out.println("you chose gui");
				// new SelectPlayer();
				new GuiMain("selectPlayer");
				CreatePlayer player = new CreatePlayer();
//				play
//				break;
//			default:
//				System.out.println("Your choice in insignificant to me, exiting...");
//				System.exit(0);
//		}

		System.out.println("Swingy missed you Mk");
	}
}
