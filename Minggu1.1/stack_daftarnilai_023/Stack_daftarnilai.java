package stack_daftarnilai_023;

import java.util.Scanner;

class DaftarNilai {
    public String nama;
    public int nilai;
}

public class Stack_daftarnilai {
    public static void main(String[] args) {
        final int Jumlah = 5;
        Scanner input = new Scanner(System.in);
        String nama;
        DaftarNilai[] data = new DaftarNilai[Jumlah];

        int pencacah = 0;

        while (pencacah < Jumlah) {
            data[pencacah] = new DaftarNilai();

            System.out.println("nama : ");
            data[pencacah].nama = input.nextLine();

            while (true) {
                System.out.println("Nilai (0-100 :");
                data[pencacah].nilai = input.nextInt();
                if ((data[pencacah].nilai >= 0) && (data[pencacah].nilai <= 100))
                    break;
            }
            pencacah = pencacah + 1;

            input.nextLine();
        }
        double jum = 0;
        pencacah = 0;
        while (pencacah < Jumlah) {
            jum = jum + data[pencacah].nilai;
            pencacah = pencacah + 1;
        }
        double rata = jum / 10.0;
        System.out.println("rata-rata = " + rata);

        System.out.println("Siswa yang gagal : ");
        pencacah = 0;
        boolean adagagal = false;
        while (pencacah < Jumlah) {
            if (data[pencacah].nilai < 60) {
                adagagal = true;
                System.out.println(data[pencacah].nama);
            }
            pencacah = pencacah + 1;
        }
        if (!adagagal)
            System.out.println("Tidak Ada");
    }
}