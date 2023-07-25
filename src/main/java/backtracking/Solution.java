package backtracking;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> path = new LinkedList();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 0);
        return res;
    }

    public void backTrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            System.out.println(path.size());
            res.add(new ArrayList<>(path));
            return;
        }
        // path里面的个数 path.size()
        // 还需要k-path.size
        // n-(k-path.size)+1
        for (int i = startIndex; i <= n; i++) {
            path.push(i);
            backTrack(n, k, i + 1);
            path.pop();
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack2(k, n, 1);
        return res;
    }

    public void backTrack2(int k, int n, int startIndex) {
        if (path.size() == k) {
            int sum = 0;
            for (int x :
                    path) {
                sum += x;
            }
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
        }
        for (int i = startIndex; i <= 9; i++) {
            path.addLast(i);
            backTrack2(k, n, i + 1);
            path.pollLast();
        }

    }

    public void backTrack3(int k, int n, int startIndex) {
        if (n < 0) { // 剪枝操作
            return; // 如果path.size() == k 但sum != targetSum 直接返回
        }
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            n -= i;
            path.addLast(i);
            backTrack3(k, n, i + 1);
            path.pollLast();
            n += i;
        }

    }

    String[] phone = new String[]{
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };
    List<String> nums = new ArrayList<>();
    String path2 = "";

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return nums;
        backTrack4(digits, 0, path2);
        return nums;
    }

    public void backTrack4(String digits, int Index, String path2) {
        if (Index == digits.length()) {
            nums.add(path2);
            return;
        }
        String tem = phone[digits.charAt(Index) - '0'];
        for (int i = 0; i < tem.length(); i++) {
            char c = tem.charAt(i);
            backTrack4(digits, Index + 1, path2 + c);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack5(candidates, target, 0);
        return res;
    }

    public void backTrack5(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && target - candidates[i] > 0; i++) {
            target -= candidates[i];
            path.add(candidates[i]);
            backTrack5(candidates, target, i);
            path.removeLast();
            target += candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        backTrack6(candidates, target, used, 0);
        return res;
    }

    public void backTrack6(int[] candidates, int target, int[] used, int startIndex) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(candidates[i]);
            used[i] = 1;
            backTrack6(candidates, target - candidates[i], used, i + 1);
            path.removeLast();
            used[i] = 0;
        }
    }

    LinkedList<String> path3 = new LinkedList<>();
    ArrayList<List<String>> res2 = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack7(s, 0);
        return res2;
    }

    public void backTrack7(String s, int startIndex) {
        if (startIndex == s.length()) {
            res2.add(new ArrayList<>(path3));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String tem = s.substring(startIndex, i);
            if (isHuiWen(tem)) {
                path3.add(tem);
                backTrack7(s, i + 1);
                path3.removeLast();
            }
        }
    }

    public boolean isHuiWen(String s) {
        System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    LinkedList<String> res3 = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res3;
        StringBuilder stringBuilder = new StringBuilder(s);
        backTrack8(stringBuilder, 0, 0);
        return res3;
    }

    public void backTrack8(StringBuilder s, int StartIndex, int pointNum) {
        if (pointNum == 3) {

            if (isIPAddress(s.substring(StartIndex, s.length()))) {
                res3.add(s.toString());
            }
        }
        for (int i = StartIndex; i < s.length(); i++) {
            String tem = s.substring(StartIndex, i + 1);
            if (isIPAddress(tem)) {
                s.insert(i + 1, '.');
                backTrack8(s, i + 2, pointNum + 1);
                s.deleteCharAt(i + 1);
            } else break;
        }
    }

    public boolean isIPAddress(String s) {
        if (s.length() == 0) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }
        if (Long.parseLong(s) > 255) {
            return false;
        }
        return true;
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrack9(nums, 0);
        return res;
    }

    public void backTrack9(int[] nums, int StartIndex) {
        System.out.println(path);
        res.add(new ArrayList<>(path));
        for (int i = StartIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack9(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack10(nums, 0, used);
        return res;
    }

    public void backTrack10(int[] nums, int StartIndex, boolean[] used) {
        res.add(new ArrayList<>(path));
        for (int i = StartIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrack10(nums, i + 1, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        backTrack11(nums, 0);
        return res;
    }

    public void backTrack11(int[] nums, int StartIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = StartIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backTrack11(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backTrack12(nums, 0, used);
        return res;
    }

    public void backTrack12(int[] nums, int StartIndex, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrack12(nums, 0, used);
            path.removeLast();
            used[i] = 0;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backTrack13(nums, 0, used);
        return res;
    }

    public void backTrack13(int[] nums, int StartIndex, int[] used) {
        System.out.println(111);
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;
                backTrack13(nums, 0, used);
                path.removeLast();
                used[i] = 0;
            }
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        backTrack14(tickets);
        nums.add("JFK");
        return nums;
    }

    public void backTrack14(List<List<String>> tickets){
        System.out.println(nums.size());
       String tem=nums.get(nums.size()-1);
       if(nums.size()==tickets.size()+1){
           return;
       }
        for (int i = 0; i < tickets.size(); i++) {
            List<String> strings = tickets.get(i);
            if(strings.get(0)==tem){
                nums.add(strings.get(1));
            }
        }
        backTrack14(tickets);
    }
}
