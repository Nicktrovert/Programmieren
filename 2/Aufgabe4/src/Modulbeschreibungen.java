import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
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

        return null;
    }

    public String getJSON(String studiengang) throws ScriptException, IllegalAccessException {
        List<Modul> chosenModules = ModulesGetters.getByCourse(modules, studiengang);
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < chosenModules.size(); i++){
            sb.append(Jsonizer.jsonizeFields((Object)chosenModules.get(i)));
            if (i != chosenModules.size()-1){
                sb.append(", ");
            }
        }
        sb.append("]\n");

        return sb.toString();
    }
}
