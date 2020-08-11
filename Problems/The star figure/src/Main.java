import java.util.Scanner;

class Main {

    static String f(boolean v) {
        return v ? "*" : ".";
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] m = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            m[n / 2][i] = true;
            m[i][n / 2] = true;
            m[i][i] = true;
            m[i][n - i - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(f(m[i][j]) + " ");
            }
            System.out.println();
        }
    }
}