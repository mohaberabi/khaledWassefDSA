public class PrinterQueue implements MyQueue<PrinterJob> {


    // this impl is based on the binary heap  impl  of prioirty queue "MAX HEAP"
    // for assigning a prioities for data to be stored in the collection in effiecnt way as
    //required in the assignement , max heap is efienct for such problem -> time complexity of
    // the heapify operation is O log of height or size of the tree

    private int size;

    private final PrinterJob[] arr;

    private final int capacity;

    public PrinterQueue(int c) {
        size = 0;
        capacity = c;
        arr = new PrinterJob[c];
    }


    @Override
    public PrinterJob peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[0];
    }

    @Override
    public void enqueue(PrinterJob printerJob) throws IllegalStateException {

        if (size == capacity) {
            throw new IllegalStateException();
        }
        size++;
        arr[size - 1] = printerJob;
        int parent = parent(size - 1);
        int last = size - 1;
        if (arr[parent] != null && arr[last] != null) {
            while (last >= 0 && arr[last].priority > arr[parent].priority) {
                swap(last, parent);
                last--;
                parent = parent(last);
            }
        }

    }

    private void swap(int i, int j) {
        PrinterJob temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // this is the pivot method arround the whole idea of the bi-heap
    private void maxHeapify(int i) {
//get the left index
        int left = left(i);
        // get the right index
        int right = right(i);
        // init largest of the subtree as the current elment
        int largest = i;

        // comparing the 3 elements
        //1- if the left index is not beyond the array bounds and if it has a prioirity larger
        //than the root , then we assign it as the largest
        if (left < size && arr[left].priority > arr[largest].priority) {
            largest = left;
        }
        // 2- we apply same logic made at "1"
        if (right < size && arr[right].priority > arr[largest].priority) {
            largest = right;
        }
        // if any swap has been made this means that bi heap might be violated so we need to do same for the
        //found child "in recursive fashion"
        if (largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }


    //as required in the assi this method needs to be discussed
    @Override
    public PrinterJob dequeue() {
        // is the heap is epmty we need to do nothing
        if (isEmpty()) {
            return null;
        }

        // if the heap has only eleemnt so no need for the heapify

        if (size == 1) {

            // only dcrement size
            size--;
            //and retrun the first element
            return arr[0];
        }
        // but if the heap has more items
        // what we do is we swap it with the last element
        // decrease size and then calling the max heapify to fix the heap
        //finally return the expected element as it was at the last index now

        swap(0, size - 1);
        size--;
        maxHeapify(0);
        return arr[size];
    }

    @Override
    public int size() {
        return size;
    }


    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public PrinterJob rear() {

        //lowest priority item is always the last item
        if (isEmpty()) {
            return null;
        }
        return arr[size - 1];
    }

    public static void main(String[] args) {

        PrinterQueue pq = new PrinterQueue(100);
        pq.enqueue(new PrinterJob("University", 0));
        pq.enqueue(new PrinterJob("Anything related to university", 1));
        pq.enqueue(new PrinterJob("Coding or anything related to coding", Integer.MAX_VALUE));

        System.out.println("Printing the jobs based on their priorities from the maximum to lowest");

        while (!pq.isEmpty()) {
            PrinterJob pjob = pq.dequeue();
            System.out.println(pjob);
        }

    }
}
