package annotations;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestHarness {
    public static void main(String[] args) throws Throwable {
//        System.setSecurityManager(new SecurityManager());
        Properties prop = new Properties();
        prop.load(new FileReader("config.properties"));
        String classToLoad = prop.getProperty("toLoad1");
        System.out.println("About to load: " + classToLoad);

//        System.setSecurityManager(new SecurityManager());

        Class clazz = Class.forName(classToLoad);
        Object obj = clazz.getConstructor().newInstance();
        System.out.println("obj is " + obj);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("method: " + m);
            RunMe runMe = m.getAnnotation(RunMe.class);
            if (runMe != null) {
                m.setAccessible(true);
                System.out.println("**** Annotated @RunMe name is " + runMe.name());
                Object rv = m.invoke(obj);
            }
        }
    }
}
