package codefun2000;

import java.util.Scanner;

public class P1216 {
    public static void main(String[] args) {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        String x = scanner.next();
        String y = scanner.next();
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if(x.charAt(i - 1) == y.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j],res);
            }
        }
        System.out.println(res);
    }
}
