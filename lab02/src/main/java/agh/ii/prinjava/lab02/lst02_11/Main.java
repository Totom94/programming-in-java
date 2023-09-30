package agh.ii.prinjava.lab02.lst02_11;

public class Main {
    private static void demo1() {
        System.out.println("demo1...");
        // Using anonymous class
        I1 i11 = new I1() {   //(1)
            @Override
            public int apply() {
                // Implementation logic here (void --> int)
                return 40;       // example of value
            }
        };
        i11.apply();

        // The above can be abbreviated to
        I1 i12 = () -> {
            return 40;
        }; // lambda expression corresponding to (1) , int
        i12.apply();

        int res1 = i11.apply();
        int res2 = i12.apply();
        System.out.println("Anonymous: "+ res1);
        System.out.println("Lambda: "+ res2);
    }

    private static void demo2() {
        System.out.println("demo2...");
        // Using anonymous class
        I2 i21 = new I2() {
            @Override
            public void apply(int value) {

                System.out.println("i21.m1()");   // void
            }
        };
        i21.apply(1);

        // The above can be abbreviated to one of these (they are equivalent) ; lambda expressions
        I2 i22 = x -> System.out.println("i22.m1()");
        i22.apply(1);

        I2 i23 = (x) -> System.out.println("i23.m1()");
        i23.apply(1);

        I2 i24 = (int x) -> System.out.println("i24.m1()");
        i24.apply(1);

        I2 i25 = (var x) -> System.out.println("i25.m1()");
        i25.apply(1);
    }

    /**
     * <ul>
     *     <li>{@code {}} means that {@code return} should be used, i.e., {@code (x) -> { return 2 * x; }}</li>
     *     <li>multiline lambdas are not recommended (not a "clean code")</li>
     * </ul>
     */
    private static void demo3() {
        System.out.println("demo3...");
        // Anonymous class
        I3 i31 = new I3() {
            @Override
            public int apply(int x) {

                return 4 * x;
            }
        };

        I3 lambdaexp = (value) -> {
            return value * 2;
        };

        int res1 = i31.apply(5);
        int res2 = lambdaexp.apply(10);
        System.out.println("Anonymous: "+ res1);
        System.out.println("Lambda: "+ res2);

        /*
        I3[] i3s = {
                (int x) -> 2 * x, // <- This is most common
                (int x) -> {
                    return 2 * x;
                }
        };

        for (var i3 : i3s) {
            System.out.println("i31.m3(5) = " + i3.apply(5));
        }
        */
    }

    private static void demo4() {
        System.out.println("demo4...");
        // Anonymous class
        I4 i41 = new I4() {
            @Override
            public void apply(int x, int y) {
                System.out.println("i41.m4(), x = " + x + ", y = y");   // void result
            }
        };

        I4 lambdaexp = (value1, value2) -> {
            System.out.println("Values: " + value1 + ", " + value2);   // void result
        };

        i41.apply(5,10);
        lambdaexp.apply(5,10);

        /*
        new I4() {
            @Override
            public void apply(int x, int y) {
                System.out.println("anonymous1.m4(), x = " + x + ", y = y");
            }
        }.apply(2, 5);

        I4[] i4s = {
                (int x, int y) -> System.out.println("i43.m4(), x = " + x + ", y = y"),
                (x, y) -> System.out.println("i44.m4(), x = " + x + ", y = y"), // <- This is most common
                (int x, int y) -> System.out.println("i45.m4(), x = " + x + ", y = y"),
                (var x, var y) -> System.out.println("i46.m4(), x = " + x + ", y = y")
        };

        for (var i4 : i4s) {
            i4.apply(10, 20);
        }
         */
    }

    /**
     * A nested functional interface; function: (int, int) -> int
     * <p><i>Note</i>: modifier {@code static} is redundant for inner interfaces
     */
    @FunctionalInterface
    private /*static*/ interface I51 {
        int apply(int x, int y);
    }

    private static void demo5() {
        System.out.println("demo5...");
        I5 i51 = new I5() {
            @Override
            public int apply(int x, int y) {
                return x + y;
            }
        };
        System.out.println("i51.m5(3,7) = " + i51.apply(3, 7));

        I5 i52 = (x, y) -> x + y;
        System.out.println("i52.m5(4,11) = " + i52.apply(4, 11));

        // Cast is needed because in Java a lambda expressions corresponds to a functional interface
        System.out.println("((I5)(int x, int y) -> x + y).m5(21,4) = " +
                ((I5) (int x, int y) -> x + y).apply(21, 4));

        System.out.println("((I51)(int x, int y) -> x + y).m5(21,4) = " +
                ((I51) (int x, int y) -> x + y).apply(21, 4));
    }

    public static void main(String[] args) {
        demo1();
        System.out.println();

        demo2();
        System.out.println();

        demo3();
        System.out.println();

        demo4();
        System.out.println();

        demo5();
    }
}


