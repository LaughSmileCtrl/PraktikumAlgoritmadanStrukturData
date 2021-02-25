package array_dua2_023;

import java.util.Scanner;

public class Array_dua2 {

    public static void main(String[] args) {
        Scanner ardu = new Scanner(System.in);

        System.out.println("Jumlah baris : ");
        int jumbaris = ardu.nextInt();

        System.out.println("Jumlah kolom : ");
        int jumkolom = ardu.nextInt();

        int i, j;
        double[][] data = new double[jumbaris][jumkolom];
        for (i = 0; i < jumbaris; i++) {
            for (j = 0; j < jumkolom; j++) {
                System.out.printf("baris %d, kolom %d : ", i, j);
                data[i][j] = ardu.nextDouble();
            }
        }

        System.out.println("Matriks yang terbentuk ");
        for (i = 0; i < jumbaris; i++) {
            for (j = 0; j < jumkolom; j++) {
                System.out.printf("%10.2g", data[i][j]);
            }
            System.out.println();
        }

    }
}