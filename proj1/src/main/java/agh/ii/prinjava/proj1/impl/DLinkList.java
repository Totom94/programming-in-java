package agh.ii.prinjava.proj1.impl;
/**
 * A doubly-linked list implementation (data structure that has reference to both the previous and next nodes in the list. It provides simplicity to traverse, insert and delete the nodes in both directions in a list.
 *
 * @param <E> the type of elements held in this collection
 */
public class DLinkList<E> {
    private Node<E> head; // First node of the list
    private Node<E> tail; // Last node of the list

    /**
     * Node class for doubly linked list.
     * It contains an element and pointers to previous and next nodes.
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /** Declaration of each node element: constructor*/
        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Adds an element at the beginning of the list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null, head);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element
     */
    public E removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        E removedElem = head.elem;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return removedElem;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the removed element
     */
    public E removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        E removedElem = tail.elem;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return removedElem;
    }

    /**Returns a string representation of the doubly-linked list.*/
    @Override
    public String toString() {
        if (head == null) return "[]";
        String result = "[";
        Node<E> current = head;
        while (current.next != null) {
            result += current.elem + ", ";
            current = current.next;
        }
        result += current.elem + "]";
        return result;
    }

}
