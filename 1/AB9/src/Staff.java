import java.util.Locale;

public class Staff extends Weapon {
    private int magicPower;

    public static void main(String[] args){

    }

    public Staff(String name, int damage, int magicPower) {
        super(name, damage);
        this.magicPower = magicPower;
    }

    @Override
    protected String displayInfo() {
        return super.displayInfo() + String.format(Locale.US, ", Magische Kraft: %d", magicPower);
    }
}
