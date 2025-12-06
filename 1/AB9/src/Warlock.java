public class Warlock extends Role{

    public Warlock(String name, int lvl){
        super(name,lvl);
        baseDamage = 10+level*2;
        initHealth(30);
    }

    public static void main(String[] args){

    }

    @Override
    public void support(Role[] team) {
        int healAmount = level*2;
        int totalSelfHarm = 0;
        for (Role role : team) {
            if (role != null){
                if (role.isAlive()){
                    role.heal(healAmount);
                    int selfDamage = level/2;
                    selfDamage = Math.max(selfDamage, 1);
                    takeDamage(selfDamage);
                    totalSelfHarm += selfDamage;
                }
            }
        }

        System.out.println(name + " kanalisiert Seelenenergie und heilt die Gruppe leicht.");
        System.out.println(name + " erleidet " + totalSelfHarm + " Rueckstossschaden.");
    }

    @Override
    public int attack() {
        int damage = baseDamage * randomFactor();

        if (ran.nextInt(4) == 0){
            damage += baseDamage;
            System.out.println(name + " entfesselt eine Seelenexplosion + " + baseDamage + " bonus Schaden");
        }

        return damage;
    }

    @Override
    public String describe() {
        return String.format("Name: %s (%s), Level: %d, Health: %d/%d, Damage: %d", name, getClass().getName(), level, currentHealth, maxHealth, baseDamage);
    }
}
