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

        this.veranstaltungen = new ArrayList<>();

        if (data == null || data.isEmpty()) {
            return;
        }

        List<String> header = data.get(0);

        if (header.size() > 0) this.bezeichnung = header.get(0);
        if (header.size() > 1) this.kuerzel = header.get(1);
        if (header.size() > 2) this.studiengang = header.get(2);

        if (header.size() > 3) {
            String semStr = header.get(3);
            try {
                this.semester = Integer.parseInt(semStr);
            } catch (NumberFormatException e) {
                this.semester = 0;
            }
        }

        if (header.size() > 4) this.art = header.get(4);

        if (header.size() > 5) {
            String ectsStr = header.get(5).replace(',', '.');
            try {
                this.ects = Double.parseDouble(ectsStr);
            } catch (NumberFormatException e) {
                this.ects = 0.0;
            }
        }

        if (header.size() > 6) this.pruefungsform = header.get(6);
        if (header.size() > 7) this.verantwortlicher = header.get(7);

        for (int i = 1; i < data.size(); i++) {
            List<String> eventLine = data.get(i);

            if (eventLine == null || eventLine.isEmpty()) {
                continue;
            }

            if (eventLine.size() >= 3) {
                String titel = eventLine.get(0);
                String dozenten = eventLine.get(1);

                double sws = 0.0;
                try {
                    String swsStr = eventLine.get(2).replace(',', '.');
                    sws = Double.parseDouble(swsStr);
                } catch (NumberFormatException e) {
                    sws = 0.0;
                }

                Veranstaltung v = new Veranstaltung(titel, dozenten, sws);
                this.veranstaltungen.add(v);
            }
        }
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
