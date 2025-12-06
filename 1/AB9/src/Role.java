import java.util.Random;

public abstract class Role {
    public String name;
    public int level;
    public int maxHealth;
    public int currentHealth;
    public int baseDamage;
    public static Random ran = new Random();

    public Role(String name, int lvl){
        this.name = name;
        this.level = lvl;
    }

    public static void main(String[] args){

    }

    public void takeDamage(int amount){
        currentHealth -= amount;
        if (currentHealth < 0){
            currentHealth = 0;
        }
    }

    public void initHealth(int multiplier){
        maxHealth = level * multiplier;
    }

    public static int randomFactor(){
        return ran.nextInt(3) + 1;
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }

    public void heal(int amount){
        currentHealth += amount;
        if (currentHealth > maxHealth){
            currentHealth = maxHealth;
        }
    }

    public abstract void support(Role[] team);

    public abstract int attack();

    public abstract String describe();
}
