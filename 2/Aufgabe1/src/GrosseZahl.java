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
        this._data = new GrosseZahl(Integer.toString(d))._data;
    }

    private GrosseZahl(int[] digits) {
        _data = digits;
    }

    public static void main(String[] args) {
        GrosseZahl test = new GrosseZahl("8295938");
        GrosseZahl test2 = new GrosseZahl("258");

        //Constructor test (Works)
        System.out.println(Arrays.toString(test._data));
        System.out.println(Arrays.toString(test2._data));
        //toString() test (Works) [requires Constructor to function]
        System.out.println(test.toString());
        System.out.println(test2.toString());

        //reasign
        test = new GrosseZahl("20");
        test2 = new GrosseZahl("35");

        //mult test [requires add(), toString() to function]
        System.out.println(test.mult(test2).toString());

        //ggT test [requires toString(), less(), sub() to function]
        System.out.println(test.ggT(test2).toString());

        System.out.println("--- less() Tests ---");
        GrosseZahl small = new GrosseZahl("100");
        GrosseZahl large = new GrosseZahl("1000");
        GrosseZahl equal = new GrosseZahl("100");

        System.out.println("small.less(large): " + small.less(large) + " (erwartet: true)");
        System.out.println("large.less(small): " + large.less(small) + " (erwartet: false)");
        System.out.println("small.less(equal): " + small.less(equal) + " (erwartet: false)");
        System.out.println();

        System.out.println("--- add() Tests ---");
        GrosseZahl a = new GrosseZahl("123");
        GrosseZahl b = new GrosseZahl("456");
        GrosseZahl sum = a.add(b);
        System.out.println("123 + 456 = " + sum.toString() + " (erwartet: 579)");
        GrosseZahl big1 = new GrosseZahl("999");
        GrosseZahl big2 = new GrosseZahl("1");
        GrosseZahl bigSum = big1.add(big2);
        System.out.println("999 + 1 = " + bigSum.toString() + " (erwartet: 1000)");
        System.out.println();

        System.out.println("--- sub() Tests ---");
        GrosseZahl sub1 = new GrosseZahl("500");
        GrosseZahl sub2 = new GrosseZahl("123");
        GrosseZahl diff = sub1.sub(sub2);
        System.out.println("500 - 123 = " + diff.toString() + " (erwartet: 377)");
        GrosseZahl sub3 = new GrosseZahl("1000");
        GrosseZahl sub4 = new GrosseZahl("999");
        GrosseZahl diff2 = sub3.sub(sub4);
        System.out.println("1000 - 999 = " + diff2.toString() + " (erwartet: 1)");
        System.out.println();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _data.length; i++){
            sb.append(_data[i]);
        }
        return sb.toString();
    }

    public boolean less(GrosseZahl b){ //todo (gerrit)
        if (_data.length != b._data.length) {
            return _data.length < b._data.length;
        }
        for (int i = 0; i < _data.length; i++) {
            if (_data[i] != b._data[i]) {
                return _data[i] < b._data[i];
            }
        }
        return false;
    }

    public GrosseZahl add(GrosseZahl b){ //todo (gerrit)
        int lenA = _data.length;
        int lenB = b._data.length;
        int maxLen = Math.max(lenA, lenB);
        int[] result = new int[maxLen + 1];
        int carry = 0;
        for (int i = 0; i < maxLen || carry > 0; i++) {
            int sum = carry;
            if (i < lenA) sum += _data[lenA - 1 - i];
            if (i < lenB) sum += b._data[lenB - 1 - i];
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        int start = 0;
        while (start < result.length - 1 && result[start] == 0) {
            start++;
        }
        int[] trimmed = Arrays.copyOfRange(result, start, result.length);
        return new GrosseZahl(trimmed);
    }

    public GrosseZahl sub(GrosseZahl b){ //todo (gerrit)
        int lenA = _data.length;
        int lenB = b._data.length;
        int[] result = new int[lenA];
        int borrow = 0;
        for (int i = 0; i < lenA; i++) {
            int aDigit = _data[lenA - 1 - i];
            int bDigit = (i < lenB) ? b._data[lenB - 1 - i] : 0;
            int diff = aDigit - bDigit - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[lenA - 1 - i] = diff;
        }
        int start = 0;
        while (start < result.length - 1 && result[start] == 0) {
            start++;
        }
        int[] trimmed = Arrays.copyOfRange(result, start, result.length);
        return new GrosseZahl(trimmed);
    }

    public GrosseZahl mult(GrosseZahl b) {
        GrosseZahl self = new GrosseZahl(this._data);

        while(!b.less(GrosseZahl.ONE)){
            b = b.sub(GrosseZahl.ONE);
            self = self.add(this);
        }
        self = self.sub(this);

        return self;
    }

    public GrosseZahl ggT(GrosseZahl b) {
        GrosseZahl a = new GrosseZahl(this._data);

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
