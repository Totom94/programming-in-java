package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DLinkListTest {

    @Test
    public void testAddToEnd() {
        DLinkList<Integer> list = new DLinkList<>();
        list.addToEnd(1);
        list.addToEnd(2);

        assertEquals(2, list.size());
        assertEquals(1, list.peekFirst());
    }

    @Test
    public void testRemoveFromStart() {
        DLinkList<Integer> list = new DLinkList<>();
        list.addToEnd(1);
        list.addToEnd(2);

        int removed = list.removeFromStart();
        assertEquals(1, removed);
        assertEquals(1, list.size());
    }

    @Test
    public void testSize() {
        DLinkList<String> list = new DLinkList<>();
        assertEquals(0, list.size());

        list.addToEnd("A");
        list.addToEnd("B");
        assertEquals(2, list.size());
    }

    @Test
    public void testPeekFirst() {
        DLinkList<String> list = new DLinkList<>();
        assertNull(list.peekFirst());

        list.addToEnd("Hello");
        assertEquals("Hello", list.peekFirst());
    }
}
