import java.util.ArrayList;
import java.util.List;

public class ModulesGetters {
    public static List<Modul> getByCourse(List<Modul> modules, String studiengang){
        List<Modul> modulesOfCourse = new ArrayList<>();

        for (Modul m : modules){
            /*if (m.studiengang == studiengang){
                modulesOfCourse.add(m);
            }*/
        }

        return modulesOfCourse;
    }
}
