import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    public boolean equals(Object x){
        if (this.getClass() == x.getClass()){
            CharCollection formedX = (CharCollection) x;

            if (formedX.size() != this.size()){
                return false;
            }

            if (formedX.isSubset(this) || this.isSubset(formedX)){
                return true;
            }
        }
        else {
            ArrayList<?> listX = getObjectAsCollection(x);
            if (listX.size() == this.size()){
                return false;
            }
        }
    }

    private ArrayList<?> getObjectAsCollection(Object x){
        if (x instanceof List<?> formed){
            return new ArrayList<>(formed);
        }
        else if (x instanceof Map<?,?> formed){

        }
        else if (x instanceof Collection<?> formed){

        }
    }

    public CharCollection except(CharCollection cc){
        CharCollection newC = this.clone();

        for (char c : cc.Chars){
            if (newC.Chars.contains(c))
                newC.Chars.remove(c);
        }

        return newC;
    }

    public boolean isSubset(CharCollection cc){
        CharCollection copyThis = this.clone();

        for (char c : cc.Chars){
            if (copyThis.Chars.contains(c))
                copyThis.Chars.remove(c);
            else
                return false;
        }

        return true;
    }

    public CharCollection clone() {
        CharCollection charCollection = null;
        try {
            charCollection = (CharCollection) super.clone();
        } catch (Exception e){
            charCollection = new CharCollection();
        }
        charCollection.Chars = (ArrayList<Character>) this.Chars.clone();
        return charCollection;
    }
}
