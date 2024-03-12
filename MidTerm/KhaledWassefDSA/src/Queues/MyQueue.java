package Queues;

public interface MyQueue<T> {


    void enqueue(T t);

    T dequeue();

    boolean isEmpty();

    T peek();

    int size();

}
