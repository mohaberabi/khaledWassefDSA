package LinkedList;

public class MyLinkedList<T> {


    private Node<T> head;
    private int size;


    public MyLinkedList() {
        size = 0;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void addHead(T t) {

        if (t == null) {
            throw new NullPointerException("LINKED LIST DOES NOT SUPPORT NULLS");
        }
        Node<T> added = new Node<>(t);

        if (head == null) {
            head = added;
        } else {
            added.next = head;
            head = added;
        }
        size++;
    }


    public void print() {
        if (head == null) {
            return;
        }
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.next;
        }
    }


    public T find(T data) {


        if (head == null) {
            return null;
        }

        if (data == null) {
            throw new NullPointerException("LINKED LIST DOES NOT SUPPORT NULLS");
        }

        Node<T> curr = head;
        while (curr != null) {
            if (curr.data.equals(data)) {
                return curr.data;
            }
            curr = curr.next;
        }
        return null;
    }


    public T delete(T t) {
        if (head == null) {
            return null;
        }
        if (t == null) {
            throw new NullPointerException("LINKED LIST DOES NOT SUPPORT NULLS");
        }
        if (head.data.equals(t)) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                if (curr.next.data.equals(t)) {
                    T data = curr.next.data;
                    curr.next = curr.next.next;
                    size--;
                    return data;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    public T deleteHead() {
        if (head == null) {
            return null;
        } else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

}
