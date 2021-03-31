import java.util.LinkedList;

class LinkedSort {

    LinkedList<String> linkedList;

    public LinkedSort() {
        linkedList = new LinkedList<String>();
    }

    public boolean add(String addData) {
        
        for (int i = 0; i < linkedList.size(); i++) {
            if(linkedList.get(i).compareTo(addData) > 0) {
                linkedList.add(i, addData);
                return true;
            }
        }

        linkedList.add(addData);
        return true;
    }

    public String toStringAsc() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < linkedList.size(); i++) {
            str.append(linkedList.get(i));
            if(i < linkedList.size() - 1) {
                str.append(", ");
            }
        }

        str.append("]");
        return str.toString();
    }

    public String toStringDesc() {
        StringBuilder str = new StringBuilder("[");
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            str.append(linkedList.get(i));
            if(i > 0) {
                str.append(", ");
            }
        }

        str.append("]");
        return str.toString();
    }

    public LinkedList getLinkedList() {
        return linkedList;
    }

}

public class DummyLib {

    public static void main(String[] args) {
        
        LinkedSort linkedSort = new LinkedSort();

        String tmpCoba = "FGEHDIBA";
        
        for (int i = 0; i < tmpCoba.length(); i++) {
            linkedSort.add("" + tmpCoba.charAt(i));
        }

        System.out.println(linkedSort.toStringAsc());
        System.out.println(linkedSort.toStringDesc());
    }

}