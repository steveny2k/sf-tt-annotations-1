package annotations;

//@RunMe
public class UnitUnderTest {
//    @RunMe
    private String name = "Fred";

    @RunMe(3)
    public void doStuff() {
        System.out.println("Called doStuff method...");
    }
    public void doStuff2() {
        System.out.println("Called doStuff2 method...");
    }
    @RunMe(name="Jim", value=99)
    private void doStuff3() {
        System.out.println("Called doStuff3 method...");
    }

    @Override
    public String toString() {
        return "UnitUnderTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
