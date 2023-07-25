package codefun2000;

import java.io.*;
import java.util.StringTokenizer;

public class oppo01 {

    public static class FastReader {
        StringTokenizer st;
        BufferedReader br;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreElements()){
                try {
                    st=new StringTokenizer(br.readLine());
                }catch (IOException e){
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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));



            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] nums = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
                sum += nums[i];
            }

            for (int i = 0; i < k; i++) {

                int u = sc.nextInt();
                long v = sc.nextLong();
                long dif = v - nums[u - 1];
                nums[u - 1] = v;
                sum += dif;
            out.println(sum);
            }

        out.flush();


    }
}
