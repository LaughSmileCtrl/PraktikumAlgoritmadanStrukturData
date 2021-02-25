package array3_023;

import java.util.Scanner;

public class Array3 {

    public static void main(String[] args) {
        double[] data = new double[5];
        int i, jum_data;

        Scanner in = new Scanner(System.in);
        jum_data = 5;
        for (i = 0; i < data.length; i++) {
            System.out.println("inputkan data : ");
            data[i] = in.nextDouble();
            // in.nextLine()

        }

        for (i = 0; i < jum_data; i++) {
            System.out.println(data[i]);
        }
    }
}