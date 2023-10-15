package agh.ii.prinjava.proj1.impl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList;
    /**
     * This method sets up a new DLinkList before each test.
     */
    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }
    /**
     * This method cleans up the DLinkList after each test.
     */
    @AfterEach
    void tearDown() {
        dLinkList = null;
    }
    /**
     * Test to check the addFirst method.
     * The test checks if an element is correctly added at the beginning.
     */
    @Test
    void testAddFirst() {
        dLinkList.addFirst(1);
        assertEquals("[1]", dLinkList.toString()); // Assert is a method useful in determining Pass or Fail status of a test case
        dLinkList.addFirst(2);
        assertEquals("[2, 1]", dLinkList.toString());
    }
    /**
     * Test to check the addLast method.
     * The test checks if an element is correctly added at the end.
     */
    @Test
    void testAddLast() {
        dLinkList.addLast(1);
        assertEquals("[1]", dLinkList.toString());
        dLinkList.addLast(2);
        assertEquals("[1, 2]", dLinkList.toString());
    }
    /**
     * Test to check the removeFirst method.
     * The test checks if the first element is correctly removed and the appropriate value is returned.
     */
    @Test
    void testRemoveFirst() {
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        assertEquals(2, dLinkList.removeFirst());
        assertEquals("[1]", dLinkList.toString());
    }
    /**
     * Test to check the removeLast method.
     * The test checks if the last element is correctly removed and the appropriate value is returned.
     */
    @Test
    void testRemoveLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        assertEquals(2, dLinkList.removeLast());
        assertEquals("[1]", dLinkList.toString());
    }
    /**
     * Test to check the toString method. The test checks whether the string representation is correctly generated
     */
    @Test
    void testToString() {
        assertEquals("[]", dLinkList.toString());

        dLinkList.addLast(1);
        assertEquals("[1]", dLinkList.toString());

        dLinkList.addLast(2);
        assertEquals("[1, 2]", dLinkList.toString());
    }
}
