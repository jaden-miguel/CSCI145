import java.util.Random;
// monster class - Jaden

public class Monster {
    private int health;
    private int damage;
    private String monsterType;
    

    //accessor method for damage
    public int getDamage(){
        return damage;
    }
    //mutator setting Damage
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public boolean getIsMonsterAlive(){
        return health > 0;
    }
    public void onHit(int damage){
        health -= damage;

        if(health <= 0){ 
            System.out.println(this.monsterType + " has died!");
        }
    }

    public String getMonsterType(){
        return monsterType;
    }

    public void randomMonster(){

        String[] monsterClass = {"Goblin", "Zombie", "Orc", "Deneke"};

        Random random = new Random();

        int monsterClassIndex = random.nextInt(monsterClass.length);
        this.monsterType = monsterClass[monsterClassIndex];


        if(this.monsterType.equals("Goblin")){
            this.health = 6;
            this.damage = 10;
        }
        else if(this.monsterType.equals("Zombie")){
            this.health = 12;
            this.damage = 15;
        }
        else if(this.monsterType.equals("Orc")){
            this.health = 18;
            this.damage = 20;
        }
        else if(this.monsterType.equals("Deneke")){
            this.health = 55;
            this.damage = 5;
        }
    }

}
