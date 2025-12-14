import java.util.Random;

public class Dagger implements Weaponizeable {
    public int Dmg;
    public int parry;
    public int bleed;
    public double speed;

    public static void main(String[] args) {

    }

    public Dagger(int dmg, double speed, int parryChance, int bleedChance) {
        Dmg = dmg;
        this.speed = speed;
        parry = parryChance;
        bleed = bleedChance;
    }

    @Override
    public double attack() {
        return Dmg * speed;
    }

    @Override
    public boolean parry() {
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        return randomValue < parry;
    }

    public boolean bleed(){
        Random rand = new Random();
        int randomValue = rand.nextInt(100);
        return randomValue < bleed;
    }
}
