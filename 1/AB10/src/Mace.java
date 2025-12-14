import java.util.Random;

public class Mace implements Weaponizeable {
    public int Dmg;
    public int parry;
    public int bleed;
    public double speed;

    public static void main(String[] args){

    }

    public Mace(int dmg, double speed, int parryChance, int stunChance){
        this.Dmg = dmg;
        this.speed = speed;
        this.parry = parryChance;
        this.bleed = stunChance;
    }

    @Override
    public double attack() {
        return Dmg*speed;
    }

    @Override
    public boolean parry() {
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        return randomValue < parry;
    }

    public boolean stun(){
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        return randomValue < bleed;
    }
}
