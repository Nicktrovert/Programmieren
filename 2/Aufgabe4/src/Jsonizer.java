import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class Jsonizer {
    public static String jsonizeList(Collection<?> data) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < data.size(); i++){
            try{
                sb.append(Jsonizer.jsonizeObject(data.toArray()[i]));
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
                sb.append("\"").append(field.getName()).append("\":");
                sb.append(jsonizeList(collection));
                if (j == fields.length-1){
                    sb.append("\n");
                } else {
                    sb.append(",\n");
                }
            }
            else{
                sb.append(getTabsForDepth(depth, 1));
                Object obj = field.get(m);
                if (obj instanceof Number){
                    sb.append("\"").append(field.getName()).append("\": ").append(obj.toString()).append(",\n");
                }
                else if (obj instanceof String){
                    sb.append("\"").append(field.getName()).append("\": \"").append(obj.toString()).append("\",\n");
                }
                else {
                    sb.append("\"").append(field.getName()).append("\": \"").append(jsonizeObject(obj, depth + 1)).append("\",\n");
                }
            }

            j++;
        }

        sb.append(getTabsForDepth(depth)).append("}");

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
