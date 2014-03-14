package probe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Binder {

    public static Map<String, Object> getFieldsValues(Object o) 
            throws IllegalArgumentException, IllegalAccessException 
    {
        Map<String, Object> res = new HashMap<>();
        Field[] fs = o.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            res.put(f.getName(), f.get(o));
        }
        return res;
    }

}
