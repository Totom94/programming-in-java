package agh.ii.prinjava.lab04.exc04_02.impl;

/**
 * Doubly Linked List implementation that provides basic operations
 * like adding to the end, removing from the start, and peeking the first element.
 *
 * @param <E> Type of elements stored in the linked list.
 */
public class DLinkList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
    }

    /** Adds an element to the beginning of the list. */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>();
        newNode.elem = e;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        }
        else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param e Element to be added.
     */
    public void addToEnd(E e) {
        Node<E> newNode = new Node<>();
        newNode.elem = e;
        if (last == null) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element from the start of the linked list.
     *
     * @return Element removed. Null if the list is empty.
     */
    public E removeFromStart() {
        if (first == null) {
            return null;
        }
        E elem = first.elem;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;
        return elem;
    }

    /** Removes and returns the last element of the list. */
    public E removeLast() {
        E element = last.elem;
        last = last.prev;
        if (last != null) last.next = null;
        else first = null;
        return element;
    }

    /**
     * Returns the size (number of elements) of the linked list.
     *
     * @return Number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first element of the linked list without removing it.
     *
     * @return First element. Null if the list is empty.
     */
    public E peekFirst() {
        return (first != null) ? first.elem : null;
    }
}