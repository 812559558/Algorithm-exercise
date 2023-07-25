package leecode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        s.indexOf(s.charAt(0), 0);
        for (int i = 0; i < len; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int j = i;
            for (; j < len; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = j - 1;
                    break;
                } else {
                    map.put(s.charAt(j), j);
                }
            }
            int len2 = j - i;
            maxLen = Math.max(len2, maxLen);
            i = map.get(s.charAt(j)) - 1;
        }
        System.out.println();
        return maxLen;
    }

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int t : nums) {
            if (t % 2 == 0) {
                if (t % 3 == 0) {
                    sum += t;
                    count++;
                }
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int t : arr) {
            queue.add(t);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int t : nums) {
            queue.add(t);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
