import java.util.Arrays;
import java.util.Scanner;

public class mhy02 {
    static int[] bin_s;
    static int[] bin_t;

    public static void main(String[] args) {
        new mhy02().mhy2();

    }

    public void mhy2() {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            bin_s = new int[]{0, 0, 0};
            bin_t = new int[]{0, 0, 0};
            StringBuilder news = new StringBuilder("");
            StringBuilder newt = new StringBuilder("");
            String s = scanner.next();
            String t = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'm') bin_s[0]++;
                else if (s.charAt(j) == 'h') {
                    bin_s[1]++;
                } else if (s.charAt(j) == 'y') {
                    bin_s[2]++;
                } else news.append(s.charAt(j));
            }
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == 'm') bin_t[0]++;
                else if (t.charAt(j) == 'h') {
                    bin_t[1]++;
                } else if (t.charAt(j) == 'y') {
                    bin_t[2]++;
                } else newt.append(t.charAt(j));
            }

            if (news.toString().equals(newt.toString())) {
                if (bin_s[0] - bin_t[0] == bin_s[1] - bin_t[1] && bin_s[0] - bin_t[0] == bin_s[2] - bin_t[2]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }

        }
    }

    long M = 1000000007;

    public void mhy3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] pos = new int[1000010];
        Arrays.fill(pos, -1);
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            pos[a[i]] = i;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = a[i];

            for (int j = 1; j * j <= tmp; j++) { //因子的平方一定小于被分解的数

                if (tmp % j == 0) { //此时j是tmp的因子
                    if (j != tmp / j && pos[tmp / j] > -1) {//pos[tmp/j]是确保这个因子在集合里面，如果不在集合那也不用加了
                        dp[i] = (dp[i] + dp[tmp / j]) % M;// dp[tmp / j]是 tmp/j * j =tmp 的另一个因子
                    }
                    if (pos[j] > -1) { //这个因子j的dp也要加上 。总而言之：两个因子 1. j  2. tmp/j ..dp[j]加上，dp[tmp/j]加上
                        dp[i] = (dp[i] + dp[pos[j]]) % M;
                    }
                }
            }
            ans += dp[i];
            ans %= M;
            dp[i]++;
        }
        System.out.println(ans);
    }
}
