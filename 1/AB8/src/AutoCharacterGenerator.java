import java.util.concurrent.ThreadLocalRandom;

public class AutoCharacterGenerator {
    private String name;
    private String race;
    private int age;
    private int classType;
    private double height;
    private static final String[] NAMES =
            {
                    "Aetherblade", "Shadowthorn", "Mysticshade",
                    "Dreadnova", "Riftseeker","Lunarwhisper",
                    "Stormbreaker", "Froststeel", "Eclipsefire",
                    "Thunderfury", "Ironheart", "Phoenixsong",
                    "Serpentstrike", "Doombringer", "Celestialwrath",
                    "Blazefang", "Nightshade", "Silverthorn",
                    "Warriorfrost", "Moonlightshadow"
            };
    private static final String[] RACES = { "Elunari", "Dwarvokai", "Sylvanar", "Aquafinix", "Infernian" };

    public static void main(String[] args){

    }

    public AutoCharacterGenerator(){
        this.classType = generateRandom(6);

        setRandomName();
        setRandomRace();

        this.age = 18;
        this.height = 1.85;
    }

    public AutoCharacterGenerator(int classType){
        this.classType = classType;

        setRandomName();
        setRandomRace();

        this.age = 18;
        this.height = 1.85;
    }

    public AutoCharacterGenerator(int classType, int age){
        this.classType = classType;

        setRandomName();
        setRandomRace();

        this.age = age;
        this.height = 1.85;
    }

    public AutoCharacterGenerator(int classType, int age, double height){
        this.classType = classType;

        setRandomName();
        setRandomRace();

        this.age = age;
        this.height = height;
    }

    public void setRandomName(){
        this.name = NAMES[generateRandom(NAMES.length)];
    }

    public void setRandomRace(){
        this.race = RACES[generateRandom(RACES.length)];
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setClassType(int classType){
        this.classType = classType;
    }

    public int generateRandom(int max){
        return ThreadLocalRandom.current().nextInt(max);
    }

    public static String translateType(int type){
        return switch(type){
            case 1 -> "Bard";
            case 2 -> "Cleric";
            case 3 -> "Monk";
            case 4 -> "Thief";
            case 5 -> "Fighter";
            case 6 -> "Magician";
            default -> "";
        };
    }

    public String createSheet(){
        return String.format("Name: %s\nClass: %s %s%s%s", name, race, translateType(classType), age >= 0 ? "\nAge: " + age : "", height >= 0 ? "Height: " + height : "");
    }
}
