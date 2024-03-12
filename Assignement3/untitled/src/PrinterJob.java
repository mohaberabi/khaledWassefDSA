public class PrinterJob {

    public String name;
    public int priority;

    public PrinterJob(String n, int p) {
        name = n;
        priority = p;
    }

    @Override
    public String toString() {

        return "job to be printed is ->" + " " + name + "Having A priority" + " " + priority;
    }
}
