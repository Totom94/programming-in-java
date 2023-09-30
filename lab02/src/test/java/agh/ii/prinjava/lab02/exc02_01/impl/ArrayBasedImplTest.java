package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void pop() {
    }

    @Test
    void push() {
    }

    @Test
    void testIsEmpty() {
    }

    @Test
    void numOfElems() {
    }

    @Test
    void peek() {
    }
}