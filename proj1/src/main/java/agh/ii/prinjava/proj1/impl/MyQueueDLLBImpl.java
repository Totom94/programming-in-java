package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * Implementation of a queue based on a doubly linked list.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>(); // Doubly linked list to store elements
    private int size = 0; // Current size of the queue

    /**
     * Adds an element to the end of the queue.
     *
     * @param x the element to add
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
        size++;
    }

    /**
     * Removes and returns the first element of the queue.
     *
     * @return the first element of the queue
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        size--;
        return elems.removeFirst();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return size;
    }

    /**
     * Retrieves the first element of the queue without removing it.
     *
     * @return the first element of the queue
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E firstElem = elems.removeFirst();
        elems.addFirst(firstElem);
        return firstElem;
    }
}
