import java.util.Scanner;
import java.util.Random;

public class Room {
    private boolean visited = false;
	private int healAmount = 0;
	private int randomMonsterDamage = 0;
	private String mapIcon;



    public void enter(Player player) {
	
		//initializes the random class
		Random random = new Random();
	
		//initializes the scanner class
		Scanner scanner = new Scanner(System.in);

		int encounterType = random.nextInt(3) + 1;
	
		if(visited == false){
			
			if (encounterType == 1) {
				Monster opponent = new Monster();
				//input what type of monster we want.
				opponent.randomMonster();
			
				System.out.println("A " + opponent.getMonsterType() + " appears!!");
				boolean monsterAlive = true;
			
				while (monsterAlive != false) {
					System.out.println("Select an action: [1] Attack, [2] Run ==>");
					//asks user for their action and stores response in variable userAction
					String usersAction = scanner.nextLine();
				
					if (usersAction.equals("1")) {
					//monster attacks
						randomMonsterDamage = random.nextInt(opponent.getDamage()+1);
                    	
                    	System.out.println("The " + opponent.getMonsterType() + " " + "attacks and hits you for " + randomMonsterDamage + " damage!");
                    	System.out.println("You attack and hit the " + opponent.getMonsterType() + " " + "for " + player.getDamage() + " damage!");
						player.onHit(randomMonsterDamage);
                    	opponent.onHit(player.getDamage());
						System.out.println("HP = " + player.getHealth());

						if(opponent.getHealth() <= 0){
							monsterAlive = false;
							int monsterLoot = random.nextInt(11) + 5;
							player.onLoot(monsterLoot);
							System.out.println("You have been rewarded " + monsterLoot + " gold for defeating the " + opponent.getMonsterType() + "!!");
						}
						else if(player.getHealth() <= 0) {
							System.out.println("You have died!");
							break;

						}

					}
					else if (usersAction.equals("2")) {
						//player runs
						player.onHit(randomMonsterDamage);
                    	System.out.println("You attempt to run and the " + opponent.getMonsterType() + " attacks and hits you for " + randomMonsterDamage + " damage!");
                    	System.out.println("You retain some dignity...");
						monsterAlive = false;
					}
					else {
						System.out.println("Invalid Input");
					}
				}
			}
		
		else if (encounterType == 2) {
			//if loot type = 1 then user receives Gold as loot.
			
				
				int goldAmount = random.nextInt(10) + random.nextInt(5) + 2;
                player.onLoot(goldAmount);
				System.out.println("You have found a room containing a bag of " + goldAmount + " gold!");
			}
		
			//if lootTyper = 2 then user receives a health potion
		else if (encounterType == 3) {
				int healAmount = random.nextInt(10) + 1;
				
                
				int potionAmount = healAmount;
				player.onHeal(potionAmount);
				System.out.println("You have found a room containing a potion for: " + potionAmount + " health!");
				
    		
		}
		else{
			System.out.println("You done messed up");
		}
	}
	visited = true;
	}
	
	public boolean hasVisited() {
        return this.visited;
	}
	
	public String getMapIcon(){
		return mapIcon;
	}
	public void setMapIcon(String mapIcon){
		this.mapIcon = mapIcon;
	}
}
