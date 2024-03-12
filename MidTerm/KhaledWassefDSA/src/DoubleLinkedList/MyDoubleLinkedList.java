package DoubleLinkedList;

import LinkedList.Node;

public class MyDoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;


    int size;

    public MyDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }


    T deleteHead() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;
        head.previous = null;

        if (head == null) {
            tail = null;
        }
        return data;
    }


    void printReversed() {
        if (tail == null) {
            return;
        }

        Node<T> curr = tail;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.previous;
        }
    }

    void printInOrder() {
        if (head == null) {
            return;
        }

        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.next;
        }
    }

    void addHead(T t) {
        if (t == null) {
            throw new NullPointerException();
        }


        Node<T> added = new Node(t);

        if (head == null) {
            head = added;
            tail = added;

            return;
        } else {
            added.next = head;
            head.previous = added;
            head = added;
        }
    }

    public static void main(String[] args) {

        MyDoubleLinkedList<Integer> dll = new MyDoubleLinkedList<>();

        dll.addHead(1);
        dll.addHead(2);
        dll.addHead(3);
        dll.addHead(4);

        dll.addHead(5);
        dll.printReversed();

    }
}
