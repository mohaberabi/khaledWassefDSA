public interface MyQueue<T> {


    T peek();

    void enqueue(T t);

    T dequeue();

    int size();

    boolean isEmpty();

    T rear();
}
