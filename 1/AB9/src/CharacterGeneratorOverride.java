import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class CharacterGeneratorOverride {
    private String name;
    private String race;
    private int age;
    private int classType;
    private double height;

    private static final String[] NAMES = { "Aetherblade", "Shadowthorn", "Mysticshade", "Dreadnova", "Riftseeker","Lunarwhisper", "Stormbreaker", "Froststeel", "Eclipsefire", "Thunderfury", "Ironheart", "Phoenixsong",   "Serpentstrike", "Doombringer", "Celestialwrath", "Blazefang", "Nightshade", "Silverthorn", "Warriorfrost",            "Moonlightshadow" };
    private static final String[] RACES = { "Elunari", "Dwarvokai", "Sylvanar", "Aquafinix", "Infernian" };

    public static void main(String[] args){

    }

    public CharacterGeneratorOverride(int classType, int age, double height){
        this.classType = classType;
        setRandomName();
        setRandomRace();
        setAge(age);
        setHeight(height);
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
        if (this.height < 0.1){
            this.height = 1.85;
        }
    }

    public void setClassType(int classType){
        this.classType = classType;
    }

    public int generateRandom(int max){
        return ThreadLocalRandom.current().nextInt(max);
    }

    public static String translateType(int type){
        return switch (type){
            case 1 -> "Bard";
            case 2 -> "Cleric";
            case 3 -> "Monk";
            case 4 -> "Thief";
            case 5 -> "Fighter";
            case 6 -> "Magician";
            default -> "none";
        };
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "Name: %s\nClass: %s\nAge: %d\nHeight: " + height, name, race + " " + translateType(classType), age);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode(){
        int hash = name.charAt(0);
        hash *= 9;
        hash += age;
        hash *= 9;
        hash += height;
        hash *= 9;
        hash += classType;

        return hash;
    }
}
