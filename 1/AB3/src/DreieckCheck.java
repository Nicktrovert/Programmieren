public class DreieckCheck {
	public static void main(String[] args) {
		int a = 4;
		int b = 5;
		int c = 6;
		
		if (a + b < c || b + c < a || c + a < b) {
			System.out.println("ungueltiges dreieck");
		}
		else if (a == b && b == c) {
			System.out.println("gleichseitiges dreieck");
		}
		else if (a == b || b == c || c == a) {
			System.out.println("gleichschenkliges dreieck");
		}
		else {
			System.out.println("ungleichseitiges dreieck");
		}
	}
}
