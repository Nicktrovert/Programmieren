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
        BlackjackGame b = new BlackjackGame();
        b.playRound();
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

    public void initRound(){
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        fullDeck = initDeck();
        for (int i = 0; i < 2; i++){
            PlayerDraw();
            PrintPlayerHand();
            DealerDraw();
            PrintDealerHand(true);
        }
    }

    public String CardArrayToString(ArrayList<Card> cards){
        return CardArrayToString(cards, false);
    }

    public String CardArrayToString(ArrayList<Card> cards, boolean firstCardHidden){
        StringBuilder out = new StringBuilder();
        for (Card card : cards){
            if (firstCardHidden){
                out.append("[?]").append("\n");
                firstCardHidden = false;
            }
            else{
                out.append(card.toString()).append("\n");
            }
        }
        return out.toString();
    }

    public void PrintPlayerHand(){
        System.out.printf("Player Hand: \n%s\n", CardArrayToString(playerHand));
    }

    public void PrintDealerHand(boolean hideFirstCard){
        System.out.printf("Dealer Hand: \n%s\n", CardArrayToString(dealerHand, hideFirstCard));
    }

    public Card PlayerDraw(){
        Card card = GetTopCardFromDeck();
        playerHand.addFirst(card);
        System.out.println("Player drew a Card!");
        return card;
    }

    public Card DealerDraw(){
        Card card = GetTopCardFromDeck();
        dealerHand.addFirst(card);
        System.out.println("Dealer drew a Card!");
        return card;
    }

    public ArrayList<Card> GetCardsFromDeck(int amount){
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < amount; i++){
            cards.addFirst(GetTopCardFromDeck());
        }

        return cards;
    }

    public Card GetTopCardFromDeck(){
        return fullDeck.removeLast();
    }

    public int PlayerTurn() {
        System.out.printf("Player Turn: \nCurrent Hand: \n%s\n\tWhat do you want to do?\n\t\t(1) Hit  [Draw another card]\n\t\t(2) Stand  [Stop turn]\n\n", CardArrayToString(playerHand));
        String input = readFromConsole("Your choice: ");

        if (input.equals("1")){
            PlayerDraw();
            PrintPlayerHand();
            return CheckPlayerState();
        }
        else if (input.equals("2")){
            System.out.println("Player standing!");
            return -1;
        }
        else {
            System.out.println("\nInvalid choice. Try again.\n");
        }

        return 0;
    }

    public int CardsTotalSum(ArrayList<Card> cards) {
        int sum = 0;
        for (Card card : cards){
            sum += card.getValue();
        }
        return sum;
    }

    public int CheckPlayerState(){
        int value = CardsTotalSum(playerHand);
        if (value == 21){
            System.out.println("Player reached max Value, Dealers turn.");
            return -1;
        }
        if (value > 21){
            System.out.println("Player busted!");
            return 1;
        }
        return 0;
    }

    public int DealerTurn(){
        System.out.printf("Dealer Turn: \nCurrent Hand: \n%s\n", CardArrayToString(dealerHand, false));

        int totalSum = CardsTotalSum(dealerHand);
        if (totalSum < 17){
            DealerDraw();
            PrintDealerHand(false);
            return CheckDealerState();
        }
        else {
            System.out.println("Dealer Standing.");
            return -1;
        }
    }

    public int CheckDealerState(){
        int value = CardsTotalSum(dealerHand);
        if (value == 21){
            System.out.println("Dealer reached max Value.");
            return -1;
        }
        if (value > 21){
            System.out.println("Dealer busted!");
            return 1;
        }
        return 0;
    }

    public void GetGameResult(){
        int playerSum = CardsTotalSum(playerHand);
        int dealerSum = CardsTotalSum(dealerHand);
        if (playerSum > 21){
            System.out.println("Dealer Won! Player busted.");
        }
        else if (dealerSum > 21){
            System.out.println("Player Won! Dealer busted.");
        }
        else if (playerSum == dealerSum){
            System.out.println("Dealer Won! Draw.");
        }
        else if (playerSum > dealerSum){
            System.out.println("Player Won!");
        }
        else {
            System.out.println("Dealer Won!");
        }
    }

    public void playRound(){
        initRound();
        int RoundStep = 0;
        while (RoundStep < 3){
            switch (RoundStep) {
                case 0:
                    int i = PlayerTurn();
                    if (i == -1){
                        RoundStep++;
                    }
                    if (i == 1){
                        RoundStep = 2;
                    }
                    break;
                case 1:
                    int j = DealerTurn();
                    if (j != 0){
                        RoundStep++;
                    }
                    break;
                case 2:
                    GetGameResult();
                    RoundStep++;
                    break;
            }
        }
    }
}
