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
                output += ":00 - frei\n"; // todo - :D
            }
            else{
                output += planer[index][i].toString() + "\n";
            }
        }

        return output;
    }

    public String tagansicht(Wochentag wt){
        return tagansicht(translateWochentag(wt));
    }

    public String wochenansicht(){
        String result = "";
        for (int i = 0; i < planer.length; i++){
            result += tagansicht(i);
            result += "\n";
        }
        return result;
    }

    public void alleEinerDringlichkeit(Dringlichkeit dr){
        for (int i = 0; i < planer.length; i++){
            for (int j = 0; j < planer[i].length; j++){
                if (planer[i][j] != null && planer[i][j].getDringlichkeit() == dr){
                    System.out.println(planer[i][j].toString());
                }
            }
        }
    }

    private int translateWochentag(Wochentag wt){
        return switch(wt){
            case MONTAG -> 0;
            case DIENSTAG -> 1;
            case MITTWOCH -> 2;
            case DONNERSTAG -> 3;
            case FREITAG -> 4;
            case SAMSTAG -> 5;
            case SONNTAG -> 6;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        Terminplaner tp = new Terminplaner("Max Mustermann");

        tp.terminHinzu(Wochentag.MONTAG, 14, "Meeting");
        tp.terminHinzu(Wochentag.DIENSTAG, 10, "Gym", Dringlichkeit.HOCH);
        tp.terminHinzu(Wochentag.MONTAG, 16, "Lunch");
        tp.terminHinzu(Wochentag.MITTWOCH, 12, "Project Discussion", Dringlichkeit.NIEDRIG);
        tp.terminHinzu(Wochentag.DONNERSTAG, 15, "Coffee Break", Dringlichkeit.HOCH);
        tp.terminHinzu(Wochentag.DONNERSTAG, 8, "Team Standup");
        tp.terminHinzu(Wochentag.SAMSTAG, 10, "Hiking", Dringlichkeit.NORMAL);
        tp.terminHinzu(Wochentag.SONNTAG, 20, "Movie Night");
        tp.terminHinzu(Wochentag.MONTAG, 10, "Training", Dringlichkeit.HOCH);
        tp.terminHinzu(Wochentag.FREITAG, 18, "Dinner");

        System.out.println("Tagansicht");
        System.out.println(tp.tagansicht(Wochentag.DONNERSTAG));

        System.out.println("Wochenansicht");
        System.out.println(tp.wochenansicht());

        System.out.println("Dringlichkeit");
        tp.alleEinerDringlichkeit(Dringlichkeit.HOCH);
    }
}
