package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

import java.util.ArrayList;
import java.util.List;

/**
 * MyStack implementation using a doubly linked list.
 * @param <E> type of elements stored in the stack.
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int numOfElems() {
        int count = 0;
        List<E> temp = new ArrayList<>();
        while (true) {
            try {
                E elem = elems.removeFirst();
                temp.add(elem);
                count++;
            } catch (Exception e) {
                break;
            }
        }

        for (E e : temp) {
            elems.addFirst(e);
        }
        return count;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E elem = elems.removeFirst();
        elems.addFirst(elem);
        return elem;
    }
}
