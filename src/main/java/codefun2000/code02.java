package codefun2000;

import java.util.HashMap;
import java.util.Scanner;

public class code02 {
    public static void main(String[] args) {
        int[] cache = new int[1];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        while (j < n) {
            int cur = nums[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.size() > k){
                int c = nums[i];
                if(map.get(c) == 1){
                    map.remove(c);
                }else {
                    map.put(c,map.get(c) - 1);
                }

                i++;
            }
            res = Math.max(res,j - i + 1);
            j++;
        }
        System.out.println(res);
    }
}
