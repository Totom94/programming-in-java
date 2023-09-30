package agh.ii.prinjava.lab02.exc02_01.impl;


import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import java.util.EmptyStackException;

 //An array-based implementation of the StackOfInts interface.
public class ArrayBasedImpl implements StackOfInts {
    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
     //Constructs an empty array-based stack with the default capacity.
    public ArrayBasedImpl() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

     //Constructs an empty array-based stack with the specified initial capacity.
    public ArrayBasedImpl(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero.");
        }
        array = new int[initialCapacity];
        size = 0;
    }
     //Removes and returns the top element from the stack.
     //@throws EmptyStackException If the stack is empty.
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = array[--size];
        array[size] = 0; // Set the popped element to zero (optional).
        shrinkIfNeeded();
        return poppedValue;
    }
     //Pushes a new integer onto the top of the stack.
    @Override
    public void push(int x) {
        ensureCapacity();
        array[size++] = x;
    }
     //Checks if the stack is empty.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    //Returns the number of elements currently in the stack.
    @Override
    public int numOfElems() {
        return size;
    }
     //Returns the top element of the stack without removing it.
     //@throws EmptyStackException If the stack is empty.
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
    private void shrinkIfNeeded() {
        if (size > DEFAULT_CAPACITY && size <= array.length / 4) {
            int newCapacity = array.length / 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

}
