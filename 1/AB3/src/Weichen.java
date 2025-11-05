
public class Weichen {

	public static int start = 1000;
	public static int ende = 0;
	
	public static void main(String[] args) {
		if (start <= ende) {
			System.out.println("ERROR: ende ist groesser als start");
		}
		
		for (int i = start; i >= ende; i--) {
			 System.out.printf("%d ist %s\n", i, Eveness(i));
		}
		
		System.out.println("fertig");

	}
	
	public static String Eveness(int i) {
		if (i % 2 == 0) {
			return "gerade";
		}
		else {
			return "ungerade";
		}
	}

}
