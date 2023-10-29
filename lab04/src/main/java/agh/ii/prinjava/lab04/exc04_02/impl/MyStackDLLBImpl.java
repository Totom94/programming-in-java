package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private final DLinkList<E> elems = new DLinkList<>();

    /**
     * Remove the item at the top of the stack and return it.
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E pop() {
        if (elems.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.removeFromStart();
    }

    /**
     * Push an element of type E to the top of the stack.
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Return the number of elements in the stack.
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * Return the top element of the stack without removing it.
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public E peek() {
        if (elems.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.peekFirst();
    }
}
