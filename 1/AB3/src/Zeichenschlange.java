public class Zeichenschlange {
	public static void main(String[] args) {
		int Start = 'A';
		int end = 'z';
		String schlange = "";
		
		for (int i = Start; i <= end; i++) {
			schlange += (char)i;
		}
		
		System.out.println(schlange);
	}
}
