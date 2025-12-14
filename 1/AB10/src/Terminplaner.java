public class Terminplaner {
    public String name;
    public Termin[][] planer;

    public Terminplaner(String eigner){
        name = eigner;
        planer = new Termin[7][24];
    }

    public boolean terminHinzu(Wochentag tag, int stunde, String event){
        if (planer[Wochentag.valueOf(tag.toString()).ordinal()][stunde] == null){
            planer[Wochentag.valueOf(tag.toString()).ordinal()][stunde] = new Termin(tag, stunde, event);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean terminHinzu(Wochentag tag, int stunde, String event, Dringlichkeit dr){
        if (planer[Wochentag.valueOf(tag.toString()).ordinal()][stunde] == null){
            planer[Wochentag.valueOf(tag.toString()).ordinal()][stunde] = new Termin(tag, stunde, event, dr);
            return true;
        }
        else{
            return false;
        }
    }

    public String tagansicht(int index){
        String output = "";

        for (int i = 0; i < planer[index].length; i++){
            if (planer[index][i] == null){
                output += "\n"; // todo - :D
            }
            else{
                output += planer[index][i].toString();
            }
        }

        return output;
    }

    public String tagansicht(Wochentag wt){
        return tagansicht(Wochentag.valueOf(wt.toString()));
    }

    public String wochenansicht(){
        String result = "";
        for (int i = 0; i < planer.length; i++){
            result += tagansicht(i);
            result += "\n"
        }
        return result;
    }

    public vpod alleEinerDringlichkeit()
}
