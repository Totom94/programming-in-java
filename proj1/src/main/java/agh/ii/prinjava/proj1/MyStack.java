package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/** Interface for creating a stack */
public interface MyStack<E> {

    /** Remove the item at the top of the stack and turn it over */
    E pop();

    /** Put an element of type E at the top of the stack */
    void push(E x);

    /** Check whether the stack is empty or not, if so: return true, and vice versa */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /** Return the number of element of the stack */
    int numOfElems();

    /** Returns the top element of the stack without removing it */
    E peek();

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
