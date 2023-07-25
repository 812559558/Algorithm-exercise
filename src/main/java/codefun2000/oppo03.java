package codefun2000;

import java.io.*;
import java.util.StringTokenizer;

public class oppo03 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[] = new int[n];
        int[] sum = new int[n + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            while (t % 2 == 0) {
                nums[i]++;
                t /= 2;
            }
            sum[i + 1] = sum[i] + nums[i];
        }

        int l = 0;

        for (int r = 0; r < n + 1; r++) {
            int cnt = sum[r] - sum[l];
            while (cnt >= k) {
                res = Math.min(r - l, res);
                l++;
                cnt = sum[r] - sum[l];
            }

        }
        out.println(res);
        // 最后记得flush，不然会没有输出
        out.flush();
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
