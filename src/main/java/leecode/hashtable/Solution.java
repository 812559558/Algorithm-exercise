package leecode.hashtable;

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i]-'a']++;
        }
        for (int i = 0; i < chart.length; i++) {
            hash[chart[i]-'a']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0){
                return false;
            }
        }
        return true;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> n1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            n1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(n1.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
    public int[] intersection2(int[] nums1, int[] nums2){
        HashSet<Integer> res = new HashSet<>();
        int[] ints = new int[1004];
        for (int i = 0; i < nums1.length; i++) {
            ints[nums1[i]]=1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if(ints[nums2[i]]==1){
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
    public boolean isHappy(int n) {
        HashSet<Integer> rec = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10 * n % 10;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (rec.contains(sum)) {
                return false;
            }
            rec.add(sum);
            n = sum;
            System.out.println(n);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> rec = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int div=target-nums[i];
            if(rec.containsKey(div)){
                res[0]=i;
                res[1]=rec.get(div);
                return res;
            }
            rec.put(nums[i],i);
        }
        return res;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum1 = nums1[i] + nums2[j];
                if(res.get(sum1)==null){
                    res.put(sum1,1);
                }else {
                    res.put(sum1,res.get(sum1)+1);
                }

            }
        }
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum2 = nums3[k] + nums4[l];
                if (res.get(-sum2)!=null) {
                    count+=res.get(-sum2);
                }
            }
        }

        return count;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }

        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }

        }

        return res;
    }
}
