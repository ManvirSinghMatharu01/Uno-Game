/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @Manvir Singh Matharu #3121746
 */
public class CircularDoublyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> tail;
    //private Node<E> trailer;
    private int size = 0;

    public CircularDoublyLinkedList() {
        // tail = new Node<E>(null, header, header); 
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void rotateForward() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void rotateBackward() {
        if (tail != null) {
            tail = tail.getPrev();
        }
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null, null);
            tail.setNext(tail);
            tail.setPrev(tail);
            size++;
        } else {
            addBetween(e, tail, tail.getNext());
        }
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(tail.getNext());
    }
    
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> n = tail;
        tail = tail.getPrev();
        return remove(n);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        if (node == predecessor && node == successor) {
            predecessor.setNext(null);
            successor.setPrev(null);
            size--;
            return  node.getElement();
        } else {
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            return node.getElement();
        }
    }
    
}
