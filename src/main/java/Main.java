import model.Hero;
import model.InitGame;
import model.InitHero;

public class Main {
	public static void main(String[] args) {
		String[] heroes = {
				// name  cls   lv   xp  At  Df  ht
				"Ichigo	death	0	0	50	20	40", "Vegeta	Saiyan	0	0	50	40	40",
				"Naruto	Ninja	0	0	50	40	40", "Sitama	Human	0	0	100	10	100",
				"Eren	Titan	0	0	40	40	30","Kirito	Gamer	0	0	30	70	50"};

		System.out.println("Hello Swingy world, did you miss me?");
//		System.out.println("Do you want to play on the console or gui?");
//		Scanner scanner = new Scanner(System.in);
//		String guiChoice = scanner.nextLine();
//
//		switch (guiChoice.toLowerCase()) {
//			case "console":
//				System.out.println("you chose console");
//				break;
//			case "gui":

/*	System.out.println("you chose gui");
	new GuiMain("selectPlayer");
 */
		new InitHero().setHeroes(heroes);		//	set push heroes from file to program 'hero lost'
		new InitGame();

				// CreatePlayer player = new CreatePlayer();
//				play
//				break;
//			default:
//				System.out.println("Your choice in insignificant to me, exiting...");
//				System.exit(0);
//		}
		System.out.println("Main: Swing missed you Mk");
	}
}
