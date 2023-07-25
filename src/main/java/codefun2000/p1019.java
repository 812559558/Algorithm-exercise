package codefun2000;

import java.util.*;

public class p1019 {
    static int[] x_value;
    static int[] x_index;
    static int[] x_r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x_index = new int[n];
        x_r = new int[n];
        x_value = new int[n];
        for (int i = 0; i < n; i++) {
            x_index[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x_r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x_value[i] = sc.nextInt();
        }
        int[][] line = new int[n][2];
        for (int i = 0; i < n; i++) {
            line[i][0] = x_index[i] - x_r[i];
            line[i][1] = x_index[i] + x_r[i];
        }
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(line[i], x_value[i]);
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }

            }
        });
        for (int i = 0; i < n; i++) {
            x_value[i] = map.get(line[i]);
        }
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = x_value[i];
            for (int j = 0; j < i; j++) {
                if (line[i][0] >= line[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + x_value[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

}
