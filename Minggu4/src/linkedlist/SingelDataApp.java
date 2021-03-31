package linkedlist;

class SingelData {

    int data;

    SingelData next;

    public SingelData(int d, SingelData n) {
        data = d;
        next = n;
    }
}

class LinkedSingelData {

    private SingelData head;

    private int size;

    public LinkedSingelData() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void add(int addData) {
        SingelData tmpSingelData = new SingelData(addData, head);
        head = tmpSingelData;
        size++;
    }

    public int get(int index) {
        if(isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            SingelData tmpSingelData = head;
            int i = 0;
            while(tmpSingelData != null) { 
                if(index == i++) {
                    return tmpSingelData.data;
                }

                tmpSingelData = tmpSingelData.next;
            }

            throw new IndexOutOfBoundsException();
        }
    }
    
    public boolean addAfter(int index, int addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            SingelData tmpSingelData = head;
            for (int i = 0; i < index; i++) {
                tmpSingelData = tmpSingelData.next;
            }

            SingelData addSingelData = new SingelData(addData, tmpSingelData.next);
            tmpSingelData.next = addSingelData;
            return true;
        }
    }
    
    public boolean addBefore(int index, int addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            SingelData tmpSingelData = head;
            for (int i = 0; i < (index-1); i++) {
                tmpSingelData = tmpSingelData.next;
            }

            SingelData addSingelData = new SingelData(addData, null);
            if(tmpSingelData == head) {
                addSingelData.next = head;
                head = addSingelData;
            }else {
                addSingelData.next = tmpSingelData.next;
                tmpSingelData.next = addSingelData;
            }
            return true;
        }
    }
    
    public boolean delete() {
        if(isEmpty()){
            return false;
        }else {
            head = head.next;
            size--;
            return true;
        }
    }
    
    public boolean delete(int index) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            SingelData tmpSingelData = head;
            for (int i = 0; i < (index-1); i++) {
                tmpSingelData = tmpSingelData.next;
            }
            

            tmpSingelData.next = (tmpSingelData.next == null) ? null : tmpSingelData.next.next;
            size--;
            return true;
        }
    }
    
    public int indexOf(int data) {
        if(isEmpty()) {
            return -1;
        } else {
            int index = 0;
            SingelData tmpSingelData = head;
            while(tmpSingelData != null) {
                if(tmpSingelData.data == data) {
                    return index;
                }
                
                index++;
                tmpSingelData = tmpSingelData.next;
            }

            return -1;
        }
    }
    
    public String toString() {
        StringBuilder allData = new StringBuilder("["); // [a,b,c]
        SingelData tmpSingelData = head;
        while(tmpSingelData != null) {
            allData.append(tmpSingelData.data);
            tmpSingelData = tmpSingelData.next;
            if(tmpSingelData != null) {
                allData.append(", ");
            }
        }
        
        allData.append("]");
        return allData.toString();
    }

    public SingelData getHead() {
        return head;
    }
}

public class SingelDataApp {
    
    public static void main(String[] args) {
        LinkedSingelData linkedSingelData = new LinkedSingelData();
        System.out.println(linkedSingelData.isEmpty());
        System.out.println(linkedSingelData.toString());
        
        for (int i = 0; i < 20; i+=3) {
            linkedSingelData.add(i);
        }
        System.out.println(linkedSingelData.toString());
        linkedSingelData.addBefore(3, 2314);
        System.out.println(linkedSingelData.toString());
    }
}
