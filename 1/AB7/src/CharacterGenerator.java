import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class CharacterGenerator{
    private String name;
    private String race;
    private int age;
    private int classType;
    private double height;
    final private String[] NAMES = { "Aetherblade", "Shadowthorn", "Mysticshade", "Dreadnova", "Riftseeker","Lunarwhisper", "Stormbreaker", "Froststeel", "Eclipsefire", "Thunderfury", "Ironheart", "Phoenixsong", "Serpentstrike", "Doombringer", "Celestialwrath", "Blazefang", "Nightshade", "Silverthorn", "Warriorfrost", "Moonlightshadow" };
    final private String[] RACES = { "Elunari", "Dwarvokai", "Sylvanar", "Aquafinix", "Infernian" };

    public static void main(String[] args){

    }

    public void setRandomName(){
        this.name = NAMES[generateRandom(NAMES.length)];
    }

    public void setRandomRace(){
        this.race = RACES[generateRandom(RACES.length)];
    }

    public void setAge(int age){
        if (age >= 1){
            this.age = age;
        }
    }

    public void setHeight(double height){
        DecimalFormat df = new DecimalFormat("#.##");
        this.height = Double.parseDouble(df.format(height));
    }

    public void setClassType(int classType){
        this.classType = classType;
    }

    public int generateRandom(int max){
        return (ThreadLocalRandom.current().nextInt(0, max));
    }

    public static String translateType(int type){
        return switch(type){
            case 1 -> "Bard"; // best class
            case 2 -> "Cleric";
            case 3 -> "Monk"; // overpowered
            case 4 -> "Thief";
            case 5 -> "Fighter";
            case 6 -> "Magician";
            default -> "none";
        };
    }

    public String createSheet(){
        return String.format("Name: %s\nClass: %s %s%s%s", name, race, translateType(classType), age >= 0 ? "\nAge: " + age : "", height >= 0 ? "Height: " + height : "");
    }

}