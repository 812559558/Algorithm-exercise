package leecode.linklist;

public class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size=0;
        head=new ListNode(0);
    }
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }else {
            ListNode tem=head;
            while (index>=0){
                tem=tem.next;
                index--;
            }
            return tem.val;
        }

    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next=head.next;
        head.next=listNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val);
        ListNode ptem=head;
        ListNode tem=head.next;
        while (tem!=null){
            ptem=ptem.next;
            tem=tem.next;
        }
        tem.next=listNode;
        listNode.next=null;
        size++;
        System.out.println(size);
    }

    public void addAtIndex(int index, int val) {
        if(index<=0){
            ListNode listNode = new ListNode(val);
            listNode.next=head.next;
            head.next=listNode;
            size++;
        }else if(index==size){
            ListNode listNode = new ListNode(val);
            ListNode ptem=head;
            ListNode tem=head.next;
            while (tem!=null){
                ptem=ptem.next;
                tem=tem.next;
            }
            tem.next=listNode;
            listNode.next=null;
            size++;
        }else if(index>size){
            return;
        } else {
            ListNode pre=head;
            ListNode cur=head.next;
            while (index>0){
                pre=pre.next;
                cur=cur.next;
                index--;
            }
            ListNode listNode = new ListNode(val);
            listNode.next=cur;
            pre.next=listNode;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index>=0&&index<size){
            ListNode pre=head;
            ListNode cur=head.next;
            while (index>0){
                pre=pre.next;
                cur=cur.next;
                index--;
            }
            pre.next=cur.next;
            cur.next=null;
            size--;
        }

    }
}
