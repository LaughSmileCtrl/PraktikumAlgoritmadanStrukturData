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

    public String get(int index) {
        return getNode(index).data;
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
    
    public boolean addBefore(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            SingelData tmpSingelData = getNode(index);

            SingelData addSingelData = new SingelData(addData, tmpSingelData.next);
            tmpSingelData.next = addSingelData;
            size++;
            return true;
        }
    }
    
    public boolean addAfter(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            SingelData tmpSingelData = getNode(index);
            SingelData addSingelData = new SingelData(addData, tmpSingelData);
            if(index == (size-1)) {
                head.next = addSingelData;
            }else {
                getNode(index+1).next = addSingelData;
            }

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
                head.next = head.next.next;
            }else {
                SingelData tmpSingelData = getNode(index+1);
                tmpSingelData.next = tmpSingelData.next.next;
            }
            
            size--;
            return true;
        }
    }
    
    public int indexOf(String data) {
        if(isEmpty()) {
            return -1;
        } else {
            int index = size - 1;
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
            if(i < (size-1)) {
                allData.append(", ");
            }
        }
        
        allData.append("]");
        return allData.toString();
    }

}

public class SingelDataApp {
    
    public static void main(String[] args) {
        LinkedSingelData linkedSingelData = new LinkedSingelData();
        System.out.println(linkedSingelData.isEmpty());
        System.out.println(linkedSingelData.toString());

        String[] strArry = {"nama", "aaa", "bbbb", "cccc", "ddd"};

        for (String str : strArry) {
            linkedSingelData.add(str);
        }

        System.out.println(linkedSingelData.getNode(4).data);
        System.out.println(linkedSingelData.getNode(3).data);
        System.out.println(linkedSingelData.getNode(2).data);
        System.out.println(linkedSingelData.getNode(1).data);
        linkedSingelData.addBefore(2, "addData");
        linkedSingelData.addBefore(0, "addData3");
        System.out.println(linkedSingelData.getNode(0).data);

        System.out.println(linkedSingelData.toString());
        linkedSingelData.delete(0);
        linkedSingelData.delete(30);
        linkedSingelData.delete(40);
        System.out.println(linkedSingelData.toString());
    }
}
