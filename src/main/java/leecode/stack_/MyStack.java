package leecode.stack_;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    public MyStack() {
       list1=new LinkedList<>();
       list2=new LinkedList<>();
    }

    public void push(int x) {
        if(list1.isEmpty()){
            list2.add(x);
        }else {
            list1.add(x);
        }
    }

    public int pop() {
        int len=0;
        int x=0;
        if(list1.isEmpty()){
            len=list2.size();
            while (len>1){
                list1.add(list2.pop());
                len--;
            }
            x=list2.pop();
        }else {
            len=list1.size();
            while (len>1){
                list2.add(list1.pop());
                len--;
            }
            x=list1.pop();
        }
        return x;
    }

    public int top() {
        int len=0;
        int x=0;
        if(list1.isEmpty()){
            len=list2.size();
            while (len>1){
                list1.add(list2.pop());
                len--;
            }
            x=list2.pop();
            list1.add(x);
        }else {
            len=list1.size();
            while (len>1){
                list2.add(list1.pop());
                len--;
            }
            x=list1.pop();
            list2.add(x);
        }
        return x;
    }

    public boolean empty() {
        return list2.isEmpty()&&list1.isEmpty();
    }
}
