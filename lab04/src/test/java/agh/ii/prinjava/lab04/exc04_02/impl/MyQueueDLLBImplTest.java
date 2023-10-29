package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class MyQueueDLLBImplTest {

    @Test
    public void testEnqueueAndDequeue() {
        MyQueueDLLBImpl<Integer> queue = new MyQueueDLLBImpl<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.numOfElems());

        int dequeued = queue.dequeue();
        assertEquals(1, dequeued);
        assertEquals(1, queue.numOfElems());
    }

    @Test
    public void testNumOfElems() {
        MyQueueDLLBImpl<String> queue = new MyQueueDLLBImpl<>();
        assertEquals(0, queue.numOfElems());

        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.numOfElems());
    }

    @Test
    public void testPeek() {
        MyQueueDLLBImpl<String> queue = new MyQueueDLLBImpl<>();
        assertThrows(NoSuchElementException.class, queue::peek);

        queue.enqueue("Hey");
        assertEquals("Hey", queue.peek());
    }
}
