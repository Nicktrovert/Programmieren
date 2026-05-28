import java.util.ArrayList;
import java.util.List;

public class Modul {
    private String bezeichnung;
    private String kuerzel;
    private String studiengang;
    private int semester;
    private String art;
    private double ects;
    private String pruefungsform;
    private String verantwortlicher;
    private ArrayList<Veranstaltung> veranstaltungen;

    public Modul(List<List<String>> data){
        // data.get(0) : 0-7 Variablen für Modul
        // data.get(0-(data.length()-1)) : 0-2 variablen für Veranstaltung

    }

    public String getBezeichnung(){
        return bezeichnung;
    }
    public String getKuerzel() { return kuerzel; }
    public String getStudiengang() { return studiengang; }
    public int getSemester() { return semester; }
    public String getArt() { return art; }
    public double getECTS() { return ects; }
    public String getPruefungsform() { return pruefungsform; }
    public String getVerantwortlicher() { return verantwortlicher; }
    public ArrayList<Veranstaltung> getVeranstaltungen() { return veranstaltungen; }

    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }
    public void setKuerzel(String kuerzel) { this.kuerzel = kuerzel; }
    public void setStudiengang(String studiengang) { this.studiengang = studiengang; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setArt(String art) { this.art = art; }
    public void setECTS(double ects) { this.ects = ects; }
    public void setPruefungsform(String pruefungsform) { this.pruefungsform = pruefungsform; }
    public void setVerantwortlicher(String verantwortlicher) { this.verantwortlicher = verantwortlicher; }
    public void setVeranstaltungen(ArrayList<Veranstaltung> veranstaltungen) { this.veranstaltungen = veranstaltungen; }
}
