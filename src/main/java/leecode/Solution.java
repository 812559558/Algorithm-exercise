package leecode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;

        while (left<=right){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
            mid=(left+right)/2;

        }
        return -1;
    }
    public int removeElement(int[] nums, int val) {
        int l=nums.length;
        for (int i = 0; i < l; i++) {
            if(nums[i]==val){

                for (int j = i+1; j < l; j++) {
                    nums[j-1]=nums[j];
                }
                i--;
                l--;
            }
        }
        return l;
    }
    public int removeElement2(int[] nums,int val){

        int slow=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[slow++]=nums[i];
            }
        }
        return slow;
    }
    public int[] sortedSquares(int[] nums) {
        int l=nums.length;
        for (int i = 0; i < l; i++) {
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < l; i++) {
            nums[i]=nums[i]*nums[i];
        }
        return nums;
    }
    public int[] sortedSquares2(int[] nums) {
        int l=nums.length;
        int res[]=new int[l];
        int i=0;
        int j=l;
        int k=l-1;
        while (i<=j){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                res[k]=nums[j]*nums[j];
                k--;
                j--;
            }else {
                res[k]=nums[i]*nums[i];
                k--;
                i++;
            }
        }
        return res;
    }
    public int minSubArrayLen(int target, int[] nums) {

        int numssize=nums.length;
        int minl=numssize+1;
        for (int i = 0; i <numssize ; i++) {
                int sum=0;
                int a=0;
            for (int j = i; j < numssize; j++) {
                a++;
                sum+=nums[j];
                if(sum>=target){
                    minl=minl>a?a:minl;
                    System.out.println("minl="+minl);
                    break;
                }
            }
        }
        return minl>numssize?0:minl;
    }
    public int minSubArrayLen2(int target,int[] nums){
        int size=nums.length;
        int sum=0;
        int start=0;
        int minlen=size+1;
        for (int i = 0; i < size; i++) {
            sum+=nums[i];
            while (sum>=target){
                int len=i-start+1;
                minlen=minlen>len?len:minlen;
                sum=sum-nums[start];
                start++;
            }
        }
        return minlen>size?0:minlen;
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start=0;
        int loop=0;
        int count=1;
        int i,j;
        while (loop++<n/2){
            for ( j=start; j < n-loop;j ++) {
                res[start][j]=count++;
            }
            for(i=start;i<n-loop;i++){
                res[i][j]=count++;
            }
            for(;j>=loop;j--){
                res[i][j]=count++;
            }
            for(;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            res[start][start]=count;
        }
        return res;
    }
    static int[]bin_s;



    static int[]bin_t;
    @Test
    public void mhy2(){
        bin_s = new int[]{0,0,0};
        bin_t = new int[]{0,0,0};
        StringBuilder news =new StringBuilder("");
        StringBuilder newt=new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            String t = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='m') bin_s[0]++;
                else if (s.charAt(j)=='h') {
                    bin_s[1]++;
                } else if (s.charAt(j)=='y') {
                    bin_s[2]++;
                }else news.append(s.charAt(j));
            }
            for (int j = 0; j < t.length(); j++) {
                if(t.charAt(j)=='m') bin_t[0]++;
                else if (t.charAt(j)=='h') {
                    bin_t[1]++;
                } else if (t.charAt(j)=='y') {
                    bin_t[2]++;
                }else news.append(t.charAt(j));
            }
            if(news.equals(newt)){
                if(bin_s[0]-bin_t[0]==bin_s[1]-bin_t[1]&&bin_s[0]-bin_t[0]==bin_s[2]-bin_t[2]){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }

        }
    }

    public void newke41(){
        LinkedList<Integer> res = new LinkedList<>();
        int[] arr1 = res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int minMoney (int[] arr, int aim) {
        // write code here
        if (aim == 0) return 0;
        int[][]dp = new int [arr.length][aim + 1];

        for (int i = arr[0]; i <= aim; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j < arr[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i]] + 1);
            }
        }
        return dp[arr.length - 1][aim];
    }
}
