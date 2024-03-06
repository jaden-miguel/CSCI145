import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player = new Player();
    private String pClass;
    private Scanner scanner = new Scanner(System.in);
    private int x = 0;
    private int y = 0;
    

    public DungeonGame() {
    
            boolean characterClass = false;

            System.out.println("Welcome to the dungeon!! \n" + "You are surrounded by bags of gold and healing elixirs, but beware of the monsters.\n" + "Can you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you?");
            
            System.out.println("=============================================");
            
            while(!characterClass) {
                System.out.println("Select your class:");
                System.out.println("[1] Warrior");
                System.out.println("[2] Thief");
                pClass = scanner.next();
            
                if(pClass.equals("1") || pClass.equals("2")){
                    characterClass = true;
                }
            }

        player.setPlayerClass(pClass);
        x = 10;
        y = 10;
        map  = new DungeonMap(player, x, y);
        
    }



    public void play() {
        boolean gameLoop = true;
            while (gameLoop) {
                //print updated map and win sequence
                if(player.getGold() >= 100){
                    System.out.println("You found 100 gold and escaped the dungeon! Congratualtions!");
                    
                    gameLoop = false;
                    break;
                }

            String userMove;
            map.print();
            print();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a door: [W] up, [S] down, [A] left, [D] right, [Q] quit ==>  ");
            userMove = scanner.next();

            if (userMove.equals("Q") || userMove.equals("q")) {
                System.out.println("You have quit! Loser!");
                gameLoop = false;
                break;
            }

            handleUserInput(userMove);
            if (!isPlayerAlive()) {
                System.out.println("The monster has killed you! See you next game!");
                break;
            }
            
            System.out.println("===================================================");
            
        }
    
    }
    private void print(){
        System.out.println("HP = " + player.getHealth());
        System.out.println("GP = " + player.getGold());
    }

    private void handleUserInput(String userMove) {

        switch (userMove.toLowerCase()) {
            case "w":
                if (map.playerLocationValid(0, -1)) {
                    map.playerLocation(0, -1);
                }
                break;

            case "s":
                if (map.playerLocationValid(0, 1)) {
                    map.playerLocation(0, 1);
                }
                break;

            case "a":
                if (map.playerLocationValid(-1, 0)) {
                    map.playerLocation(-1, 0);
                }
                break;

            //fix directions s Game Over!o player move in correct direction
            case "d":
                if (map.playerLocationValid(1, 0)) {
                    map.playerLocation(1, 0);
                }
                break;


            default:
                System.out.println("You cannot move there.");
                break;
        }
    }

    private boolean isPlayerAlive() {
        return player.getHealth() > 0;
    }
    //public void setIsPlayerAlive(boolean x) {
		//isPlayerAlive = x;
    //}
    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }
}