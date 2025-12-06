import java.util.Locale;

public class Weapon{
    private String name;
    public int damage;

    public static void main(String[] args){

    }

    public Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    protected String displayInfo(){
        return String.format(Locale.US, "Waffe: %s (dps: %s)", name, damage);
    }
}