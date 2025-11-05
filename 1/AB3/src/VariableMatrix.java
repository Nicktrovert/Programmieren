
public class VariableMatrix {

	public static int xStart = 1;
	public static int xEnde = 5;
	public static int yStart = 10;
	public static int yEnde = 15;
	public static int modus = 1;
	
	public static void main(String[] args) {
		for (int y = yStart; y <= yEnde; y++) {
			for (int x = xStart; x <= xEnde; x++) {
				switch (modus) {
				case 1:
					System.out.printf("%d+%d=%d\t", y, x, y+x);
					break;
				case 2:
					System.out.printf("%d-%d=%d\t", y, x, y-x);
					break;
				case 3:
					System.out.printf("%d*%d=%d\t", y, x, y*x);
					break;
				case 4:
					System.out.printf("%d/%d=%d\t", y, x, y/x);
					break;
				}
			}
			System.out.println();
		}
	}

}
