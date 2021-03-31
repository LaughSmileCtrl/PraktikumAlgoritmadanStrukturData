package queue023;

class CircleQueue {

    private String[] data;

    private int size;

    private int head;

    private int tail;

    public CircleQueue(int s) {
        this.size = s;
        this.data = new String[s];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty() {
        return data[head] == null;
    }

    public boolean isFull() {
        int tmpNextTail = (tail == size) ? 0 : tail;
        return data[tmpNextTail] != null;
    }

    public boolean add(String addData) {
        if(isFull()) {
            return false;
        }else {
            data[tail] = addData;
            tail = (tail == (size-1)) ? 0 : (tail+1);
            return true;
        }
    }

    public String poll() {
        if(isEmpty()) {
            return null;
        }else {
            String tmpData = data[head];
            data[head] = null;
            head = (head == (size-1)) ? 0 : (head+1);
            return tmpData;
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}

public class CircleQueueApp {
    
    public static void main(String[] args) {
        CircleQueue cQueue = new CircleQueue(4);

        System.out.println("Head : " + cQueue.getHead());
        System.out.println("Tail : " + cQueue.getTail());
        System.out.println(cQueue.add("pisang"));
        System.out.println(cQueue.add("mangga"));
        System.out.println(cQueue.add("rambutan"));
        System.out.println(cQueue.add("semangka"));
        System.out.println("Head : " + cQueue.getHead());
        System.out.println("Tail : " + cQueue.getTail());
        System.out.println(cQueue.poll());
        System.out.println(cQueue.poll());
        System.out.println("Head : " + cQueue.getHead());
        System.out.println("Tail : " + cQueue.getTail());
        System.out.println(cQueue.add("buah baru"));
        System.out.println(cQueue.add("buah pendatang"));
        System.out.println("Head : " + cQueue.getHead());
        System.out.println("Tail : " + cQueue.getTail());



    }
}
