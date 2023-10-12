package agh.ii.prinjava.lab03.exc03_01;

/**
 * An interface for a queue of integers.
 */
public interface QueueOfInts {
    /**
     * Add an integer to the back of the queue.
     *
     * @param x The integer to enqueue.
     */
    void enqueue(int x);

    /**
     * Remove and return the integer from the front of the queue.
     *
     * @return The dequeued integer.
     * @throws IllegalStateException if the queue is empty.
     */
    int dequeue();

    /**
     * Check if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Get the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    int numOfElems();

    /**
     * Peek at the integer at the front of the queue without removing it.
     *
     * @return The integer at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();
}
