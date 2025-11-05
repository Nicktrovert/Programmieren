import java.util.Locale;

public class MatheHelferReturns {
    public static void main(String[] args) {
        System.out.println(MatheHelferReturns.subtrahiere(5, 3));
        System.out.println(MatheHelferReturns.addiere(1, 111, 1111));
        System.out.println(MatheHelferReturns.dividiere(5.5, 11.9));
        System.out.println(MatheHelferReturns.dividiere(9, 4));
        System.out.println(MatheHelferReturns.berechneFlaeche(9, 99));
        System.out.println(MatheHelferReturns.berechneBoxFlaeche(9, 99, 11));
    }

    public static int subtrahiere(int wert1, int wert2){
        return wert1 - wert2;
    }

    public static int addiere(int wert1, int wert2, int wert3){
        return wert1 + wert2 + wert3;
    }

    public static double multipliziere(double wert1, int wert2){
        return wert1 * wert2;
    }

    public static double dividiere(double wert1, double wert2){
        return wert1 / wert2;
    }

    public static int berechneFlaeche(int seite1, int seite2){
        System.out.printf(Locale.US, "Seiten: %d,%d\n", seite1, seite2);
        return seite1 * seite2;
    }

    public static int berechneBoxFlaeche(int seite1, int seite2, int hoehe){
        System.out.printf(Locale.US, "Seiten: %d,%d und Hoehe: %d\n", seite1, seite2, hoehe);
        return 2*seite1*seite2+2*seite1*hoehe+2*seite2*hoehe;
    }
}

