import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class Jsonizer {
    public static String jsonizeList(List<?> data) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < data.size(); i++){
            try{
                sb.append(Jsonizer.jsonizeObject(data.get(i)));
                if (i != data.size()-1){
                    sb.append(", ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static String jsonizeObject(Object m) throws IllegalAccessException {
        return jsonizeObject(m, 0);
    }

    private static String jsonizeObject(Object m, int depth) throws IllegalAccessException {
        Field[] fields = m.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        int j = 0;
        for (Field field : fields){
            field.setAccessible(true);
            Object value = field.get(m);

            if (value instanceof Collection<?> collection){
                sb.append(getTabsForDepth(depth, 1));
                sb.append("\"" + field.getName() + "\": [");
                int i = 0;
                for (Object o : collection){
                    String temp = jsonizeObject(o, depth+1);
                    sb.append(temp);
                    sb.deleteCharAt(sb.length()-(2+getTabsForDepth(depth+1).length()+1));
                    if (i != collection.size()-1){
                        sb.append(", ");
                    } 
                    else{
                        if (j == fields.length-1){
                            sb.append("]\n");
                        } else {
                            sb.append("],\n");
                        }
                    }
                    i++;
                }
            }
            else{
                sb.append(getTabsForDepth(depth, 1));
                sb.append("\"" + field.getName() + "\": \"" + field.get(m).toString() + "\",\n");
            }

            j++;
        }

        sb.append(getTabsForDepth(depth) + "}");

        return sb.toString();
    }

    private static String getTabsForDepth(int depth){
        return getTabsForDepth(depth, 0);
    }

    private static String getTabsForDepth(int depth, int add){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth + add; i++){
            sb.append("\t");
        }
        return sb.toString();
    }
}
