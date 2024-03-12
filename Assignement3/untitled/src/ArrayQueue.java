public class ArrayQueue implements MyQueue<Integer> {

    // the idea of abstraction as we will need same methods in the next question

    int front;
    int cap;
    int size;
    int[] arr;


    ArrayQueue(int n) {
        front = 0;
        size = 0;
        cap = n;
        arr = new int[n];
    }


    @Override
    public Integer peek() {
        return arr[front];
    }

    @Override
    public void enqueue(Integer x) {
        if (isFull()) {
            return;
        }
        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = x;
        size++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % cap;
        size--;
        return arr[front];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer rear() {
        if (isEmpty()) {
            return null;
        }
        return arr[(front + size - 1) % cap];
    }

    boolean isFull() {
        return cap == size;
    }


    int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return (front + size - 1) % cap;
    }

    public static void main(String[] args) {


        ArrayQueue arrayQueue = new ArrayQueue(100);

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(1000);
        arrayQueue.enqueue(200);
        arrayQueue.enqueue(-10);

        System.out.println("Top of queeu " + arrayQueue.peek());
        System.out.println("Rear of queue " + arrayQueue.rear());
    }
}
