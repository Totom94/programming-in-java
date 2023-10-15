package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    @BeforeEach
    void setUp() {
        stackOfInts = new MyStackDLLBImpl<>();
    }

    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }
/**Tests pushing elements to the stack and verifying the top using peek().*/
    @Test
    void testPush() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
    }
/** Tests popping elements from the stack and verifying the popped values*/
    @Test
    void testPop() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.pop());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
    }
    /**Tests the count of elements in the stack after pushing elements.*/
    @Test
    void testNumOfElems() {
        assertEquals(0, stackOfInts.numOfElems());
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.numOfElems());
    }

    /** Tests peeking at the top element of the stack without removing it. */
    @Test
    void testPeek() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.peek());
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
    }
}
