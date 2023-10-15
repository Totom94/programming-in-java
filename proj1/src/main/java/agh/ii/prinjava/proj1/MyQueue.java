package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/** Interface for creating a queue */
public interface MyQueue<E> {

    /** Add an element to the end of the queue: tail */
    void enqueue(E x);

    /** Remove an element at the start of the queue: head */
    E dequeue();

    /** Check whether the queue is empty or not, if so: return true and vice versa */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** Return the number of element of the queue */
    int numOfElems();

    /** Returns the top element of the queue without removing it */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
