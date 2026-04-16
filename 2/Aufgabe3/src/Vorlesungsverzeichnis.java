import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Vorlesungsverzeichnis {
    private Set<Vorlesung> vorlesungen;

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public static void main(String[] args){
        try{
            Vorlesungsverzeichnis v = new Vorlesungsverzeichnis("2/Aufgabe3/src/testfile.txt");
            System.out.println("\n\n~~Titles: ~~");
            System.out.println(Arrays.toString(v.titles().toArray()));
            System.out.println("\n\n~~Workaholics: ~~");
            System.out.println(Arrays.toString(v.workaholics().toArray()));
            System.out.println("\n\n~~groupToTitles: ~~");
            System.out.println(Arrays.toString(v.groupToTitles().keySet().toArray()));
            System.out.println(Arrays.toString(v.groupToTitles().values().toArray()));
            System.out.println("\n\n~~multipleTitles: ~~");
            System.out.println(Arrays.toString(v.multipleTitles().keySet().toArray()));
            System.out.println(Arrays.toString(v.multipleTitles().values().toArray()));
            System.out.println("\n\n~~descending titles: ~~");
            System.out.println(Arrays.toString(v.descendingTitles().toArray()));
        }
        catch(Exception e){
            System.out.println("Fehler");
        }
    }

    public static List<List<String>> load(String filename) throws IOException {
        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line = br.readLine(); line != null; line = br.readLine())
            result.add(Arrays.asList(line.split(":")));
        br.close();
        return result;
    }

    public Vorlesungsverzeichnis(String filename) throws IOException {
        this.vorlesungen = new HashSet<>();

        List<List<String>> rawData = load(filename);

        for (List<String> row : rawData) {
            vorlesungen.add(new Vorlesung(row.get(0), row.get(1), row.get(2), Integer.parseInt(row.get(3))));
        }
    }

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public List<String> titles() {
        List<String> titles = new ArrayList<>();

        vorlesungen.forEach(vorlesung -> {
            titles.add(vorlesung.getTitel());
        });

        Collections.sort(titles);

        return titles;
    }

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public Set<String> workaholics() {
        Set<String> workaholics = new HashSet<>();
        List<String> seen = new ArrayList<>();

        vorlesungen.forEach(vorlesung ->
        {
            String dozent = vorlesung.getDozent();

            if (!seen.contains(dozent))
            {
                seen.add(dozent);
            }
            else {
                workaholics.add(dozent);
            }
        }
        );

        return workaholics;
    }

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public Map<String, List<String>> groupToTitles() {
        Map<String, List<String>> groupToTitles = new HashMap<>();

        vorlesungen.forEach(vorlesung -> {
            String studyGroup = vorlesung.getStudiengruppe();
            String title = vorlesung.getTitel();

            if (!groupToTitles.containsKey(studyGroup)) {
                groupToTitles.put(studyGroup, new ArrayList<>());
                groupToTitles.get(studyGroup).add(title);
            }
            else{
                groupToTitles.get(studyGroup).add(title);
            }
        });

        return groupToTitles;
    }

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public Map<String, List<String>> multipleTitles() {
        Map<String, List<String>> multipleTitles = new HashMap<>();

        vorlesungen.forEach(vorlesung -> {
            String title = vorlesung.getTitel();
            String dozent = vorlesung.getDozent();

            if (!multipleTitles.containsKey(title)) {
                multipleTitles.put(title, new ArrayList<>());
                multipleTitles.get(title).add(dozent);
            }
            else{
                multipleTitles.get(title).add(dozent);
            }
        });

        return multipleTitles;
    }

    /** File Example
     * -
     * <p>I2:Java 2:Rump:100</p>
     * <p>I2:Algorithmen und Datenstrukturen:Streekmann:80</p>
     * <p>MT2:Mathematik 2:von Coelln:60</p>
     * <p>MT2:Audio-/Videotechnik:Lemke:50</p>
     * <p>E2:Mathematik 2:Rabe:70</p>
     *
     **/

    public List<String> descendingTitles() {
        List<String> descendingTitles = new ArrayList<>();
        List<Integer> descendingTitlesParticipants = new ArrayList<>();

        vorlesungen.forEach(vorlesung -> {
            String title = vorlesung.getTitel();
            int participants = vorlesung.getTeilnehmerzahl();

            boolean positionCheckInserted = false;

            for (int i = 0; i < descendingTitlesParticipants.size() && !positionCheckInserted; i++) {
                if (participants > descendingTitlesParticipants.get(i))
                {
                    descendingTitles.add(i, title);
                    descendingTitlesParticipants.add(i, participants);
                    positionCheckInserted = true;
                }
            }

            if (!positionCheckInserted) {
                descendingTitles.add(title);
                descendingTitlesParticipants.add(participants);
            }
        });

        return descendingTitles;
    }
}