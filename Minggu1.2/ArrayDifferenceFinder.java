import java.util.Scanner;

public class ArrayDifferenceFinder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah element array pertama : ");
        int n = scan.nextInt();
        String[] firstData = new String[n];
        for (int i = 0; i < firstData.length; i++) {
            System.out.print("Masukkan data Array pertama ke-" + i + " : ");
            firstData[i] = scan.next();
        }

        System.out.print("Masukkan jumlah element array kedua : ");
        n = scan.nextInt();
        String[] secondData = new String[n];
        for (int i = 0; i < secondData.length; i++) {
            System.out.print("Masukkan data Array kedua ke-" + i + " : ");
            secondData[i] = scan.next();
        }

        for (String data : firstData) {
            boolean isExist = false;
            for (int i = 0; i < secondData.length; i++) {
                if(data.equals(secondData[i])) {
                    isExist = true;
                    break;
                }
            }

            if(!(isExist)) {
                System.out.println(data);
            }
        }

        scan.close();
    }
}