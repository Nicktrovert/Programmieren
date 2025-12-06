public class Kunde {
    Artikel[] warenkorb;

    public Kunde(){
        warenkorb = new Artikel[5];
    }

    public void nehmen(Artikel a){
        for (int i = 0; i < warenkorb.length; i++) {
            if (warenkorb[i] == null){
                warenkorb[i] = a;
                break;
            }
        }
    }

    public double zurKasseGehen(){
        double totalSum = 0;
        for (Artikel artikel : warenkorb) {
            if (artikel != null) {
                totalSum += artikel.getPreis();
            }
        }
        return totalSum;
    }

    public Artikel[] getWarenkorb() {
        return warenkorb;
    }
}
