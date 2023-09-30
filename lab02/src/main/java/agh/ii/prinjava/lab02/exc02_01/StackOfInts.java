package agh.ii.prinjava.lab02.exc02_01;

/**
 * Stack of integers - Abstract Data Type (ADT)
 */
// interface for basic operations for a stack of integers
public interface StackOfInts {
    int pop();      // Remove and return the top element from the stack

    void push(int x);   // Push a new integer onto the top of the stack (x)

    default boolean isEmpty() {   // Checks if the stack is empty (true if the stack is empty, false otherwise)

        return numOfElems() == 0;
    }

    int numOfElems();   // Return the number of elements in the stack

    int peek();    //Returns the top element of the stack
}
