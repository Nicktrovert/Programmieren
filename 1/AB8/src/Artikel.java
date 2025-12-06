public class Artikel {
    public String name;
    public String hersteller;
    public int artikelTyp;
    public double preis;
    public boolean onSale;

    public Artikel(String name, String hersteller, int artikelTyp, double preis){
        this.name = name;
        this.hersteller = hersteller;
        this.artikelTyp = artikelTyp;
        this.preis = preis;
    }

    public void setPreis(double neuerPreis){
        if (neuerPreis > 0){
            this.preis = neuerPreis;
            onSale = false;
        }
    }

    public void setOnSale(double prozentRunter){
        preis = preis - (preis * prozentRunter);
        onSale = true;
    }

    public boolean getSaleStatus(){
        return onSale;
    }

    public double getPreis(){
        return preis;
    }

    public int getArtikelTyp(){
        return artikelTyp;
    }

    public String preisschild(){
        return String.format("Produkt%s:\n\thersteller: %s\n\tname: %s\n\tpreis: " + preis, onSale ? " (on sale)" : "", hersteller, name);
    }
}
