import java.util.ArrayList;

public interface IValueList {
    void addValues(int start, int stop);
    void removeValues(int threshold);
    void shoveInto(int index, int item);
    int getCurrentSize();
    int getIndexItem(int index);
    boolean valueContained(int val);
    void printList();
    ArrayList<Integer> getList();
}