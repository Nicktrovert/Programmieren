import java.time.LocalDateTime;

public class Kollege implements Comparable<Kollege>, IKollege {
    public int personalNummer;
    public int einstellungsJahr;
    public String name;

    public static void main(String[] args){

    }

    public Kollege(int personalNummer, int einstellungsJahr, String name){
        this.personalNummer = personalNummer;
        this.einstellungsJahr = einstellungsJahr;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, %d", personalNummer, name, einstellungsJahr);
    }

    @Override
    public void nameAendern(String neuerName) {
        this.name = neuerName;
    }

    @Override
    public int dienstjahre() {
        return LocalDateTime.now().getYear() - einstellungsJahr;
    }

    @Override
    public int compareTo(Kollege o) {
        return Integer.compare(o.dienstjahre(), this.dienstjahre());
    }
}
