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
                moduleData.add(data.get(0));
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
        return null;
    }

    public int getAnzahlModule(String studiengang, Boolean pflicht) {
        return 0;
    }

    public int getAnzahlVeranstaltungen(String studiengang, Boolean pflicht){
        return 0;
    }

    public List<String> getSortierteStudiengaenge(){
        return null;
    }

    public String getJSON(String studiengang) {
        List<Modul> chosenModules = ModulesGetters.getByCourse(modules, studiengang);
        return Jsonizer.jsonizeList(chosenModules);
    }
}
