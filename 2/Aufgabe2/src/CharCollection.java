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

        if (this.Chars.isEmpty()){
            return 0;
        }

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
        sb.append("(");

        for (char c : Chars){
            sb.append(c);
            sb.append(", ");
        }

        if (sb.length() > 1)
            sb.delete(sb.length()-2, sb.length());

        sb.append(")");

        return sb.toString();
    }

    public CharCollection moreThan(int m){
        ArrayList<Character> checked = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : Chars){
            if (checked.contains(c))
            {
                if (sb.toString().indexOf(c) != -1){
                    sb.append(c);
                }
                continue;
            }

            int count = count(c);
            checked.add(c);

            if (count > m){
                sb.append(c);
            }
        }

        return new CharCollection(sb.toString());
    }

    public boolean equals(Object x){
        if (x == null){
            return false;
        }

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
            Object[] listX = getObjectAsCollection(x);
            if (listX == null || listX.length != this.size()){
                return false;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < listX.length; i++){
                if (listX[i] instanceof Character){
                    sb.append((Character) listX[i]);
                }
                else {
                    return false;
                }
            }

            CharCollection c = new CharCollection(sb.toString());
            return equals(c);
        }

        return false;
    }

    private Object[] getObjectAsCollection(Object x){
        if (x instanceof List<?> formed){
            return formed.toArray();
        }
        else if (x instanceof Map<?,?> formed){
            return formed.values().toArray();
        }
        else if (x instanceof Collection<?> formed){
            return formed.toArray();
        }

        return  null;
    }

    public CharCollection except(CharCollection cc){
        CharCollection newC = this.clone();

        for (char c : cc.Chars){
            if (newC.Chars.contains(c))
                newC.Chars.remove(newC.Chars.indexOf(c));
        }

        return newC;
    }

    public boolean isSubset(CharCollection cc){
        CharCollection copyThis = this.clone();

        for (char c : cc.Chars){
            if (copyThis.Chars.contains(c))
                copyThis.Chars.remove(copyThis.Chars.indexOf(c));
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
