
public class GrossesEinmalEins {
	public static void main(String[] args) {
		for (int i = 10; i <= 100; i++) {
			for (int j = 10; j <= 100; j++) {
				System.out.printf("%d*%d=%d\t", i, j, i*j);
			}
			System.out.println();
		}
	}
}
