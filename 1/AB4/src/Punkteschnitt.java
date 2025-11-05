public class Punkteschnitt {
    public static void main(String[] args){
        int number1 = 85;
        System.out.println("Punkte 1: " + number1);
        int number2 = 90;
        System.out.println("Punkte 2: " + number2);
        int number3 = 78;
        System.out.println("Punkte 3: " + number3);
        int number4 = 92;
        System.out.println("Punkte 4: " + number4);
        int number5 = 88;
        System.out.println("Punkte 5: " + number5);

        int additionAllNumbers =  number1 + number2 + number3 + number4 + number5;

        System.out.println("Durchschnitt: " + additionAllNumbers / 5.0);

        int[] numbers = {86, 91, 79, 93, 89};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            System.out.printf("Punkte %d: %d\n", i, numbers[i]);
        }

        System.out.println("Durchschnitt: " + (float)sum / (float)numbers.length);

    }
}
