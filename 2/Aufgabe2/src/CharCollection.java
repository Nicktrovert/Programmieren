import java.util.ArrayList;

public class CharCollection {
    public ArrayList<Character> Chars;

    public CharCollection(char... cc){
        Chars = new ArrayList<>();
        for (char c : cc){
            Chars.add(c);
        }
    }

    public CharCollection(String cc){
        this.Chars = new CharCollection(cc.toCharArray()).Chars;
    }

    public int size(){
        return Chars.size();
    }

    public int count(char c){
        int amount = 0;

        for (char i : Chars){
            if (i == c){
                amount++;
            }
        }

        return amount;
    }

    public int different(){
        ArrayList<Character> seen = new ArrayList<>();
        int counter = 0;

        for (char c : Chars){
            if (seen.contains(c)) {continue;}

            seen.add(c);
            counter++;
        }

        return counter;
    }

    public char top(){
        ArrayList<Character> checked = new ArrayList<>();
        char most = '0';
        int most_count = 0;

        for (char c : Chars){
            if (checked.contains(c)) {continue;}

            int count = count(c);
            checked.add(c);

            if (count > most_count){
                most = c;
                most_count = count;
            }
        }

        return most;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (char c : Chars){
            sb.append(c);
            sb.append(", ");
        }

        sb.delete(sb.length()-2, sb.length());

        return sb.toString();
    }

    // todo
}
