package stack02_023;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class StackChar {

    private int size;

    private char[] data;

    private int top;

    public StackChar() {
        this.size = 10;
        this.data = new char[size];
        this.top = 0;
    }

    public boolean isFull() {
        return (top >= size);
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    private void resizeStack() {
        size = size + 10;
        char[] tmpData = Arrays.copyOf(data, data.length);
        data = new char[size];
        System.arraycopy(tmpData, 0, data, 0, tmpData.length);
    }

    public void push(char addData) {
        if(isFull()) {
            resizeStack();
        } 
        
        data[top++] = addData;
    }

    public char pop() {
        if(isEmpty()) {
            System.err.println("Stack is empty");
            return '\0';
        } else {
            return data[--top];
        }
    }

    public int indexOf(char find) {
        for (int i = 0; i < top; i++) {
            if(data[i] == find) {
                return i;
            }
        }
        return -1;
    }

    public char getByIndex(int index) {
        if (data[index] != '\0') {
            return data[index];
        }

        return '\0';
    }

    public void insertElementAt(char obj, int index) {
        if(index >= 0) {
            char tmp = data[index];
            char tmp2;
            data[index] = obj;
            top++;
            if(top >= data.length) {
                resizeStack();
            }

            for (int i = (index+1); i < data.length; i++) {
                tmp2 = data[i];
                data[i] = tmp;
                tmp = tmp2;
            }
        }
    }

    public void remove(int index) {
        if(index >= 0 && index < data.length) {
            for (int i = index; i < (data.length-1); i++) {
                data[i] = data[i+1];
            }
        }
    }

    public char[] getAll() {
        if(isEmpty()) {
            return new char[1];
        } else {
            char[] tmpResult = new char[top];
            int i = 0;
            for(char a : Arrays.copyOf(data, top)) {
                tmpResult[i++] = a;
            }

            return tmpResult;
        }
    }
    
    public char[] getAllReverse() {
        if(isEmpty()) {
            return new char[1];
        } else {
            char[] tmpResult = new char[top];
            int i, j;
            for (i = (tmpResult.length - 1), j = 0; i >= 0; i--, j++) {
                tmpResult[i] = data[j];
            }

            return tmpResult;
        }
    }

    public char[] getAllRandom() {
        if(isEmpty()) {
            return new char[1];
        } else {
            Random random = new Random();
            int[] indexs = new int[top];
            char[] tmpResult = new char[top];
    
            for (int i = 0; i < indexs.length; i++) {
                int tmp;
                boolean isExist;
                do {
                    tmp = random.nextInt(top);
                    isExist = false;
                    for (int j = 0; j < i; j++) {
                        if(indexs[j] == tmp) {
                            isExist = true;
                            break;
                        }
                    }
                } while(isExist);
    
                indexs[i] = tmp;
                tmpResult[i] = data[tmp];
            }

            return tmpResult;
        }
    }

    public char peek() {
        if(isEmpty()) {
            System.err.println("Stack is empty");
            return '\0';
        } else {
            return data[(top-1)];
        }
    }
}

public class StackString {
    
    public static void main(String[] args) {
        StackChar stackChar = new StackChar();
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah data : ");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Masukkan karakter ke " + i + " : ");
            char addData = scan.next().charAt(0);
            stackChar.push(addData);
        }

        boolean isRepeat = true;
        do {
            System.out.println("\n\tList data");
            System.out.println("\n\t" + Arrays.toString(stackChar.getAll()) + "\n");
            System.out.println("Menu");
            System.out.println("1. Tambah data");
            System.out.println("2. Ambil data teratas");
            System.out.println("3. Lihat data sesuai index");
            System.out.println("4. Lihat index data");
            System.out.println("5. pindah barang keatas");
            System.out.println("6. pindah barang kebawah");
            System.out.println("7. Keluar");
            System.out.print("Pilihan : ");
            n = scan.nextInt();

            char findData;
            char findData2;
            int index;
            int index2;
            switch (n) {
                case 1:
                    System.out.print("\n\tMasukkan data : ");
                    char addData = scan.next().charAt(0);
                    stackChar.push(addData);
                    System.out.println("\n\tMemasukkan data " + stackChar.peek());
                    break;
                case 2:
                    if(!(stackChar.isEmpty())) {
                        System.out.println("\n\tMengambil data : " + stackChar.pop());
                    }else {
                        System.out.println("\n\tStack kosong");
                    }
                    break;
                case 3:
                    System.out.print("\n\tMasukkan index : ");
                    n = scan.nextInt();
                    findData = stackChar.getByIndex(n);
                    if(findData != '\0') {
                        System.out.println("\n\tData indeks ke " + n + " adalah " + findData);
                    }else {
                        System.out.println("\n\tData tidak ditemukan");
                    }
                    break;
                case 4:
                    System.out.print("\n\tMasukkan data yang ingin dicari : ");
                    findData = scan.next().charAt(0);
                    index = stackChar.indexOf(findData);
                    if(index < 0) {
                        System.out.println("\n\tData tidak ditemukan");
                    }else {
                        System.out.println("\n\t" + findData + " berada pada index ke " + index);
                    }
                    break;
                case 5:
                    System.out.print("\n\tNama barang yang ingin dipindah : ");
                    findData = scan.next().charAt(0);
                    index = stackChar.indexOf(findData);
                    if(index < 0) {
                        System.out.println("\n\tBarang tidak dapat ditemukan");
                        break;
                    }

                    System.out.print("\n\tDipindahkan di atas nama barang : ");
                    findData2 = scan.next().charAt(0);
                    index2 = stackChar.indexOf(findData2);
                    if(index2 >= 0) {
                        stackChar.remove(index);
                        stackChar.insertElementAt(findData, index2+1);
                    } else {
                        System.out.println("\n\tBarang tidak dapat di temukan");
                    }
                    break;
                case 6:
                    System.out.print("\n\tNama barang yang ingin dipindah : ");
                    findData = scan.next().charAt(0);
                    index = stackChar.indexOf(findData);
                    if(index < 0) {
                        System.out.println("\n\tBarang tidak dapat ditemukan");
                        break;
                    }

                    System.out.print("\n\tDipindahkan di dibawah nama barang : ");
                    findData2 = scan.next().charAt(0);
                    index2 = stackChar.indexOf(findData2);
                    if(index2 >= 0) {
                        stackChar.remove(index);
                        stackChar.insertElementAt(findData, index2);
                    } else {
                        System.out.println("\n\tBarang tidak dapat di temukan");
                    }
                break;
                case 7:
                    isRepeat = false;
                    break;
                default:
                    System.out.println("\n\tPerintah tidak dikenali");
                    break;
            }

        }while(isRepeat);

        scan.close();

    }
}
