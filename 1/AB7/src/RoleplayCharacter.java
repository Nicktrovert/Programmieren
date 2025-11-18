public class RoleplayCharacter {
    public String name;
    public String race;
    public int age;
    public int classType;
    public double height;


    public static void main(String[] args){
        RoleplayCharacter ro = new RoleplayCharacter();
        ro.name = "Muffin";
        ro.race = "food";
        ro.age = 25;
        ro.classType = 518352938;
        ro.height = 150;
        System.out.println(intro(ro));
    }

    public static String intro(RoleplayCharacter platzhalter){
        return String.format("Name: %s\nRasse: %s\nAlter: %d\nKlassen-ID: %d\nGroesse: " + platzhalter.height, platzhalter.name, platzhalter.race, platzhalter.age, platzhalter.classType);
    }
}
