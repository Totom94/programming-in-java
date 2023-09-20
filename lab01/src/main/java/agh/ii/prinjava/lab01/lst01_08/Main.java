package agh.ii.prinjava.lab01.lst01_08;

/**
 * The singleton - one of the classic (GoF) design patterns.
 * <p>It restricts the instantiation of a class to one "single" instance
 * <p>Implementations of the singleton pattern must:
 * <ul>
 *     <li>Ensure that only one instance of the singleton class ever exists</li>
 *     <li>Provide global access to that instance</li>
 * </ul>
 *
 * @see <a href="https://dzone.com/articles/singleton-design-pattern-1">
 * The Singleton Design Pattern</a>
 */
public class Main {
    public static void main(String[] args) {
        // UnsafeSingleton usgt0 = new UnsafeSingleton(); // the constructor is private

        if (UnsafeSingleton.getInstance() != UnsafeSingleton.getInstance()) {
            System.out.println("Two instances of an UnsafeSingleton?");
        }

        if (EagerSingleton.getInstance() != EagerSingleton.getInstance()) {
            System.out.println("Two instances of an EagerSingleton?");
        }

        if (LazySingleton.getInstance() != LazySingleton.getInstance()) {
            System.out.println("Two instances of a sLazySingleton?");
        }
    }
    public static void testEagerSingleton() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        if (instance1 == instance2) {
            System.out.println("EagerSingleton test passed: instances are the same");
        } else {
            System.out.println("EagerSingleton test failed: instances are not the same");
        }
    }

    public static void testLazySingleton() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        if (instance1 == instance2) {
            System.out.println("LazySingleton test passed: instances are the same");
        } else {
            System.out.println("LazySingleton test failed: instances are not the same");
        }
    }
}
