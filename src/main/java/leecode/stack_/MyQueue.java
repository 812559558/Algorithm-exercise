package leecode.stack_;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int x=stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return x;
    }

    public int peek() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int x=stack2.peek();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return x;
    }

    public boolean empty() {
       return stack1.empty()&&stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */