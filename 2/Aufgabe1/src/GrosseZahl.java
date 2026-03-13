import java.util.Arrays;

public class GrosseZahl {
    int[] _data;
    public static GrosseZahl ONE = new GrosseZahl(1);

    public GrosseZahl(String d){
        _data = new int[d.length()];

        for (int i = 0; i < d.length(); i++){
            _data[i] = d.charAt(i) - '0';
        }
    }

    public GrosseZahl(int d){
        new GrosseZahl(Integer.toString(d));
    }

    public static void main(String[] args){
        GrosseZahl test = new GrosseZahl("8295938");
        GrosseZahl test2 = new GrosseZahl("258");

        //Constructor test (Works)
        System.out.println(Arrays.toString(test._data));
        System.out.println(Arrays.toString(test2._data));
        //toString() test (Works) [requires Constructor to function]
        System.out.println(test.toString());
        System.out.println(test2.toString());
        //ggT test (can't test yet) [requires toString() to function]
        //System.out.println(ggT(test, test2).toString());
        //todo : other tests
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _data.length; i++){
            sb.append(_data[i]);
        }
        return sb.toString();
    }

    public boolean less(GrosseZahl b){ //todo (gerrit)
        // todo : implement

        return false;
    }

    public GrosseZahl add(GrosseZahl b){ //todo (gerrit)
        // todo : implement

        return null;
    }

    public GrosseZahl sub(GrosseZahl b){ //todo (gerrit)
        // todo : implement
        return null;
    }

    public GrosseZahl mult(GrosseZahl b) throws CloneNotSupportedException {
        GrosseZahl self = (GrosseZahl) this.clone();

        while(!b.less(GrosseZahl.ONE)){
            b.sub(GrosseZahl.ONE);
            self.add(this);
        }

        return self;
    }

    public GrosseZahl ggT(GrosseZahl b) throws CloneNotSupportedException {
        GrosseZahl a = (GrosseZahl) this.clone();

        return ggT_recursive(a, b);
    }

    private GrosseZahl ggT_recursive(GrosseZahl a, GrosseZahl b) {
        GrosseZahl leftover = ggT_recursive_findLeftover(a, b);

        if (leftover.less(GrosseZahl.ONE)) {
            return b;
        }

        return ggT_recursive(b, leftover);
    }

    private GrosseZahl ggT_recursive_findLeftover(GrosseZahl a, GrosseZahl b) {
        a = a.sub(b);

        if (a.less(b)){
            return a;
        }

        return ggT_recursive_findLeftover(a, b);
    }
}
