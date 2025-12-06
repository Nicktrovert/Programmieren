import java.util.Arrays;

public class ITLaden {
    public Artikel[] lager;
    public String name;
    public Kunde kunde;

    public static void main(String[] args){

    }

    public ITLaden(String name, Artikel[] inventory){
        this.name = name;
        this.lager = inventory;
    }

    public void alleBeschreiben(){
        for (Artikel artikel : lager){
            if (artikel != null){
                System.out.println(artikel.preisschild());
            }
        }
    }

    public void superSale(){
        for (Artikel artikel : lager){
            if (artikel != null){
                String out = artikel.preisschild();
                if (out.contains("on sale")){
                    System.out.println(out);
                }
            }
        }
    }

    public void preiseReduzieren(double prozent, int... artikelnummern){
        for (Artikel artikel : lager){
            if (Arrays.stream(artikelnummern).anyMatch(x -> x == artikel.artikelTyp)){
                artikel.setOnSale(prozent);
            }
        }
    }

    public void preiseReduzieren(double prozent, int rangeStart, int rangeEnd){
        for (Artikel artikel : lager){
            if (artikel != null){
                if (rangeStart < artikel.artikelTyp && artikel.artikelTyp < rangeEnd){
                    artikel.setOnSale(prozent);
                }
            }
        }
    }

    public Artikel kundenanfrage(String name){
        for (Artikel artikel : lager){
            if (artikel != null){
                if (artikel.preisschild().contains(name)){
                    return artikel;
                }
            }
        }
        return null;
    }

    public void betrittDenLaden(Kunde k){
        if (kunde == null){
            kunde = k;
        }
    }

    public void willGegenstand(String name){
        if (kunde != null){
            Artikel ret = kundenanfrage(name);
            if (ret != null){
                kunde.nehmen(ret);
            }
        }
    }

    public void willBezahlen(){
        if (kunde != null){
            System.out.println(kunde.zurKasseGehen());
        }
    }

    public Artikel[] getLager(){
        return lager;
    }

    public Kunde getKunde(){
        return kunde;
    }
}
