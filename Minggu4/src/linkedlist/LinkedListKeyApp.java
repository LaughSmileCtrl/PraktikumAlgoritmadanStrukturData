package linkedlist;

class DataLinked {

    DataLinked nextLinked;

    String key; //uniq

    String data;

    public DataLinked(String k, String d, DataLinked next) {
        key = k;
        data = d;
        nextLinked = next;
    }
}

class LinkedListKey {

    private DataLinked head;

    public LinkedListKey() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean isKeyExist(String key) {
        DataLinked tmpDataLinked = head;
        while(tmpDataLinked != null) {
            if(tmpDataLinked.key.equals(key)) {
                return true;
            }

            tmpDataLinked = tmpDataLinked.nextLinked;
        }

        return false;
    }

    public boolean add(String key, String data) {
        if(!isKeyExist(key)) {
            DataLinked tmpDataLinked = new DataLinked(key, data, head);
            head = tmpDataLinked;
            return true;
        }

        return false;
    }

    public boolean delete() {
        if(!isEmpty()) {
            head = head.nextLinked;
            return true;
        }

        return false;
    }

    public boolean delete(String key) {
        if(isKeyExist(key)) {
            DataLinked tmpDataLinked = head;
            while(tmpDataLinked != null) {
                if(tmpDataLinked.key.equals(key)) {
                    head = (tmpDataLinked == head) ? head.nextLinked : head;
                    return true;
                }else if(tmpDataLinked.nextLinked.key.equals(key)) {
                    tmpDataLinked.nextLinked = tmpDataLinked.nextLinked.nextLinked;
                    return true;
                }

                tmpDataLinked = tmpDataLinked.nextLinked;
            }
        }

        return false;
    }
    
    public String findByKey(String key) {
        DataLinked tmpDataLinked = head;
        while(tmpDataLinked != null) {
            if(tmpDataLinked.key.equals(key)) {
                return tmpDataLinked.data;  // datasaya
            }

            tmpDataLinked = tmpDataLinked.nextLinked;
        }

        return null;
    }
    
    public String find(String data) {
        DataLinked tmpDataLinked = head;
        while(tmpDataLinked != null) {
            if(tmpDataLinked.data.equals(data)) {
                return tmpDataLinked.key + " => " + tmpDataLinked.data; // key => datasaya
            }
            
            tmpDataLinked = tmpDataLinked.nextLinked;
        }

        return null;
    }
    
    public String toString() {
        DataLinked tmpDataLinked = head;
        StringBuilder strBuilder = new StringBuilder("[");
        while(tmpDataLinked != null) {
            strBuilder.append(tmpDataLinked.key + " => " + tmpDataLinked.data);
            tmpDataLinked = tmpDataLinked.nextLinked;
            if(tmpDataLinked != null) {
                strBuilder.append(", ");
            }
        }

        strBuilder.append("]");
        return strBuilder.toString();
    }
}

public class LinkedListKeyApp {
    
    public static void main(String[] args) {
        LinkedListKey linkedListKey = new LinkedListKey();
        
        for (int i = 0; i < 5; i++) {
            linkedListKey.add("K0"+i, "buku ke"+i);
        }

        System.out.println(linkedListKey.toString());
        System.out.println(linkedListKey.find("buku ke3"));
        System.out.println(linkedListKey.toString());
        

    }
    
}
