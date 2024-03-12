package Queues;

public class ArrayQueue<T> implements MyQueue<T> {

    private T[] array;

    private int size;

    private int capacity;

    public ArrayQueue(int cap) {
        capacity = cap;
        array = (T[]) new Object[cap];
        size = 0;

    }

    @Override
    public void enqueue(T t) {
        if (isFull()) {
            return;
        }
        array[size++] = t;
    }

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = array[0];

        for (int i = 0; i < capacity - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        T data = array[0];
        return data;
    }

    @Override
    public int size() {
        return size;
    }
}
