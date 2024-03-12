package Queues;

import LinkedList.Node;

public class LinkedQueue<T> implements MyQueue<T> {

    private int size;
    private Node<T> head;


    public LinkedQueue() {
        size = 0;
        head = null;
    }

    @Override
    public void enqueue(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        Node<T> added = new Node<>(t);
        if (head == null) {

            head = added;
        } else {
            head.next = added;
        }
        size++;

    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        } else {
            T data = head.data;

            head = head.next;
            size--;
            return data;

        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }


    @Override
    public int size() {
        return size;
    }
}
