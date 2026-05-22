import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Modulbeschreibungen {
    List<Modul> modules = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Modulbeschreibungen modB = new Modulbeschreibungen("2/Aufgabe4/src/textFile.txt");
        System.out.println(Arrays.toString(modB.modules.toArray()));
    }

    public Modulbeschreibungen(String filename) throws IOException {
        List<List<String>> data = loadFile(filename);

        for (int i = 0; i < data.size(); i+=0){
            List<List<String>> moduleData = new ArrayList<>();
            while (!data.get(i).isEmpty() || !data.get(i).get(0).isEmpty()){
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
            result.add(Arrays.asList(line.split("|")));
        }
        br.close();
        return result;
    }

    public Set<String> getZertifikate(String studiengang){
        List<Modul> modulesOfCourse = ModulesGetters.getByCourse(modules, studiengang);

        return null;
    }

    /* liefert die Modulbeschreibungen eines Studiengangs im JSON-Format.*/
    public String getJSON(String studiengang) throws ScriptException {
        List<Modul> chosenModules = ModulesGetters.getByCourse(modules, studiengang);

        Modul.class.getModule()

        return "";
    }
}
