public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank(){
        return rank;
    }

    public int getValue(){
        return rank.getValue();
    }

    public String toString(){
        return String.format("%s%s", rank.getLabel(), suit.getSymbol());
    }
}
