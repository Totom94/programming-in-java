package agh.ii.prinjava.lab04.lst04_03;

/**
 * Generic class with a generic method
 */
class C3<T> { // This "T"...
    private T x;

    // ... has nothing to do with the "T" below (DO NOT reuse the same name! See the comment below)
    <T> T sm1(T x) {
        return x;
    }
}
