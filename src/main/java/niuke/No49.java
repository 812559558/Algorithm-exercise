package niuke;

import java.util.*;

public class No49 {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('-', 1);
            put('+', 1);
            put('*', 2);
        }
    };

    public int solve(String s) {
        s = s.replace(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        ArrayDeque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '('){
                        char prev = ops.peekLast();
                        if(map.get(prev)>=map.get(c)){
                            calc(nums,ops);
                        }else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()&&ops.peekLast()!='(') calc(nums,ops);
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        nums.addLast(ans);
    }

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int []res = new int [2];
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 0;
        for(int i = 0; i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }else{
                map.put(array[i],1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
        }
        return res;
    }
    boolean isNumber(char c) {

        return Character.isDigit(c);
    }
}
