import java.util.Arrays;

public class VariableArgumente {
    public static void main(String[] args){
        System.out.println("Summe: " + sum(4, 7, 98, 100));

        System.out.println("Durchschnitt: " + average(3.6, 7.9, 22.1, 99));



        System.out.println("Vorwaerts:");

        printTexts(true, "aloha", "hawaii", "fun", "sun", "good times", "beach");

        System.out.println("Rueckwaerts:");

        printTexts(false, "aloha", "hawaii", "fun", "sun", "good times", "beach");

        System.out.println("Dreiecke!");

        printTriangles( 4, 5, 9);
    }

    public static int sum(int... numbers){
        return Arrays.stream(numbers).sum();
    }

    public static double average(double... numbers){
        double sum = 0;
        for (double number : numbers){
            sum += number;
        }

        return sum/(float)numbers.length;
    }

    public static void powers(int base, double... exponents){
        for (int i = 0; i < exponents.length; i++){
            System.out.println(Math.pow(base, exponents[i]));
        }
    }

    public static void printTexts(boolean order, String... sentences){
        if (order){
            for (int i = 0; i < sentences.length; i++){
                System.out.println(sentences[i]);
            }
        }
        else{
            for (int i = sentences.length-1; i >= 0; i--){
                System.out.println(sentences[i]);
            }
        }
    }

    public static void printTriangles(int... sizes){
        for (int size : sizes) {
            System.out.println(generateTriangle(size));
        }
    }

    public static String generateTriangle(int size){
        String triangle = "";
        for (int j = 0; j < size; j++){
            triangle += String.valueOf(j+1).repeat(j+1) + "\n";
        }
        return triangle;
    }
}
