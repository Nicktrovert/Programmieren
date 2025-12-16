import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BlackjackGame {
    private ArrayList<Card> fullDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private BufferedReader br;

    public static void main(String[] args){

    }

    public BlackjackGame() {
        initReader();
    }

    private void initReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String readFromConsole(String prompt) {
        String out = null;

        try {
            System.out.print(prompt + "\t");
            out = br.readLine();
        } catch (IOException e) {
            System.err.println("Wow! Look at that! We couldn't read from console.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Wow! Look at that! We had no BufferedReader instantiated!");
            e.printStackTrace();
        }
        return out;
    }

    private ArrayList<Card> initDeck(){
        ArrayList<Card> deck = new ArrayList<Card>();

        for (Suit s : Suit.values()){
            for (Rank r : Rank.values()){
                deck.add(new Card(s, r));
            }
        }

        Collections.shuffle(deck);
        return deck;
    }

    public void playRound(){

    }
}
