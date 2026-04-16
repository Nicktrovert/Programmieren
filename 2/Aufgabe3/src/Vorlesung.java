import java.util.Objects;

public class Vorlesung {
    private String studiengruppe;
    private String titel;
    private String dozent;
    private int teilnehmerzahl;

    public Vorlesung(String studiengruppe, String titel, String dozent, int teilnehmerzahl){
        this.studiengruppe = studiengruppe;
        this.titel = titel;
        this.dozent = dozent;
        this.teilnehmerzahl = teilnehmerzahl;
    }

    public String getStudiengruppe() {
        return studiengruppe;
    }
    public String getTitel() {
        return titel;
    }
    public String getDozent() {
        return dozent;
    }
    public int getTeilnehmerzahl() {
        return teilnehmerzahl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vorlesung)) return false;
        Vorlesung v = (Vorlesung) o;
        return Objects.equals(studiengruppe, v.studiengruppe) &&
                Objects.equals(titel, v.titel) &&
                Objects.equals(dozent, v.dozent) &&
                teilnehmerzahl == v.teilnehmerzahl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studiengruppe, titel, dozent, teilnehmerzahl);
    }
}
