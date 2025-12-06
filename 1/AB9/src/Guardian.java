public class Guardian extends Role {

    public Guardian(String name, int lvl) {
        super(name, lvl);
        baseDamage = 5+level;
        initHealth(50);
    }

    public static void main(String[] args){

    }

    public int attack(){
        return baseDamage * randomFactor();
    }

    @Override
    public void support(Role[] team) {
        System.out.println(super.name + " stellt sich schuetzend vor die Gruppe.");
        heal(level * 2);
    }

    @Override
    public String describe() {
        return String.format("Name: %s (%s), Level: %d, Health: %d/%d, Damage: %d", name, getClass().getName(), level, currentHealth, maxHealth, baseDamage);
    }
}
