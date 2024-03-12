package Stacks;


public class LinkedStack<T> implements MyStack<T> {
    private class LinkedNode<T> {


        LinkedNode<T> next;
        T data;


        public LinkedNode(T t) {
            data = t;
            next = null;
        }
    }

    private LinkedNode<T> head;

    private int size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(T t) {

        LinkedNode<T> adeed = new LinkedNode<>(t);
        if (head == null) {
            head = adeed;
        } else {
            adeed.next = head;
            head = adeed;
        }
        size++;
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        T data = head.data;

        head = head.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }
}
