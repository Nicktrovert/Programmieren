import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class Modulbeschreibungen {

    List<Modul> modules = new ArrayList<>();

    public static void main(String[] args) throws ScriptException {
        Modulbeschreibungen m = new Modulbeschreibungen();
        m.getJSON("a");
    }

    /* liefert die Modulbeschreibungen eines Studiengangs im JSON-Format.
     * Für unser obiges Beispiel würde die Rückgabe folgendermaßen aussehen
     */
    public String getJSON(String studiengang) throws ScriptException {
        List<Modul> chosenModules = new ArrayList<>();
       /*modules.forEach(module -> {
           if (module.studiengang == studiengang){
                chosenModules.add(module);
           }
       });*/

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("GraalVM");

        Bindings bindings = engine.createBindings();
        bindings.put("module_list", chosenModules);

        String script = "var greeting='Hello ';" +
                "greeting += module_list;" +
                "greeting";

        Object bindingsResult = engine.eval(script, bindings);

        System.out.println(bindingsResult);

        return "";
    }
}
