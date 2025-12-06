public class Dungeon {
    public Role[] members;
    public String dungeonName;
    public int minLevel;
    public int maxLevel;

    public static void main(String[] args){

    }

    public Dungeon(String name, int maxMembers, int minLvl, int maxLvl){
        members = new Role[maxMembers];
        dungeonName = name;
        minLevel = minLvl;
        maxLevel = maxLvl;
    }

    public boolean addMember(Role r){
        if (r.level > minLevel && r.level < maxLevel){
            for (int i = 0; i < members.length; i++) {
                if (members[i] == null) {
                    members[i] = r;
                    return true;
                }
            }
            System.out.println("error");
            return false;
        }
        else{
            System.out.println("error");
            return false;
        }
    }

    public void printRaid(){
        System.out.printf("Dungeon: %s, Level requirement: %d, Max Level: %d\n", dungeonName, minLevel, maxLevel);
        for (Role r : members){
            System.out.println("-\t" + r.describe());
        }
    }

    public void identifyRoles(Role... roles){
        for (Role r : roles){
            System.out.printf("%s %s (lvl: %d) is approaching\n", r.getClass().getName(), r.name, r.level);
        }
    }

    public void bossFight(int bossHealth){
        int round = 1;

        while (bossHealth > 0 && anyAlive()){
            System.out.println("--- Runde " + round + " ---");
            for (Role r : members){
                if (r.getClass().getName().equals("Priest")){
                    r.support(members);
                }
                else if (r.getClass().getName().equals("Guardian")){
                    r.support(members);
                }
                else{
                    int damage = r.attack();
                    bossHealth -= damage;
                    System.out.println(r.name + " verursacht " + damage + " Schaden. Boss HP: " + bossHealth);
                }
            }
        }
    }

    private boolean anyAlive(){
        boolean anyAlive = false;

        for (Role r : members){
            if (r.isAlive()){
                anyAlive = true;
                break;
            }
        }

        return anyAlive;
    }
}
