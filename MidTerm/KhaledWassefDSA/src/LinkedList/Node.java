package LinkedList;

public class Node<T> {


    public Node<T> next;
    public Node<T> previous;

    public T data;

    public Node(T t) {
        data = t;
        previous = null;
        next = null;
    }
}
