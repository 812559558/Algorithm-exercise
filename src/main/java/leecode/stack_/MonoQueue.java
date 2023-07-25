package leecode.stack_;

import java.util.Deque;
import java.util.LinkedList;

public class MonoQueue {
    Deque<Integer> deque=new LinkedList<>();
    void pop(int val){
        if(!deque.isEmpty()&&val==deque.peekFirst()){
            deque.pop();
        }
    }
    void push(int val){
        while (!deque.isEmpty()&&val>deque.peekLast()){
            deque.removeLast();
        }
        deque.addLast(val);
    }
    int front(){
        return deque.peekFirst();
    }
}
