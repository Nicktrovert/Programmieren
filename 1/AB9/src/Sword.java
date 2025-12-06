import java.util.Locale;

public class Sword extends Weapon {
    private double speed;

    public static void main(String[] args){

    }

    public Sword(String name, int damage, double speed){
        super(name, damage);
        this.speed = speed;
    }

    @Override
    protected String displayInfo(){
        return super.displayInfo() + String.format(Locale.US, ", Geschwindigkeit: %.1f", speed);
    }
}
