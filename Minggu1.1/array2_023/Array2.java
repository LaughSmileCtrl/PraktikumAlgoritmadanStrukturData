package array2_023;

public class Array2 {
    
    public static void main(String[] args) {
        int[] data = {10, 0, 8, 75, 9, 2, 4, 65, 0, 6};
        int nilai_terbesar, i;

        nilai_terbesar = data[0];
        for ( i = 1; i < 10; i++)
            if(data[i] > nilai_terbesar) 
                nilai_terbesar = data[i];

        System.out.println("nilai terbesar = " + nilai_terbesar);
    }
}
