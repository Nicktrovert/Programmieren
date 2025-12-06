import java.util.Scanner;

public class Priest extends Role{

    public Priest(String name, int lvl) {
        super(name, lvl);
        baseDamage = 3+level/2;
        initHealth(35);
    }

    public static void main(String[] args){

    }

    public int attack() {
        return baseDamage * randomFactor();
    }

    @Override
    public void support(Role[] team) {
        int healPower = level * 3;

        for (Role role : team) {
            if (role != null){
                if (role.isAlive()){
                    role.heal(healPower);
                }
            }
        }

        System.out.println(name + " wirkt ein Gruppenheilungs-Gebet.");
    }

    @Override
    public String describe() {
        return String.format("Name: %s (%s), Level: %d, Health: %d/%d, Damage: %d", name, getClass().getName(), level, currentHealth, maxHealth, baseDamage);
    }
}
