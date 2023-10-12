package agh.ii.prinjava.lab03.exc03_01;

/**
 * An implementation of the QueueOfInts interface using a linked list.
 */
public class LinkedListBasedImpl implements QueueOfInts {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Create an empty queue.
     */
    public LinkedListBasedImpl() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = head.value;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return value;
    }

    @Override
    public int numOfElems() {
        return size;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }
    // Test cases
    public static void main(String[] args) {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();

        // Test Enqueue and Dequeue
        queue.enqueue(42);
        assert queue.dequeue() == 42;    // assert => must be right for test passed

        // Test Empty Queue Dequeue
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            assert e.getMessage().equals("Queue is empty");
        }

        // Test Empty Queue Peek
        try {
            queue.peek();
        } catch (IllegalStateException e) {
            assert e.getMessage().equals("Queue is empty");
        }

        // Test isEmpty
        assert queue.isEmpty();

        // Test Multiple Enqueue and Dequeue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue() == 1;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 3;

        // Test numOfElems
        assert queue.numOfElems() == 0;
    }

}
