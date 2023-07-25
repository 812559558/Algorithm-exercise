package leecode;

import java.util.Arrays;

public class Q704 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] res = new int[3][3];
               res =solution.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }
}
