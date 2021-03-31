package linkedlist;

import java.util.LinkedList; // untuk menggunakan library

public class LinkedListLibApp {

    public static void main(String[] args) {
        LinkedList<Character> linked = new LinkedList<Character>();
        String str = "ini adalah percobaaan linked dengan library";

        for (int i = 0; i < str.length(); i++) {
            linked.add(str.charAt(i));
        }

        System.out.println(linked.indexOf('i'));
        linked.add(1,'9');
        System.out.println(linked);
    }
    
}
