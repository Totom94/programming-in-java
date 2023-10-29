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
     *
     *                  ou
     *
     * Represents a node within the doubly-linked list.
     *
     * Each node maintains a reference to its element and pointers to both the
     * preceding and succeeding nodes in the list. This structure allows for
     * bidirectional traversal of the list.
     *
     *
     * @param <T> the type of element held by the node
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /** Declaration of each node element: constructor
         *
         *                      ou
         *
         * Constructs a new node with the specified element and pointers.
         *
         * @param elem the element to be stored in this node
         * @param prev pointer to the preceding node in the list
         * @param next pointer to the succeeding node in the list
         */
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
     *
     *      ou
     *
     * Inserts the specified element at the beginning of the list.
     *
     * If the list is empty, the new element becomes both the head and the tail.
     * Otherwise, the new element is set as the new head and the previous head's
     * 'prev' reference is updated to point to the new node.
     *
     * @param e the element to insert at the beginning of the list
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
     *
     *          ou
     *
     * Inserts the specified element at the end of the list.
     *
     * If the list is empty, the new element becomes both the head and the tail.
     * Otherwise, the current tail's 'next' reference is updated to point to the new node,
     * and the new node becomes the tail of the list.
     *
     * @param e the element to insert at the end of the list
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
     *
     *              ou
     *
     * Removes and returns the element at the beginning of the list.
     *
     * This method updates the head of the list to point to the next element. If the list
     * becomes empty after the removal, both the head and the tail are set to null.
     * If the list was already empty prior to the call, an exception is thrown.
     *
     *
     * @return the element that was removed from the beginning of the list
     * @throws IllegalStateException if the list is empty
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
     *
     *                  ou
     *
     * Removes and returns the element at the end of the list.
     *
     * This method updates the tail of the list to point to the previous element. If the list
     * becomes empty after the removal, both the head and the tail are set to null.
     * If the list was already empty prior to the call, an exception is thrown.
     *
     *
     * @return the element that was removed from the end of the list
     * @throws IllegalStateException if the list is empty
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

    /**Returns a string representation of the doubly-linked list.
     *
     *                  ou
     *
     * Returns a string representation of the doubly-linked list.
     *
     * This method traverses the list from the head to the tail, appending each element's value
     * to a string. Elements are separated by commas, and the entire list is enclosed in square brackets.
     * If the list is empty, it returns an empty set of brackets "[]".
     *
     *
     * @return a string representation of the list in the format "[elem1, elem2, ...]"
     */

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
