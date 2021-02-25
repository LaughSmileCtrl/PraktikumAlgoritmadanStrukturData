import java.util.Scanner;

class Item {
    String id;
    String name;
    int price;
    int quantity;
}

public class ItemRecorder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan banyak barang (MAKS 50): ");
        int n = scan.nextInt();
        if(n < 0 || n > 50) {
            System.out.println("Di luar jangkauan");
        } else {
            Item[] items = new Item[n];

            for (int i = 0; i < items.length; i++) {
                items[i] = new Item();
                System.out.print("Masukkan kode barang " + (i+1) + " : ");
                items[i].id = scan.next();
                scan.nextLine();
                System.out.print("Masukkan nama barang " + (i+1) + " : ");
                items[i].name = scan.nextLine();
                System.out.print("Masukkan harga barang " + (i+1) + " : ");
                items[i].price = scan.nextInt();
                System.out.print("Masukkan banyak barang " + (i+1) + " : ");
                items[i].quantity = scan.nextInt();
            }

            long totalPrice = 0;
            long totalItem = 0;
            int i = 0;
            System.out.printf("| %2s | %12s | %15s | %12s | %5s |\n", "no", "kode barang", "nama barang", "harga", "total");
            for (Item item : items) {
                String tmpName = (item.name.length() > 15) ? item.name.substring(0, 15) : item.name;
                System.out.printf("| %2s | %12s | %15s | %,12d | %5s |\n", ++i, item.id, tmpName, item.price, item.quantity);
                totalPrice += item.price;
                totalItem += item.quantity;
            }

            System.out.println("\tTotal barang " + totalItem);
            System.out.printf("\t Rata-rata harga barang %,d\n" , (totalPrice/n));
        }

        scan.close();
    }
    
}