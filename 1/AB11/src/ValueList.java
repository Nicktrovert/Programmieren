import java.util.ArrayList;

public class ValueList implements IValueList{
    ArrayList<Integer> list;

    public static void main(String[] args){

    }

    public ValueList(){
        list = new ArrayList<Integer>();
    }

    @Override
    public void addValues(int start, int stop) {
        for(int i = start; i<=stop; i++){
            list.add(i);
        }
    }

    @Override
    public void removeValues(int threshold) {
        list.removeIf(x -> x < threshold);
    }

    @Override
    public void shoveInto(int index, int item) {
        list.set(index, item);
    }

    @Override
    public int getCurrentSize() {
        return list.size();
    }

    @Override
    public int getIndexItem(int index) {
        return list.get(index);
    }

    @Override
    public boolean valueContained(int val) {
        return list.contains(val);
    }

    @Override
    public void printList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " | " + list.get(i) + "\n");
        }
    }

    @Override
    public ArrayList<Integer> getList() {
        return list;
    }
}
