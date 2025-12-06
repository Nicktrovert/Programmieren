public class Assassin extends Role{
    private boolean nextAttackBonus;

    public Assassin(String name, int lvl){
        super(name, lvl);
        baseDamage = 12+level*2;
        initHealth(25);
    }

    public static void main(String[] args){

    }

    public int attack(){
        int damage = baseDamage * randomFactor();
        if (nextAttackBonus){
            nextAttackBonus = false;
            System.out.println(name + " landet einen kritischen Hinterhalt.");
            return damage*2;
        }
        else{
            return damage;
        }
    }

    @Override
    public void support(Role[] team) {
        nextAttackBonus = true;

        System.out.println(name + " verschwindet im Schatten... der naechste Angriff wird verstaerkt.");
    }

    @Override
    public String describe() {
        return String.format("Name: %s (%s), Level: %d, Health: %d/%d, Damage: %d", name, getClass().getName(), level, currentHealth, maxHealth, baseDamage);
    }
}
