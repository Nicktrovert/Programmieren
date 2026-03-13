public class Recursive {

    public static void main(String[] args){
        greet();
        testFactorial();
        testSum();
        testFibonacci();
        testPalindrome();
        testPower();
        testReverse();
        testGCD();
    }

    // tests
    public static void greet(){
        drawDivider();
        System.out.println("Recursive Practice!");
        drawDivider();
    }
    public static void testFactorial(){
        drawDivider();
        System.out.println("Factorial: ");
        System.out.println("\tn = 5  :  " + factorial(5));
        System.out.println("\tn = 15  :  " + factorial(15));
        System.out.println("\tn = 1  :  " + factorial(1));
        System.out.println("\tn = -5  :  " + factorial(-5));
        drawDivider();
    }
    public static void testSum(){
        drawDivider();
        System.out.println("Sum: ");
        System.out.println("\tn = 5  :  " + sum(5));
        System.out.println("\tn = 15  :  " + sum(15));
        System.out.println("\tn = 1  :  " + sum(1));
        System.out.println("\tn = -5  :  " + sum(-5));
        drawDivider();
    }
    public static void testFibonacci(){
        drawDivider();
        System.out.println("Fibonacci: ");
        System.out.println("\tn = 5  :  " + fibonacci(5));
        System.out.println("\tn = 15  :  " + fibonacci(15));
        System.out.println("\tn = 1  :  " + fibonacci(1));
        System.out.println("\tn = -5  :  " + fibonacci(-5));
        drawDivider();
    }
    public static void testPalindrome(){
        drawDivider();
        System.out.println("Palindrome: ");
        System.out.println("\ts = \"Apple\" :  " + palindrome("Apple"));
        System.out.println("\ts =  \"racecar\":  " + palindrome("racecar"));
        System.out.println("\ts =  \"Vinegar\":  " + palindrome("Vinegar"));
        System.out.println("\ts =  \"cappac\":  " + palindrome("cappac"));
        drawDivider();
    }
    public static void testPower(){
        drawDivider();
        System.out.println("Power: n^k");
        System.out.println("\tn = 5; k = 5 :  " + power(5, 5));
        System.out.println("\tn = 3; k = 10  :  " + power(3, 10));
        System.out.println("\tn = 9; k = 0  :  " + power(9, 0));
        System.out.println("\tn = -5; k = 3  :  " + power(-5, 3));
        System.out.println("\tn = -5; k = 4  :  " + power(-5, 4));
        drawDivider();
    }
    public static void testReverse(){
        drawDivider();
        System.out.println("String reversal: ");
        System.out.println("\ts = \"Apple\" :  " + reverse("Apple"));
        System.out.println("\ts =  \"racecar\":  " + reverse("racecar"));
        System.out.println("\ts =  \"Vinegar\":  " + reverse("Vinegar"));
        System.out.println("\ts =  \"cappac\":  " + reverse("cappac"));
        drawDivider();
    }
    public static void testGCD(){
        drawDivider();
        System.out.println("GCD: n,k");
        System.out.println("\tn = 5; k = 5 :  " + GCD(5, 5));
        System.out.println("\tn = 83; k = 27 :  " + GCD(83, 27));
        System.out.println("\tn = 50283; k = 5829 :  " + GCD(50283, 5829));
        System.out.println("\tn = 25982; k = 83902 :  " + GCD(25982, 83902));
        System.out.println("\tn = 500; k = 450 :  " + GCD(500, 450));
        drawDivider();
    }
    public static void drawDivider(){
        System.out.print("---------------------------------\n");
    }

    // functions
    public static long factorial(long n){
        if (n <= 0) return -1;

        if (n == 1) return 1;
        return n * factorial(n-1);
    }
    public static long sum(long n){
        if (n <= 0) return -1;

        if (n == 1) return 1;
        return n + sum(n-1);
    }
    public static long fibonacci(long n) {
        if (n <= 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static boolean palindrome(String s){
        if (s.length() <= 1) return true;

        char[] arr = s.toLowerCase().toCharArray();

        if (arr[0] == arr[arr.length - 1]){
            StringBuilder ns = new StringBuilder();
            for (int i = 1; i < arr.length - 1; i++){
                ns.append(arr[i]);
            }
            return palindrome(ns.toString());
        }

        return false;
    }
    public static long power(long n, long k){
        if (k == 0) return 1;

        return n * power(n, k-1);
    }
    public static String reverse(String s){
        char[] arr = s.toCharArray();

        if (s.length() <= 1) return s;

        return arr[arr.length - 1] + reverse(s.substring(0, s.length()-1));
    }
    public static long GCD(long a, long b){
        if (a == 0) return b;
        if (b == 0) return a;

        return GCD(b, a % b);
    }

}
