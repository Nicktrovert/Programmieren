public class Stehlampe {
    public static boolean istAn;
    public static int helligkeit;

    public static void main(String[] args){
        Stehlampe.einschalten();
        Stehlampe.ausschalten();
        Stehlampe.setzeHelligkeit(50);
        Stehlampe.einschalten();
        Stehlampe.setzeHelligkeit(101);
        Stehlampe.setzeHelligkeit(50);
    }

    public static void einschalten(){
        istAn = true;
        System.out.println("Die Lampe ist jetzt an.");
    }

    public static void ausschalten(){
        istAn = false;
        System.out.println("Die Lampe ist jetzt aus.");
    }

    public static void setzeHelligkeit(int neueHelligkeit){
        if (!istAn){
            System.out.println("Die Lampe ist aus.");
            return;
        }

        if (1 <= neueHelligkeit && neueHelligkeit <= 100){
            helligkeit = neueHelligkeit;
            System.out.printf("Die Helligkeit wurde auf %d%% gesetzt.", helligkeit);
        }
        else {
            if (neueHelligkeit > 100){
                System.out.println("Das ist zu hell!");
            }
            else{
                System.out.println("Das ist zu dunkel!");
            }
        }
    }

}
