package queue023;

class QueueMaker {

    private String[] data;

    private int size;

    private int tail;

    public QueueMaker(int s) {
        size = s;
        data = new String[s];
        tail = 0;
    }

    public boolean isEmpty() {
        return data[0] == null;
    }

    public boolean isFull() {
        return tail == size;
    }

    public boolean add(String addData) {
        if(isFull()) {
            return false; // gagal menambah data
        }else {
            data[tail++] = addData;
            return true; // berhasil memabah data
        }
    }

    public String poll() {
        if(isEmpty()) {
            return null;
        }else {
            String tmpData = data[0];
            data[0] = null;
            for (int i = 0; i < (tail-1); i++) {
                data[i] = data[(i+1)];
                data[(i+1)] = null;
            }
            tail--;
            return tmpData;
        }
    }

    public String peek() { // melihat element pertama pada antrian
        if(isEmpty()) {
            return null;
        }else {
            return data[0];
        }
    }
}

public class QueueApp {
    
    public static void main(String[] args) {
        QueueMaker qMaker = new QueueMaker(3);

        System.out.println(qMaker.add("data 1"));
        System.out.println(qMaker.add("data 2"));
        System.out.println(qMaker.add("data 3"));
        System.out.println(qMaker.add("data 4"));

        System.out.println("------------");
        System.out.println(qMaker.peek());

        System.out.println("Apakah full?" + qMaker.isFull());
        System.out.println("Apakah kosong?" + qMaker.isEmpty());

        System.out.println(qMaker.poll());
        System.out.println(qMaker.poll());


        System.out.println("data paling awal " + qMaker.peek());

        System.out.println("Apakah full?" + qMaker.isFull());
        System.out.println("Apakah kosong?" + qMaker.isEmpty());


        
    }
}
