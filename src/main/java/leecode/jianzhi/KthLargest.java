package leecode.jianzhi;

import leecode.tree_.TreeNode;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{9,5,7,8,7,9,8,2,0,7};
        distinctAverages(nums);


    }

    public int findKthLargest(int[] nums, int k) {
        // O(n)时间复杂度

        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];
        int x = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        if (k <= j) return quickselect(nums, left, j, k);
        else return quickselect(nums, j + 1, right, k);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int[] nums;
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();

        this.k = k;
        this.nums = nums;
        for (int t : nums) {
            queue.add(t);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    Set<Integer> toDeleteSet;
    List<TreeNode> roots;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDeleteSet = new HashSet<Integer>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        roots = new ArrayList<TreeNode>();
        dfs(root, true);
        return roots;
    }

    public TreeNode dfs(TreeNode node, boolean isRoot) {
        if (node == null) {
            return null;
        }
        boolean deleted = toDeleteSet.contains(node.val);
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        if (deleted) {
            return null;
        } else {
            if (isRoot) {
                roots.add(node);
                System.out.println(node.val);
            }
            return node;
        }
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int count = 0;
        for (int tem : price) {
            if (tem - prev >= tastiness) {
                count++;
                prev = tem;
            }

        }
        return count >= k;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int resLen = queries.length;
        int[] res = new int[resLen];
        int k = 0;
        int[] prefix = new int[words.length];
        boolean[] isyuan = new boolean[words.length + 1];
        for (int i = 1; i < words.length; i++) {
            if (isyuanyin(words[i])) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        for (int i = 0; i < resLen; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            res[i] = prefix[end + 1] - prefix[start];
        }
        return res;
    }

    public boolean isyuanyin(String word) {
        if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u') {
            if (word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u') {
                return true;
            }
        }
        return false;
    }

    public static int maxRepOpt1(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            int j = i;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int len1 = j - i;
            res = Math.max(len1, res);
            if (len1 < map.get(text.charAt(i)) && (j < text.length() || i > 0)) {
                res = Math.max(res, len1 + 1);
            }
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - i, map.get(text.charAt(i))));
            i = j;
        }
        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(chars, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            int curlen = 1;
            if (!set.contains(num - 1)){
                int cur = num;
                while (set.contains(cur + 1)){
                    curlen+=1;
                    cur+=1;
                }
            }
            res = Math.max(res,curlen);
        }
        return res;
    }
    public static int distinctAverages(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0 , right = nums.length - 1;
        HashSet<Float> set = new HashSet();
        while(left < right){
            float avg = ((float) nums[left] + nums[right])/2;
            set.add(avg);
            left++;
            right--;
        }
        count = set.size();
        return count;
    }
}
