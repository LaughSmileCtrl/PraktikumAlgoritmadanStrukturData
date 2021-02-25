import java.util.Scanner;

public class ArrayMultiplicator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("masukkan baris matriks 1 : ");
        int n = scan.nextInt();
        System.out.print("masukkan kolom matriks 1 : ");
        int m = scan.nextInt();
        double[][] matrix1 = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = scan.nextInt();
          }
        }

        System.out.print("masukkan baris matriks 2 : ");
        n = scan.nextInt();
        System.out.print("masukkan kolom matriks 2 : ");
        m = scan.nextInt();
        double[][] matrix2 = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = scan.nextInt();
          }
        }

        double[][] matrix3 = multiplyMatrix(matrix1, matrix2);

        System.out.println("Matriks 1");
        printMatrix(matrix1);
        System.out.println("Matriks 2");
        printMatrix(matrix2);
        System.out.println("Matriks 3");
        printMatrix(matrix3);

        scan.close();
    }

    private static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] matrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < a.length; k++) {
                    matrix[k][i] += a[k][j]*b[j][i];
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] is : matrix) {
            for (double is2 : is) {
                System.out.printf("%10.2g", is2);
            }
            System.out.println();
        }
    }
}
