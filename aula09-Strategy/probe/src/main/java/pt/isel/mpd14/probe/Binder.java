package pt.isel.mpd14.probe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isel.mpd14.probe.util.SneakyUtils;
import static pt.isel.mpd14.probe.util.SneakyUtils.asRuntimeException;

public class Binder {
    
    private final BindMember [] bms;

    public Binder(BindMember...bms) {
        this.bms = bms;
    }
    
    public static Map<String, Object> getFieldsValues(Object o)
            throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> res = new HashMap<>();
        Field[] fs = o.getClass().getDeclaredFields();
        for (Field f : fs) {
            f.setAccessible(true);
            res.put(f.getName(), f.get(o));
        }
        return res;
    }

    public <T> T bindTo(Class<T> klass, Map<String, Object> vals)
    {
        try {
            if (klass == null || vals == null) {
                throw new IllegalArgumentException();
            }
            T target = klass.newInstance();
            for (Map.Entry<String, Object> e : vals.entrySet()) {
                for (BindMember bm : bms) {
                    if(bm.bind(target, e.getKey(), e.getValue()))
                        break;
                }
            
            }
            return target;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw asRuntimeException(ex);
        }

    }

}

class WrapperUtilites {

    final static Map<Class<?>, Class<?>> wrappers = new HashMap<>();

    static {
        wrappers.put(boolean.class, Boolean.class);
        wrappers.put(short.class, Short.class);
        wrappers.put(boolean.class, Boolean.class);
        wrappers.put(int.class, Integer.class);

    }

    public static Class<?> toWrapper(Class<?> c) {
        return c.isPrimitive() ? wrappers.get(c) : c;
    }

}
