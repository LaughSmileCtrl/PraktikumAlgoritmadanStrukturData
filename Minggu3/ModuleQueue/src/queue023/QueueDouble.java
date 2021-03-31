package queue023;

import java.util.Scanner;
import java.util.ArrayDeque;

public class QueueDouble {
    
    public static void main(String[] args) {
        ArrayDeque<Double> qDoubles = new ArrayDeque<Double>();
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Mau berapa banyak data? ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan data ke " + i + " : ");
            double tmp = scan.nextDouble();
            qDoubles.add(tmp);
        }

        System.out.println(qDoubles.isEmpty());
        for (int i = 0; i < n; i++) {
            System.out.println(qDoubles.poll());
        }
        
        System.out.println(qDoubles.isEmpty());
    }
}
