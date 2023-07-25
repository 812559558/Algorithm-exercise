package codefun2000;

import java.util.Arrays;
import java.util.Scanner;

public class p1004 {
    static int[]nums1;
    static int[][]cache;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        nums1 = nums;
        int sum = Arrays.stream(nums).sum();
        if(sum%2!=0) {
            System.out.println(0);
        }else {
            sum /= 2;
            cache = new int[n][sum+1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i],-1);
            }
            System.out.println(dfs(n - 1, sum));
        }

    }

    public static int dfs(int i, int n) {
        if(i<0){
            if(n == 0) return 1;
            else return 0;
        }
        if(n<nums1[i]) {
            cache[i][n] = dfs(i -1,n);
        }
        if(cache[i][n]!=-1) {
            return cache[i][n];
        }
        int res = dfs(i - 1,n) + dfs(i-1,n-nums1[i]);
        cache[i][n] = res;
        return res;
    }
}
