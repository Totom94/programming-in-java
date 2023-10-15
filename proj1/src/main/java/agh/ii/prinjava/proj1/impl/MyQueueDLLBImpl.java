package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();
    private int size = 0;

    @Override
    public void enqueue(E x) {
        elems.addLast(x);
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        size--;
        return elems.removeFirst();
    }

    @Override
    public int numOfElems() {
        return size;
    }

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

