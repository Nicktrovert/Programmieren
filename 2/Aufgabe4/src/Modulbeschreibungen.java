import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Modulbeschreibungen {
    List<Modul> modules = new ArrayList<>();

    public static void main(String[] args) throws IOException, ScriptException, IllegalAccessException {
        Modulbeschreibungen modB = new Modulbeschreibungen("2/Aufgabe4/src/textFile.txt");
        System.out.println(modB.getJSON("studiengang"));
    }

    public Modulbeschreibungen(String filename) throws IOException {
        List<List<String>> data = loadFile(filename);

        for (int i = 0; i < data.size(); i++){
            List<List<String>> moduleData = new ArrayList<>();
            while ((!data.get(i).isEmpty() || !data.get(i).get(0).isEmpty()) && i < data.size()-1){
                moduleData.add(data.get(i));
                i++;
            }

            Modul a = new Modul(moduleData);

            modules.add(a);
        }
    }

    public static List<List<String>> loadFile(String filename) throws IOException {
        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (!line.isEmpty() && line.charAt(0) == '#'){
                continue;
            }
            result.add(Arrays.asList(line.split("|")));
        }
        br.close();
        return result;
    }

    public Set<String> getZertifikate(String studiengang){
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);
        Set<String> certificates = new HashSet<>();

        for (int i = 0; i < modulesOfCourse.size(); i++){
            String Art = modulesOfCourse.get(i).getArt();
            Art = Art.replace(",", " ,");
            if (Art.contains("Zertifikat")){
                String[] artParts = Art.split(" ");
                boolean readingCertificateName = false;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < artParts.length; j++){
                    if (!readingCertificateName){
                        if (artParts[j].equals("Zertifikat")){
                            readingCertificateName = true;
                            sb = new StringBuilder();
                        }
                    }
                    else {
                        if (artParts[j].equals("und") || artParts[j].equals(",")){
                            readingCertificateName = false;
                            certificates.add(sb.toString());
                        }
                        else {
                            sb.append(artParts[j]).append(" ");
                        }
                    }
                }
            }
        }

        return certificates;
    }

    Map<Integer, Integer> getECTS(String studiengang){
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);
        Map<Integer, Integer> ECTS = new HashMap<>();

        for (Modul m : modulesOfCourse){
            if (m.getArt().contains("Pflichtmodul")){
                int semester = m.getSemester();
                int moduleECTS = (int) Math.round(m.getECTS());
                if (!ECTS.containsKey(semester)){
                    ECTS.put(semester, moduleECTS);
                }
                else{
                    int prevValue = ECTS.get(semester);
                    ECTS.replace(semester, moduleECTS + prevValue);
                }
            }
        }

        return ECTS;
    }

    Map<Integer, Integer> getSWS(String studiengang){
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);
        Map<Integer, Integer> SWS = new HashMap<>();

        for (Modul m : modulesOfCourse){
            if (m.getArt().contains("Pflichtmodul")){
                int semester = m.getSemester();
                double moduleSWS = 0;

                for (Veranstaltung v : m.getVeranstaltungen()){
                    moduleSWS += v.getSws();
                }

                if (!SWS.containsKey(semester)){
                    SWS.put(semester, (int) moduleSWS);
                }
                else{
                    int prevValue = SWS.get(semester);
                    SWS.replace(semester, ((int) moduleSWS) + prevValue);
                }
            }
        }

        return SWS;
    }
    public Set<String> getVerzahnteModule() {
        Set<String> verzahnte = new TreeSet<>();
        Map<String, List<Modul>> map = new HashMap<>();

        for (Modul m : modules) {
            String key = m.getBezeichnung() + "|" + m.getVerantwortlicher() + "|" + getKuerzelBasis(m.getKuerzel());

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(m);
        }

        for (List<Modul> group : map.values()) {
            if (group.size() > 1) {
                Set<String> studiengaenge = new HashSet<>();
                for (Modul m : group) {
                    studiengaenge.add(m.getStudiengang());
                }
                if (studiengaenge.size() > 1) {
                    verzahnte.add(group.get(0).getBezeichnung());
                }
            }
        }
        return verzahnte;
    }

    private String getKuerzelBasis(String kuerzel) {
        if (kuerzel == null || kuerzel.isEmpty()) return "";
        int index = kuerzel.indexOf('-');
        if (index == -1) return kuerzel;
        return kuerzel.substring(0, index);
    }

    public int getAnzahlModule(String studiengang, Boolean pflicht) {
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);
        int count = 0;

        for (Modul m : modulesOfCourse) {
            if (pflicht == null) {
                count++;
            } else if (pflicht && m.getArt() != null && m.getArt().contains("Pflichtmodul")) {
                count++;
            } else if (!pflicht && m.getArt() != null && m.getArt().contains("WPM")) {
                count++;
            }
        }
        return count;
    }

    public int getAnzahlVeranstaltungen(String studiengang, Boolean pflicht){
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);
        int count = 0;

        for (Modul m : modulesOfCourse) {
            boolean match = false;
            if (pflicht == null) {
                match = true;
            } else if (pflicht && m.getArt() != null && m.getArt().contains("Pflichtmodul")) {
                match = true;
            } else if (!pflicht && m.getArt() != null && m.getArt().contains("WPM")) {
                match = true;
            }

            if (match) {
                if (m.getVeranstaltungen() != null) {
                    count += m.getVeranstaltungen().size();
                }
            }
        }
        return count;
    }

    public List<String> getSortierteStudiengaenge(){
        Map<String, Integer> swsByCourse = new HashMap<>();
        Set<String> allCourses = new HashSet<>();

        for (Modul m : modules) {
            allCourses.add(m.getStudiengang());
        }

        for (String course : allCourses) {
            int totalSWS = 0;
            List<Modul> courseModules = ModulesGetters.getByCourse(modules, course);
            for (Modul m : courseModules) {
                if (m.getVeranstaltungen() != null) {
                    for (Veranstaltung v : m.getVeranstaltungen()) {
                        totalSWS += v.getSws();
                    }
                }
            }
            swsByCourse.put(course, totalSWS);
        }

        List<String> sortedCourses = new ArrayList<>(allCourses);
        sortedCourses.sort((c1, c2) -> {
            int s1 = swsByCourse.get(c1);
            int s2 = swsByCourse.get(c2);
            if (s1 != s2) {
                return Integer.compare(s1, s2);
            }
            return c1.compareTo(c2);
        });

        return sortedCourses;
    }

    public String getJSON(String studiengang) {
        List<Modul> chosenModules = ModulesGetters.getByCourse(modules, studiengang);
        return Jsonizer.jsonizeList(chosenModules);
    }
}
