package queue023;

import java.util.ArrayDeque;

public class QueueLib {
    
    public static void main(String[] args) {
        ArrayDeque<String> data = new ArrayDeque<String>();
        System.out.println(data.add("AAA"));
        System.out.println(data.add("BBB"));
        System.out.println(data.add("CCC"));
        System.out.println(data.add("DDD"));
        System.out.println(data.add("EEE"));
        System.out.println(data.add("FFF"));
        System.out.println(data.add("GGG"));
        System.out.println(data.isEmpty());

        while(!(data.isEmpty())) {
            System.out.println(data.poll());
        }

        System.out.println(data.isEmpty());

    }
}
