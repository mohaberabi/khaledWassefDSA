package Stacks;

public interface MyStack<T> {


    void push(T t);

    T pop();

    boolean isEmpty();

    int size();

    T peek();
}
