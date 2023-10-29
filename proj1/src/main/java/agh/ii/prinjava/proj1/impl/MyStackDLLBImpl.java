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
        int count = 0;  // Variable pour compter le nombre d'éléments
        List<E> temp = new ArrayList<>();  // Une liste temporaire pour stocker les éléments

        while (true) {
            try {
                // Essayer de retirer un élément de la pile
                E elem = elems.removeFirst();  // Retire le premier élément de la pile
                temp.add(elem);  // Ajoute l'élément à la liste temporaire
                count++;  // Incrémente le compteur d'éléments
            } catch (Exception e) {
                // Si une exception est déclenchée (pile vide), sortir de la boucle
                break;
            }
        }

        // Réinsère les éléments depuis la liste temporaire dans la pile
        for (E e : temp) {
            elems.addFirst(e);  // Réinsère chaque élément au début de la pile
        }

        return count;  // Retourne le nombre total d'éléments dans la pile
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E elem = elems.removeLast();
        elems.addLast(elem);
        return elem;
    }
}
