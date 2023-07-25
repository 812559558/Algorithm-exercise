package leecode.stack_;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
    }
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int len=chars.length;
        System.out.println(len);
        if(len%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if(chars[i]=='('||chars[i]=='{'||chars[i]=='['){
                stack.push(chars[i]);
            }else {
                if(!stack.empty()){
                    char tem=stack.pop();
                    if(tem=='{'&&chars[i]=='}'||tem=='['&&chars[i]==']'||tem=='('&&chars[i]==')') {

                    } else {
                        return false;
                    }
                }else {
                    return false;
                }
            }

        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }

    }
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.empty() && stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        String str = "";
        stack.toString();
        while (!stack.empty()) {
            str = stack.pop() + str;
        }
        return str;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            char[] chars = tokens[i].toCharArray();
            if (Character.isDigit(chars[0])) {//这样不行因为负数的第一个是-不是数字
                int X = Integer.parseInt(tokens[i]);
                stack.push(X);
            } else if (chars[0] == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (chars[0] == '-') {
                stack.push(-stack.pop() + stack.pop());
            } else if (chars[0] == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (chars[0] == '/') {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y/x);
            }

        }
        return stack.pop();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = k-1; i < len; i++) {
            int max=0;
            for (int j = 0; j < k; j++) {
                max=Math.max(nums[i-j],max);
            }
            res[i - k+1] = max;
        }
        return res;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        MonoQueue monoQueue = new MonoQueue();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            monoQueue.push(nums[i]);
        }
        res[0]=monoQueue.front();
        for (int i = k; i < len; i++) {
            monoQueue.pop(nums[i-k]);
            monoQueue.push(nums[i]);
            res[i - k+1] = monoQueue.front();
        }
        return res;
    }
    public void guessprice(int price){
        System.out.println("幸运观众，有五次机会");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int x=scanner.nextInt();
            if(x>price){
                System.out.println("高了");
            } else if (x<price) {
                System.out.println("低了");
            }else {
                System.out.println("猜中，奖品带走");
            }
        }
        System.out.println("五次机会用完，不能获得奖品");
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair2[1]-pair1[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int ans[]=new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}
