package Stacks;

import java.util.ArrayList;

public class ListStack<T> implements MyStack<T> {

    private ArrayList<T> al;

    private int top;


    public ListStack() {

        al = new ArrayList<>();
        top = -1;
    }

    @Override
    public void push(T t) {
        al.add(++top, t);


    }

    @Override
    public T pop() {
        if (al.isEmpty()) {
            return null;
        }
        return al.get(top--);
    }

    @Override
    public boolean isEmpty() {
        return al.isEmpty();
    }

    @Override
    public int size() {
        return al.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return al.get(top);
    }
}
