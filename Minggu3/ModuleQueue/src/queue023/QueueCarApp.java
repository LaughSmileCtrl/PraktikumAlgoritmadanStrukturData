package queue023;

import java.util.ArrayDeque;
import java.util.Scanner;

class CarInformation {  // struck, karena di Java gaada struck, jadi kita pakai class

    String nopol;

    String tipe;

    String warna;

}

public class QueueCarApp {
    
    public static void main(String[] args) {
        ArrayDeque<CarInformation> cars = new ArrayDeque<CarInformation>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Mau berapa data? ");
        int n = scan.nextInt();
        scan.nextLine();

        System.out.println("Memasukkan data");
        System.out.println("---------------");
        for (int i = 0; i < n; i++) {
            CarInformation carInfoTmp = new CarInformation();

            System.out.println("data ke " + i);
            System.out.println("----------------");
            System.out.print("\tMasukkan nopol mobil ke " + i + " : ");
            carInfoTmp.nopol = scan.nextLine();
            System.out.print("\tMasukkan tipe mobil ke " + i + " : ");
            carInfoTmp.tipe = scan.nextLine();
            System.out.print("\tMasukkan warna mobil ke " + i + " : ");
            carInfoTmp.warna = scan.nextLine();

            cars.add(carInfoTmp);
        }

        int i = 0;
        while(!(cars.isEmpty())) {
            CarInformation carInfo = cars.poll();

            System.out.println("Informasi mobil ke " + i);
            System.out.println("------------------------");
            System.out.println("\tNopol Mobil ke " + i + " : " + carInfo.nopol);
            System.out.println("\tTipe Mobil ke " + i + " : " + carInfo.tipe);
            System.out.println("\tWarna Mobil ke " + i + " : " + carInfo.warna);

            i++;
        }
        

    }
}
