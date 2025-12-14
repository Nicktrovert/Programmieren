public class Box implements Comparable<Box>{
    public int hoehe;
    public int breite;
    public int tiefe;

    public static void main(String[] args){

    }

    public Box(int hoehe, int breite, int tiefe){
        this.hoehe = hoehe;
        this.breite = breite;
        this.tiefe = tiefe;
    }

    @Override
    public String toString(){
        return String.format("Hoehe: %d, Breite: %d, Tiefe: %d, Volumen: %d", hoehe, breite, tiefe, hoehe * breite * tiefe);
    }

    @Override
    public int compareTo(Box o) {
        int volumeA = this.hoehe * this.breite * this.tiefe;
        int volumeB = o.hoehe * o.breite * o.tiefe;

        return Integer.compare(volumeA, volumeB);
    }
}
