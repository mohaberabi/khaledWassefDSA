package Queues;

public class ArrayQueueOptimal<T> implements MyQueue<T> {


    private int front;
    private int size;

    private T[] array;
    private int cap;

    public ArrayQueueOptimal(int n) {
        cap = n;

        front = 0;
        size = 0;
        array = (T[]) new Object[n];
    }

    @Override
    public void enqueue(T t) {
        if (isFull()) {
            return;

        }

        int rear = getRear();
        rear = (rear + 1) % cap;
        array[rear] = t;

        size++;


    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = array[front];
        front = (front + 1) % cap;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private boolean isFull() {
        return size == cap;
    }

    @Override
    public T peek() {

        if (isEmpty()) {
            return null;
        }
        return array[front];
    }


    private int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return (front + size - 1) % cap;
    }

    @Override
    public int size() {
        return size;
    }
}
