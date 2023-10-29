package agh.ii.prinjava.lab04.exc04_01;

import java.util.Objects;

/**
 * Generic class representing a pair of two values of different types.
 *
 * @param <F> The type of the first value (fst).
 * @param <S> The type of the second value (snd).
 */
public class Pair<F, S> implements Cloneable {
    private F fst;
    private S snd;

    /**
     * Constructs a new Pair with the given values.
     *
     * @param fst The first value.
     * @param snd The second value.
     */
    public Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

    /**
     * Get the first value (fst) of the pair.
     *
     * @return The first value.
     */
    public F getFst() {
        return fst;
    }

    /**
     * Set the first value (fst) of the pair.
     *
     * @param fst The first value to set.
     */
    public void setFst(F fst) {
        this.fst = fst;
    }

    /**
     * Get the second value (snd) of the pair.
     *
     * @return The second value.
     */
    public S getSnd() {
        return snd;
    }

    /**
     * Set the second value (snd) of the pair.
     *
     * @param snd The second value to set.
     */
    public void setSnd(S snd) {
        this.snd = snd;
    }

    /**
     * Returns a string representation of the Pair.
     *
     * @return A string representation in the form "(fst, snd)".
     */
    @Override
    public String toString() {
        return "(" + fst + ", " + snd + ")";
    }

    /**
     * Compares this Pair to another object for equality.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    /**
     * Computes a hash code for the Pair.
     *
     * @return A hash code value based on the contents of the Pair.
     */
    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }

    /**
     * Creates a shallow copy (clone) of the Pair.
     *
     * @return A new Pair instance with the same values.
     */
    @Override
    public Pair<F, S> clone() {
        try {
            @SuppressWarnings("unchecked")
            Pair<F, S> clonedPair = (Pair<F, S>) super.clone();
            return clonedPair;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Example of how to use the Pair class with unit tests.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");

        System.out.println(pair1); // (1, One)
        System.out.println(pair1.equals(pair2)); // true
        System.out.println(pair1.hashCode() == pair2.hashCode()); // true

        Pair<Integer, String> pair3 = pair1.clone();
        System.out.println(pair1.equals(pair3)); // true
        System.out.println(pair1.hashCode() == pair3.hashCode()); // true
    }
}
