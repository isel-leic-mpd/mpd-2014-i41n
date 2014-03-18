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

    public static <T> T bindTo(Class<T> klass, Map<String, Object> fieldsVals) 
            throws InstantiationException, IllegalAccessException
    {
        T target = klass.newInstance();
        Field[] fields = klass.getDeclaredFields();
        for (Field f : fields) {
            String fName = f.getName();
            if(fieldsVals.containsKey(fName)){
                Class<?> fType = f.getType();
                Object fValue = fieldsVals.get(fName);
                f.setAccessible(true);
                if(fType.isPrimitive()){
                    // fType = WrapperUtilites.toWrapper(fType);
                    fType = f.get(target).getClass();
                }
                /*
                 * Verifica se o tipo do campo (fType) é tipo base do tipo de fValue.
                 * Nota: Tipo base inclui superclasses ou superinterfaces.
                 */
                if(fType.isAssignableFrom(fValue.getClass())){
                    f.set(target, fValue);
                }
            }
        }
        return target;
    }
    
}

class WrapperUtilites{
    
    final static Map<Class<?>, Class<?>> wrappers = new HashMap<>();
    
    static{
        wrappers.put(boolean.class, Boolean.class);
        wrappers.put(short.class, Short.class);
        wrappers.put(boolean.class, Boolean.class);
        wrappers.put(int.class, Integer.class);
        
    }
    
    public static Class<?> toWrapper(Class<?> c){
        return c.isPrimitive()? wrappers.get(c) : c;
    }

}
