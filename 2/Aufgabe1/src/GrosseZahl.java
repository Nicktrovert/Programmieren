public class GrosseZahl {
    int[] _data;

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

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _data.length; i++){
            sb.append(_data[i]);
        }
        return sb.toString();
    }

    public boolean less(GrosseZahl b){ //gerrit
        // todo : implement

        return false;
    }

    public GrosseZahl add(GrosseZahl b){ //gerrit
        // todo : implement

        return null;
    }

    public GrosseZahl sub(GrosseZahl b){ //gerrit
        // todo : implement
        return null;
    }

    public GrosseZahl mult(GrosseZahl b){ //nick
        // todo : implement

        return null;
    }

    public GrosseZahl ggT(GrosseZahl b) throws CloneNotSupportedException { //nick
        GrosseZahl a = (GrosseZahl) this.clone();

        return ggT_recursive(a, b);
    }

    private GrosseZahl ggT_recursive(GrosseZahl a, GrosseZahl b) {



        return null;
    }
}
