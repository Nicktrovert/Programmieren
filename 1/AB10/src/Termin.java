public class Termin {
    public Dringlichkeit dr;
    public Wochentag tag;
    public String event;
    public int stunde;

    public Termin(Wochentag tag, int stunde, String event){
        this.tag = tag;
        this.stunde = stunde;
        this.event = event;
        dr = Dringlichkeit.NORMAL;
    }
    public Termin(Wochentag tag, int stunde, String event, Dringlichkeit dr){
        this.tag = tag;
        this.stunde = stunde;
        this.event = event;
        this.dr = dr;
    }

    @Override
    public String toString(){
        return String.format("%s %d:00 - %s(%s)", tag.toString(), stunde, event, dr.toString());
    }

    public Dringlichkeit getDringlichkeit(){
        return dr;
    }
}
