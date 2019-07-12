package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunMe {
    // key value pairs, type limited to primitive, Wrappers, String, Class, Annotations, and arrays of those.
    String name() default "Unknown";
    int value(); // "value" is special, do not have to use key=val format,
    // but can just specify the value part IFF this is the ONLY key/value pair being
    // specified in source.
}
