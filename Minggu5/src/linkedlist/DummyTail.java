class SingelDataDT {

    String data;

    SingelDataDT next;

    public SingelDataDT(String d, SingelDataDT n) {
        data = d;
        next = n;
    }
}

class LinkedSingelDataDT {

    private SingelDataDT head;

    private SingelDataDT tail;

    private int size;

    public LinkedSingelDataDT() {
        head = new SingelDataDT(null, tail);
        tail = new SingelDataDT(null, null);
        size = 0;
    }
    
    public boolean isEmpty() {
        return (head.next == tail);
    }
    
    public void add(String addData) {
        SingelDataDT tmpSingelData = new SingelDataDT(addData, head.next);
        head.next = tmpSingelData;
        size++;
    }

    public void addLast(String addData) {
        SingelDataDT tmpSingelData = new SingelDataDT(addData, tail);
        getNode(0).next = tmpSingelData;
        size++;
    }


    public SingelDataDT getNode(int index) {
        if(isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            SingelDataDT tmpSingelData = head.next;
            int i = size - 1;
            while(tmpSingelData != null) { 
                if(index == i--) {
                    return tmpSingelData;
                }

                tmpSingelData = tmpSingelData.next;
            }

            throw new IndexOutOfBoundsException();
        }
    }

    public String get(int index) {
        return getNode(index).data;
    }
    
    public boolean addAfter(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            if(index == size-1) {
                add(addData);
            }else {
                SingelDataDT tmpNode = getNode(index + 1);
                SingelDataDT insertNode = new SingelDataDT(addData, getNode(index));
                tmpNode.next = insertNode;
            }

            size++;
            return true;
        }
    }
    
    public boolean addBefore(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
           SingelDataDT insertNode = new SingelDataDT(addData, getNode(index).next);
           getNode(index).next = insertNode;
           size++;
           return true;
        }
    }
    
    public boolean delete() {
        if(isEmpty()){
            return false;
        }else {
            head.next = head.next.next;
            size--;
            return true;
        }
    }
    
    public boolean delete(int index) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            if(index == (size-1)) {
                delete();
            }else {
                getNode(index+1).next = getNode(index).next;
            }
            size--;
            return true;
        }
    }
    
    public int indexOf(String data) {
        if(isEmpty()) {
            return -1;
        } else {
            int index = size-1;
            SingelDataDT tmpSingelData = head.next;
            while(tmpSingelData != null) {
                if(tmpSingelData.data.equals(data)) {
                    return index;
                }
                
                index--;
                tmpSingelData = tmpSingelData.next;
            }

            return -1;
        }
    }
    
    public String toString() {
        StringBuilder allData = new StringBuilder("["); // [a,b,c]
        for (int i = 0; i < size; i++) {
            allData.append(get(i));
            if(i <= size-2) {
                allData.append(", ");
            }
        }
        
        allData.append("]");
        return allData.toString();
    }

    public SingelDataDT getHead() {
        return head;
    }
}

public class DummyTail {
    
    public static void main(String[] args) {
        LinkedSingelDataDT linkedSingelData = new LinkedSingelDataDT();
        String[] tmpArr = {"apa", "coba", "kamu", "smile", "always", "saja"};
        for (String str : tmpArr) {
            linkedSingelData.add(str);
        }
        
        System.out.println(linkedSingelData.toString());
        linkedSingelData.addLast("inidatabaru");
        linkedSingelData.addLast("inidatabaru2");
        System.out.println(linkedSingelData.toString());
        // System.out.println(linkedSingelData.indexOf("inidatabaru2"));
        System.out.println(linkedSingelData.toString());

    }
}
