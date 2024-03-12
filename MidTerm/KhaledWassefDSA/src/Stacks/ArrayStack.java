package Stacks;

public class ArrayStack<T> implements MyStack<T> {

    private int top;
    private T[] array;
    private int cap;
    private int size;


    public ArrayStack(int n) {
        top = -1;
        array = (T[]) new Object[n];
        size = 0;
        cap = n;
    }

    public ArrayStack() {
        top = -1;
        array = (T[]) new Object[10];
        size = 0;
        cap = 10;
    }

    @Override
    public void push(T t) {

        if (isFull()) {
            throw new StackOverflowError();
        } else {
            array[++top] = t;
            size++;
        }

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            size--;
            return array[top--];
        }


    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return size == cap;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {

        if (isEmpty()) {
            return null;
        } else {
            return array[top];
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> s = new ArrayStack<>();
    }
}
