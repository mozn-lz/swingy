package model;

public class Terminate {
    Hero hero = new Hero();
    public Terminate(String result) {
        System.out.println("into Terminating?");
        switch (result){
            case "dead":
                System.out.println("Your dead. Your defence is " + hero.getDefense());
                break;
            case "win":
                System.out.println("Congratulations, you win the game.");
                break;
            default:
                System.out.println("lol, minor crush, the game will restart now.");
        }
        new InitGame();
    }
}
