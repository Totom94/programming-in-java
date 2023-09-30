package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;


import java.util.EmptyStackException;


 //A linked list-based implementation of the StackOfInts interface.
public class LinkedListBasedImpl implements StackOfInts {

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
    private Node first = null; // Reference to the first node in the linked list.
    private int numOfElems = 0; // The number of elements in the stack.
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = first.elem;
        first = first.next;
        numOfElems--;
        return poppedValue;
    }
    @Override
    public void push(int x) {
        Node newNode = new Node(x, first);
        first = newNode;
        numOfElems++;
    }
    @Override
    public int numOfElems() {
        return numOfElems;
    }
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return first.elem;
    }

    // Unit tests
    public static void main(String[] args) {
        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        // Test pushing elements onto the stack and checking the number of elements.
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.numOfElems() == 3;
        // Test peeking at the top element.
        assert stack.peek() == 3;
        // Test popping elements from the stack and checking the number of elements.
        assert stack.pop() == 3;
        assert stack.pop() == 2;
        assert stack.numOfElems() == 1;

        // Test popping the last element.
        assert stack.pop() == 1;
        assert stack.numOfElems() == 0;
        // Test attempting to pop from an empty stack (should throw an exception).
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            // Expected exception.
            System.out.println("Popped from an empty stack.");
        }
    }
}
