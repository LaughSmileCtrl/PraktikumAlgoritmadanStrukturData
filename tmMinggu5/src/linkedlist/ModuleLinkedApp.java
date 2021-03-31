package linkedlist;

class StringNode {

    String data;

    StringNode next;

    public StringNode(String d, StringNode n) {
        data = d;
        next = n;
    }
}

class ModuleLinked {

    private StringNode head;

    private int size;

    public ModuleLinked() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void add(String addData) {
        StringNode tmpSingelData = new StringNode(addData, head);
        head = tmpSingelData;
        size++;
    }

    public String get(int index) {
        if(isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            StringNode tmpSingelData = head;
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
    
    public boolean addAfter(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            StringNode tmpSingelData = head;
            for (int i = 0; i < index; i++) {
                tmpSingelData = tmpSingelData.next;
            }

            StringNode addSingelData = new StringNode(addData, tmpSingelData.next);
            tmpSingelData.next = addSingelData;
            return true;
        }
    }
    
    public boolean addBefore(int index, String addData) {
        if(isEmpty() || index >= size || index < 0) {
            return false;
        }else {
            StringNode tmpSingelData = head;
            for (int i = 0; i < (index-1); i++) {
                tmpSingelData = tmpSingelData.next;
            }

            StringNode addSingelData = new StringNode(addData, null);
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
            StringNode tmpSingelData = head;
            for (int i = 0; i < (index-1); i++) {
                tmpSingelData = tmpSingelData.next;
            }
            

            tmpSingelData.next = (tmpSingelData.next == null) ? null : tmpSingelData.next.next;
            size--;
            return true;
        }
    }
    
    public int indexOf(String data) {
        if(isEmpty()) {
            return -1;
        } else {
            int index = 0;
            StringNode tmpSingelData = head;
            while(tmpSingelData != null) {
                if(tmpSingelData.data.equals(data)) {
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
        StringNode tmpSingelData = head;
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

    public String findAtFirstChar(char prefix) {
        StringBuilder allData = new StringBuilder("["); // [a,b,c]
        StringNode tmpSingelData = head;
        int size = 0;
        while(tmpSingelData != null) {
            String valueNode = tmpSingelData.data;
            if(valueNode.charAt(0) == prefix) {
                allData.append(tmpSingelData.data);
                size++;
            }

            tmpSingelData = tmpSingelData.next;
            if((tmpSingelData != null) && (tmpSingelData.data.charAt(0) == prefix) && size >= 1) {
                allData.append(", ");
            }
        }
        
        allData.append("]");
        return allData.toString();
    }

    public String findAtLastChar(char suffix) {
        StringBuilder allData = new StringBuilder("["); // [a,b,c]
        StringNode tmpSingelData = head;
        int size = 0;
        while(tmpSingelData != null) {
            String valueNode = tmpSingelData.data;
            int lastIndex = valueNode.length() - 1;
            if(valueNode.charAt(lastIndex) == suffix) {
                allData.append(tmpSingelData.data);
                size++;
            }

            tmpSingelData = tmpSingelData.next;
            if(tmpSingelData != null) {
                lastIndex = tmpSingelData.data.length() - 1;
                if((tmpSingelData.data.charAt(lastIndex) == suffix) && size >= 1) {
                    allData.append(", ");
                }
            }
        }
        
        allData.append("]");
        return allData.toString();
    }
}

public class ModuleLinkedApp {
    
    public static void main(String[] args) {
        ModuleLinked linkedSingelData = new ModuleLinked();
        linkedSingelData.add("Saya");
        linkedSingelData.add("Aku");
        linkedSingelData.add("Adalah");
        linkedSingelData.add("Orang");
        linkedSingelData.add("Asia");
        linkedSingelData.add("Asli");
        linkedSingelData.add("Dari");
        linkedSingelData.add("Sini");
        linkedSingelData.add("Sampai");
        linkedSingelData.add("Kini");
        System.out.println(linkedSingelData.toString());
        System.out.println(linkedSingelData.findAtFirstChar('A'));
        System.out.println(linkedSingelData.findAtLastChar('i'));
    }
}
