import java.util.Arrays;

public class NamePicker {
    public static String[] names = { "Anna", "Ben", "Clara", "Dieter",
            "Eva", "Felix", "Gabi", "Hannah", "Ingo", "Julia", "Karl", "Lena", "Mia",
            "Nils", "Olga", "Paul", "Quentin", "Rita", "Stefan", "Tina", "Uwe", "Vera",
            "Walter", "Xenia", "Yvonne", "Zacharias", "Alina", "Boris", "Celine",
            "Daniel", "Elena", "Florian", "Greta", "Heinrich", "Isabel", "Jonas",
            "Katja", "Leon", "Maria", "Niklas", "Oskar", "Petra", "Renate", "Sebastian",
            "Thomas", "Ulrich", "Vanessa", "Wolfgang", "Yasmin", "Zoe" };
    public static String[] starts = { "A", "B", "T", "S" };
    public static String[] pickedAndSorted;


    public static void main(String[] args) {
        pickedAndSorted = new String[0];
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (names[i].startsWith(starts[j])) {
                    pickedAndSorted = Arrays.copyOf(pickedAndSorted,  pickedAndSorted.length + 1);;
                    pickedAndSorted[pickedAndSorted.length - 1] = names[i];
                }
            }
        }

        Arrays.sort(pickedAndSorted);

        for (String name : pickedAndSorted) {
            System.out.println(name);
        }
    }
}
