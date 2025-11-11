import java.util.Arrays;

public class Kuehlschrank {
    public static String[] schrank;

    public static void main(String[] args) {

    }

    public static void setInhalt(String[] inhalt) {
        schrank = inhalt;
    }

    public static boolean schrankLeer() {
        return schrank == null || schrank.length == 0;
    }

    public static int anzahlGetraenke() {
        if (schrankLeer()) {
            return -1;
        }

        int count = 0;
        for (String s : schrank) {
            if (s.contains("milch") || s.contains("saft") || s.contains("wasser")) {
                count++;
            }
        }

        return count;
    }

    public static String schrankOeffnen(){
        if (schrankLeer()) {
            return "Der Kuehlschrank ist leer !";
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < schrank.length; i++) {
            output.append(schrank[i]);
            if (i != schrank.length-1){
                output.append(", ");
            }
        }

        return output.toString();
    }

    public static void printSchrank(){
        System.out.println(schrankOeffnen());
    }
}
