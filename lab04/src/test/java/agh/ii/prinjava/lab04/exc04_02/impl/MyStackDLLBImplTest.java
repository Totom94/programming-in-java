package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackDLLBImplTest {

    @Test
    public void testPushAndPop() {
        MyStackDLLBImpl<Integer> stack = new MyStackDLLBImpl<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.numOfElems());

        int popped = stack.pop();
        assertEquals(2, popped);
        assertEquals(1, stack.numOfElems());
    }

    @Test
    public void testNumOfElems() {
        MyStackDLLBImpl<String> stack = new MyStackDLLBImpl<>();
        assertEquals(0, stack.numOfElems());

        stack.push("A");
        stack.push("B");
        assertEquals(2, stack.numOfElems());
    }

    @Test
    public void testPeek() {
        MyStackDLLBImpl<String> stack = new MyStackDLLBImpl<>();
        stack.push("Hello");
        assertEquals("Hello", stack.peek());
    }
}
