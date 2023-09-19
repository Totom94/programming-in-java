package agh.ii.prinjava.lab01.lst01_09;


/**
 * A Java Record is a special kind of Java class which has a concise syntax for defining immutable
 * data-only classes. HelloJavaRecord corresponds to {@link HelloImmutable}
 *
 * <p>A record declaration specifies in a header a description of its contents.
 * The following class members are created automatically:
 * <ul>
 *     <li>the appropriate accessors
 *         (note a different naming convention not {@code  getVal()} but {@code val()})</li>
 *     <li>constructor</li>
 *     <li>equals method</li>
 *     <li>hashCode method</li>
 *     <li>toString method</li>
 * </ul>
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/16/language/records.html">Record Classes</a>
 * @since Java 14
 */
public record HelloJavaRecord(int i1, String s1) {
    public static void sm1() {
        System.out.println("HelloImmutable.sm1()");
    }

    private static void demo2() {
        HelloJavaRecord hjr = new HelloJavaRecord(1, "abc");
        System.out.println("hjr = " + hjr); // toString called implicitly
        HelloJavaRecord.sm1();

        // Note the naming convention used by the code generator (no "get" prefix!)
        System.out.println("hjr.i1 = " + hjr.i1() + ", hi.s1 = " + hjr.s1());

        // Test Java Record Creation
        assert hjr.i1() == 1;
        assert hjr.s1().equals("abc");

        // Test Java Record Equality
        HelloJavaRecord hjr2 = new HelloJavaRecord(1, "abc");
        assert hjr.equals(hjr2);
    }
}



