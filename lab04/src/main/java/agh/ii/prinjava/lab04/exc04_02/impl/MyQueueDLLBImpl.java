package agh.ii.prinjava.lab04.exc04_02.impl;
import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import java.util.NoSuchElementException;

/**
 * Implementation of a queue using a Doubly Linked List.
 * This provides operations like enqueue, dequeue, and peek.
 *
 * @param <E> Type of elements stored in the queue.
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Adds an element to the end of the queue.
     *
     * @param x Element to be added.
     */
    @Override
    public void enqueue(E x) {
        elems.addToEnd(x);
    }

    /**
     * Removes and returns the element from the start of the queue.
     *
     * @return Element removed.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elems.removeFromStart();
    }

    /**
     * Returns the size (number of elements) of the queue.
     *
     * @return Number of elements in the queue.
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * Returns the front element of the queue without removing it.
     *
     * @return Front element.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elems.peekFirst();
    }
}