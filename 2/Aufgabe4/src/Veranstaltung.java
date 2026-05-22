public class Veranstaltung {
    private String titel;
    private String dozenten;
    private double sws;

    public Veranstaltung(String titel, String dozenten, int sws){
        this.titel = titel;
        this.dozenten = dozenten;
        this.sws = sws;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDozenten() {
        return dozenten;
    }
    public void setDozenten(String dozenten) {
        this.dozenten = dozenten;
    }

    public double getSws() {
        return sws;
    }
    public void setSws(double sws) {
        this.sws = sws;
    }
}
