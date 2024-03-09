package govnoParser;

import annotations.BuilderParameter;
import annotations.ExcludeMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CompositeType<T> extends Entity implements Serializable<T> {
    private final HashMap<String, Serializable<?>> childTypes = new HashMap<>();
    private final HashMap<String, Method> childGetters = new HashMap<>();
    private final List<String> factoryKeys = new ArrayList<>();
    private Method factory;
    @ExcludeMethod
    public HashMap<String, ? extends Serializable<?>> getChildTypes() {
        return childTypes;
    }
    @ExcludeMethod
    public HashMap<String, Method> getChildGetters() {
        return childGetters;
    }
    @ExcludeMethod
    public List<String> getFactoryKeys() {
        return factoryKeys;
    }

    public void fillKeys(Class<?> type) {
        for (Method getter : type.getMethods()) {
            if (!getter.getName().startsWith("get") || getter.getName().equals("getClass")|| getter.getAnnotation(ExcludeMethod.class) != null) {
                continue;
            }

            System.out.println(type.getName());


            String keyFirstUpperCase = getter.getName().substring(3);
            String key = keyFirstUpperCase.substring(0,1).toLowerCase() + keyFirstUpperCase.substring(1);

            childTypes.put(key, builder.createNewSerializableType(getter.getReturnType(), key));
            childGetters.put(key, getter);
        }
    }

    public void findFactory(Class<?> type) {
        for (Method method : type.getMethods()) {
            if (!method.getName().equals("build") || method.getReturnType() != type) {
                continue;
            }

            factory = method;

            for (Annotation[] annotations : method.getParameterAnnotations()) {
                boolean found = false;
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType() == BuilderParameter.class) {
                        factoryKeys.add(((BuilderParameter) annotation).value());
                        found = true;
                    }
                }

                if(!found) {
                    throw new RuntimeException("Every builder parameter has to have BuilderParameter annotation!");
                }
            }
        }

        if (factory == null) {
            throw new RuntimeException("Missing build factory method in " + type.getName());
        }
    }
    public CompositeType(Class<?> type, String entityName) {
        super(entityName);

        fillKeys(type);
        findFactory(type);
    }
}


