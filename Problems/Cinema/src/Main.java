import java.util.Scanner;
class Main {
    private static int n;
    private static int m;
    private static boolean[][] seats;
    private static int k;

    private static void readData() {
        var sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        seats = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                seats[row][col] = sc.nextInt() == 1;
            }
        }
        k = sc.nextInt();
    }

    private static boolean checkRow(int row) {
        int col = 0;
        int count = 0;
        while (true) {
            while (col < m && !seats[row][col] && count < k) {
                col++;
                count++;
            }
            if (count == k) return true;
            if (col == m) return false;
            col++;
            count = 0;
        }
    }

    public static void main(String[] args) {
        readData();
        int result = -1;
        for (int row = 0; row < n; row++) {
            if (checkRow(row)) {
                result = row;
                break;
            }
        }
        System.out.println(result + 1);
    }
}
