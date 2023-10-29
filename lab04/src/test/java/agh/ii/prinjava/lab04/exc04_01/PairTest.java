package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    @Test
    void testPairConstructionAndGetters() {
        Pair<Integer, String> pair = new Pair<>(42, "Answer");

        assertEquals(42, pair.getFst());
        assertEquals("Answer", pair.getSnd());
    }

    @Test
    void testPairSetters() {
        Pair<Integer, String> pair = new Pair<>(0, null);

        pair.setFst(1);
        pair.setSnd("Value");

        assertEquals(1, pair.getFst());
        assertEquals("Value", pair.getSnd());
    }

    @Test
    void testToString() {
        Pair<Integer, String> pair = new Pair<>(42, "Answer");

        assertEquals("(42, Answer)", pair.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Pair<Integer, String> pair1 = new Pair<>(42, "Answer");
        Pair<Integer, String> pair2 = new Pair<>(42, "Answer");
        Pair<Integer, String> pair3 = new Pair<>(42, "Different");

        assertEquals(pair1, pair2);
        assertEquals(pair1.hashCode(), pair2.hashCode());

        assertNotEquals(pair1, pair3);
        assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }

    @Test
    void testClone() {
        Pair<Integer, String> pair1 = new Pair<>(42, "Answer");
        Pair<Integer, String> pair2 = pair1.clone();

        assertEquals(pair1, pair2);
        assertNotSame(pair1, pair2); // Ensure it's a deep copy
    }
}
