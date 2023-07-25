package codefun2000;

import java.util.Scanner;

public class code01 {
    public static void main(String[] args) {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] corrsys = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            corrsys[x][y] = 1;
        }
        // 计算前缀和

        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                corrsys[i][j] += corrsys[i - 1][j] + corrsys[i][j - 1] - corrsys[i - 1][j - 1];
            }
        }
        for (int i = a + 1; i < 1001; i++) {
            for (int j = b + 1; j < 1001; j++) {
                int count = corrsys[i][j] - corrsys[i - a - 1][j] - corrsys[i][j - b - 1] + corrsys[i - a - 1][j - b - 1];
                res = Math.max(count, res);
            }
        }
        System.out.println(res);
    }
}
