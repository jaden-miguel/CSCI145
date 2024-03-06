
public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;
    
    private String playerLogo = "P";

    //Warrior Player Class
	private final String WARRIOR_LOGO = "W";
	private final int WARRIOR_BEGINNING_HEALTH = 100;
	private final int WARRIOR_BEGINNING_GOLD = 0;
	private final int WARRIOR_BEGINNING_DAMAGE = 15;
    //Thief Player Class
	private final String THIEF_LOGO = "T";
	private final int THIEF_BEGINNING_HEALTH = 70;
	private final int THIEF_BEGINNING_GOLD = 0;
	private final int THIEF_BEGINNING_DAMAGE = 10;
	private final double THIEF_LOOT_MODIFIER = 0.2;

     //Creating accessors so that I can access player attributes at a given time.
	public int getHealth() {
		return health;
	}
	public int getGold() {
		return gold;
	}
	public int getDamage() {
		return damage;
	}
	public String getPlayerClass() {
		return playerClass;
	}
	public String getPlayerLogo() {
		return playerLogo;
	}
	public double getLootModifier() {
		return lootModifier;
	}
	


     //Creating Mutators so that I can change a player's attributes.
	public void setHealth(int healthNew) {
		health = healthNew;
	}
	public void setGold(int goldNew) {
		gold = goldNew;
	}
	public void setDamage(int damageNew) {
		damage = damageNew;
	}
	public void setPlayerClass(String playerClassNew) {
		playerClass = playerClassNew;
		if (playerClass.equals("1")) {
			health = WARRIOR_BEGINNING_HEALTH;
			gold = WARRIOR_BEGINNING_GOLD;
			damage = WARRIOR_BEGINNING_DAMAGE;
			playerLogo = WARRIOR_LOGO;
		}
		else if(playerClass.equals("2")) {
			health = THIEF_BEGINNING_HEALTH;
			gold = THIEF_BEGINNING_GOLD;
			damage = THIEF_BEGINNING_DAMAGE;
			playerLogo = THIEF_LOGO;
		}
	}

	public void setPlayerLogo(String playerLogo) {
		this.playerLogo = playerLogo;
	}

	
    //public void attack(Monster player) {
		//System.out.println("You attack and hit the " + opponent.getMonsterType() + "for" + getDamage() + "damage!");
		//player.onHit(getDamage());
    //}

    public void onHit(int damageHit) {
		health = health - damageHit;
		
		
    }

    public void onHeal(int healthHeal) {
	//Health characteristics for Warrior Class
		if (getPlayerClass().equals("1")) {
			health = health + healthHeal;
			
			if (health >= WARRIOR_BEGINNING_HEALTH) {
				health = WARRIOR_BEGINNING_HEALTH;
			}
			else {
				health = health;
			}
		}
	//Health characteristics for Thief Class
		
		else if (getPlayerClass().equals("2")) {
				health = health + healthHeal;
			if (health >= THIEF_BEGINNING_HEALTH) {
				health = THIEF_BEGINNING_HEALTH;
			}
			else {
				health = health;
		}
	}
		
    }

    public void onLoot(double goldLooted) {
	//Loot characteristics for Warrior Class
		if (getPlayerClass().equals("1")) {
			int convertedLoot = (int)goldLooted;
			int totalGoldLooted = convertedLoot + gold;
			setGold(totalGoldLooted);
		}
		else if(getPlayerClass().equals("2")) {
			double lootModified = (Math.round(10*(goldLooted * (1+THIEF_LOOT_MODIFIER)))/10);
			gold = gold + (int)lootModified;
		}
    }
}
