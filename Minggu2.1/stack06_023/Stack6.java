package stack06_023;

import java.util.Scanner;
import java.util.Stack;

public class Stack6 {


    public static void main(String[] args) {
        int n = 5;
        Stack<String> stack = new Stack<String>();
        Scanner scan = new Scanner(System.in);
        String userInput;
        System.out.println("input barang : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan Barang ke " + (i+1) + " : ");
            userInput = scan.nextLine();
            stack.push(userInput);
        }

        String toContinue;
        do {
            System.out.println("\n\tList barang : " + stack.toString() + "\n\n");
            System.out.println("Menu");
            System.out.println("1. Ambil barang");
            System.out.println("2. pindah barang keatas");
            System.out.println("3. pindah barang kebawah");
            System.out.print("Pilihan : ");
            int choice = scan.nextInt();
            scan.nextLine();
            int indexInput;
            int indexInput2;
            String nextString;

            switch(choice) {
                case 1 :
                    System.out.print("Masukkan nama barang yang ingin diambil : ");
                    userInput = scan.nextLine();
                    indexInput = stack.indexOf(userInput);
                    if(indexInput >= 0){
                        System.out.println("Nama barang yang akan dihapus adalah " + stack.remove(indexInput));
                        System.out.println("Barang tersebut berada di nomor " + indexInput + " dari bawah");
                    } else {
                        System.err.println("\nBarang tersebut tidak dapat ditemukan");
                    }
                    break;
                case 2 :
                    System.out.print("Nama barang yang ingin dipindah : ");
                    userInput = scan.nextLine();
                    indexInput = stack.indexOf(userInput);
                    if(indexInput < 0) {
                        System.out.println("\nBarang tidak dapat ditemukan");
                        break;
                    }

                    System.out.print("Dipindahkan di atas nama barang : ");
                    nextString = scan.nextLine();
                    indexInput2 = stack.indexOf(nextString);
                    if(indexInput2 >= 0) {
                        stack.remove(indexInput);
                        stack.insertElementAt(userInput, indexInput2+1);
                    } else {
                        System.out.println("\nBarang tidak dapat di temukan");
                    }
                    break;
                case 3 :
                    System.out.print("Nama barang yang ingin dipindah : ");
                    userInput = scan.nextLine();
                    indexInput = stack.indexOf(userInput);
                    if(indexInput < 0) {
                        System.out.println("\nBarang tidak dapat ditemukan");
                        break;
                    }

                    System.out.print("Dipindahkan di bawah nama barang : ");
                    nextString = scan.nextLine();
                    indexInput2 = stack.indexOf(nextString);
                    if(indexInput2 >= 0) {
                        stack.remove(indexInput);
                        stack.insertElementAt(userInput, indexInput2);
                    } else {
                        System.out.println("\nBarang tidak dapat di temukan");
                    }
                    break;
                default:
                    System.err.println("Command Not Found!!");
            }

            System.out.println("\n\tList barang : " + stack.toString() + "\n\n");

            System.out.print("Lanjut?(y/n) : ");
            toContinue = scan.next();

        }while(toContinue.equalsIgnoreCase("y"));
    }
    
}
