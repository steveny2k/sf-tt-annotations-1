package annotations;

import java.lang.reflect.Method;

public class InspectUnitUnderTest {
    public static void main(String[] args) throws Throwable {
        UnitUnderTest rm = new UnitUnderTest();
        Class clazz = rm.getClass();

//        Method m = clazz.getMethod("doStuff");
//        Method[] methods = clazz.getMethods(); // get accessible methods, including inherited
        Method[] methods = clazz.getDeclaredMethods(); // get methods declared in this class, excluding inherited, including private

//        clazz.getSuperclass();
        for (Method m : methods) {
            System.out.println("Method is " + m);
            RunMe runMe = m.getAnnotation(RunMe.class);
            if (runMe != null) {
                System.out.println("method carries @RunMe annotation...");
            }
        }

    }
}
