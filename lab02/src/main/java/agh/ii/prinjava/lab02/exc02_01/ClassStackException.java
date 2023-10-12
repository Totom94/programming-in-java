package agh.ii.prinjava.lab02.exc02_01;

import java.util.EmptyStackException;

public class ClassStackException implements StackOfInts {
    private int[] stack;
    private int top;
    private int capacity;

    public ClassStackException(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    @Override
    public void push(int x) {
        if (isFull()) {
            throw new StackOverflowException("Stack is full !");
        }
        stack[++top] = x;
    }

    @Override
    public int numOfElems() {
        return top + 1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    public static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String message) {
            super(message);
        }
    }
}
