class SingelData {

    String data;

    SingelData next;

    public SingelData(String d, SingelData n) {
        data = d;
        next = n;
    }
}

class LinkedSingelData {

    private SingelData head;

    private int size;

    public LinkedSingelData() {
        head = new SingelData(null, null);
        size = 0;
    }
    
    public boolean isEmpty() {
        return (head.next == null);
    }
    
    public void add(String addData) {
        SingelData tmpSingelData = new SingelData(addData, head.next);
        head.next = tmpSingelData;
        size++;
    }


    public SingelData getNode(int index) {
        if(isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            SingelData tmpSingelData = head.next;
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
                SingelData tmpNode = getNode(index + 1);
                SingelData insertNode = new SingelData(addData, getNode(index));
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
           SingelData insertNode = new SingelData(addData, getNode(index).next);
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
            SingelData tmpSingelData = head.next;
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

    public SingelData getHead() {
        return head;
    }
}

public class SingelDataApp {
    
    public static void main(String[] args) {
        LinkedSingelData linkedSingelData = new LinkedSingelData();
        System.out.println(linkedSingelData.isEmpty());
        System.out.println(linkedSingelData.toString());
        
        String[] tmpArr = {"apa", "coba", "kamu", "smile", "always", "saja"};

        for (String str : tmpArr) {
            linkedSingelData.add(str);
        }
        
        System.out.println(linkedSingelData.toString());
        linkedSingelData.delete();
        linkedSingelData.delete(3);
        System.out.println(linkedSingelData.toString());

    }
}
