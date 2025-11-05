import java.util.Locale;

public class MatheHelfer {
    public static void main(String[] args) {
        MatheHelfer.subtrahiere(5, 3);

        MatheHelfer.addiere(1, 111, 1111);

        MatheHelfer.dividiere(5.5,11.9);

        MatheHelfer.dividiere(9, 4);

        MatheHelfer.berechneFlaeche(9, 99);

        MatheHelfer.berechneBoxFlaeche(9, 99, 11);

        MatheHelfer.summiere(new int[] {9,10,21});
    }

    public static void subtrahiere(int wert1, int wert2){
        System.out.printf(Locale.US, "%d-%d=%d\n", wert1, wert2, wert1 - wert2);
    }

    public static void addiere(int wert1, int wert2, int wert3){
        System.out.printf(Locale.US, "%d+%d+%d=%d\n", wert1, wert2, wert3, wert1 + wert2 + wert3);
    }

    public static void multipliziere(double wert1, int wert2){
        System.out.printf(Locale.US, "%f*%d=%f\n", wert1, wert2, wert1 * wert2);
    }

    public static void dividiere(double wert1, double wert2){
        System.out.printf(Locale.US, "%f/%f=%f\n", wert1, wert2, wert1 / wert2);
    }

    public static void berechneFlaeche(int seite1, int seite2){
        System.out.printf(Locale.US, "Seiten: %d,%d, Grundflaeche: %d\n", seite1, seite2, seite1*seite2);
    }

    public static void berechneBoxFlaeche(int seite1, int seite2, int hoehe){
        System.out.printf(Locale.US, "Seiten: %d,%d und Hoehe %d, Flaeche: %d\n", seite1, seite2, hoehe, 2*seite1*seite2+2*seite1*hoehe+2*seite2*hoehe);
    }

    public static void summiere(int[] werte){
        System.out.printf(Locale.US, "Summe der Werte ");

        int sum = 0;
        for (int i = 0; i < werte.length; i++) {
            System.out.printf(Locale.US, "%d ", werte[i]);
            sum += werte[i];
        }

        System.out.printf(Locale.US, ": %d\n", sum);
    }
}
