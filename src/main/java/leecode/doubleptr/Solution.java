package leecode.doubleptr;

import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len= nums.length;
        int count=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==val){
                for (int j = i+1; j < len; j++) {
                    nums[j-1]=nums[j];
                }
                count++;
                len--;
            }
        }
        System.out.println(count);
        return len-count;
    }
    public int removeElementSF(int[] nums, int val) {
        int len= nums.length;
        int slow=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=val){
                nums[slow++]=nums[i];
            }
        }

        return slow;
    }
    public void reverseString(char [] s){
        int n=s.length;
        for(int left=0,right=n-1;left<right;++left,--right){
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
        }
    }
    public String replaceSpace (String s){
        char[] chars = s.toCharArray();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                count++;
            }
        }
        char[] chars1 = new char[2 * count + chars.length];
        int j=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                chars1[j++]='%';
                chars1[j++]='2';
                chars1[j++]='0';
            } else{
                chars1[j++]=chars[i];
            }

        }
        return new String(chars1);
    }
    public String reverseWords(String s) {
        s=s.trim();
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return  String.join(" ",strings);
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        if(head==null){
            return null;
        }
        ListNode cur=head.next;
        pre.next=null;
        while (cur!=null){
            ListNode tem;
            tem=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tem;

        }
        return pre;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head1 = new ListNode();
        head1.next=head;
        ListNode head2=head;
        while (n>0){
            n--;
            head2=head2.next;
        }
        while (head2!=null){
            head1=head1.next;
            head2=head2.next;
        }
        if(head==head1.next){
            return head1.next.next;
        }
        head1.next=head1.next.next;
        return head;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        int lenA=0,lenB=0;
        while (A!=null){
            A=A.next;
            lenA++;
        }
        while (B!=null){
            B=B.next;
            lenB++;
        }
        int miner=Math.abs(lenA-lenB);
        boolean flag=lenA>lenB?true:false;
        if(flag){
            while (miner>0){
                miner--;
                headA=headA.next;
            }
        }else {
            while (miner>0){
                miner--;
                headB=headB.next;
            }
        }
        while (headA!=null){
            headA=headA.next;
            headB=headB.next;
            if(headA==headB){
                return headA;
            }
        }
        return null;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        HashSet<List<Integer>> lists1 = new HashSet<>();
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            int left=i+1;
            int right=len-1;
            while (left<right){
                if (nums[i] + nums[left] + nums[right]==0) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    lists.add(res);
                    lists1.add(res);
                    left++;
                } else if (nums[i] + nums[left] + nums[right]<0) {
                    left++;
                }else {
                    right--;
                }
            }

        }
        ArrayList<List<Integer>> lists2 = new ArrayList<>(lists1);

        return lists2;
    }
}










