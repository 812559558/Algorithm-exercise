package codefun2000;

import java.util.Scanner;

public class p1006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tot = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            max = max > nums[i] ? max : nums[i];
        }

        if (sum <= tot) {
            System.out.println(-1);
        } else {
            int r = max;
            int l = 0;//闭区间
            while (l <= r) {
                int s = 0;
                int mid = (r - l) / 2 + l;
                for (int i = 0; i < n; i++) {
                    s += Math.min(nums[i], mid);
                    if (s > tot) {
                        r = mid - 1;
                        break;
                    }
                }
                if (s >= tot) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(r);
        }

    }
}
