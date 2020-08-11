import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int maxRow = sc.nextInt();
        int maxCol = sc.nextInt();

        int[][] arr = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        for (int y = 0; y < maxCol; y++) {
            for (int x = 0; x < maxRow; x++) {
                System.out.print(arr[maxRow - x - 1][y] + " ");
            }
            System.out.println();
        }
    }
}