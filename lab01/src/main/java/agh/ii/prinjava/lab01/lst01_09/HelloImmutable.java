package agh.ii.prinjava.lab01.lst01_09;


import java.util.Objects;

/**
 * An example of a simple immutable class -- its instances cannot be "mutated"
 * Note: more about keyword {@code final} next time
 */
final public class HelloImmutable { // <- this "final" makes the class closed for extension
    final private int i1; // <- this "final" makes this field a constant
    final private String s1; // as above

    public HelloImmutable(int i1, String s1) {
        this.i1 = i1;
        this.s1 = s1;
    }

    /**
     * Only accessors (getters), no mutators (setters)
     */
    public int getI1() {
        return i1;
    }

    public String getS1() {
        return s1;
    }

    @Override
    public String toString() {
        return "HelloImmutable{" +
                "i1=" + i1 +
                ", s1='" + s1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloImmutable that = (HelloImmutable) o;
        return i1 == that.i1 && Objects.equals(s1, that.s1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, s1);
    }

    public static void sm1() {
        System.out.println("HelloImmutable.sm1()");
    }


    /**
     * An immutable class/object demo
     */
    private static void demo1() {
        // hi is immutable/read-only
        HelloImmutable hi = new HelloImmutable(1, "abc");
        System.out.println("hi = " + hi); // toString called implicitly
        HelloImmutable.sm1();

        System.out.println("hi.i1 = " + hi.getI1() + ", hi.s1 = " + hi.getS1());

        // Test Immutable Object Creation
        assert hi.getI1() == 1;
        assert hi.getS1().equals("abc");

        // Test Immutable Object Equality
        HelloImmutable hi2 = new HelloImmutable(1, "abc");
        assert hi.equals(hi2);
    }
}
