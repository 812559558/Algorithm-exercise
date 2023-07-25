package leecode.linklist;

public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode phead=new ListNode();
        ListNode head1=null;
        int falg=0;
        phead.next=head;
        while (head!=null){
            if(head.val!=val){
                if(falg==0){
                    head1=head;
                }
                head=head.next;
                phead=phead.next;
                falg=1;
            }else{
                phead.next=head.next;
                head.next=null;
                head=phead.next;
            }

        }
        return head1;
    }
    public ListNode removeElements2(ListNode head, int val) {
        ListNode prehead=new ListNode(-1,head);
        ListNode pre=prehead;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return prehead.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode newhead=new ListNode(0);
        while (head!=null){
            ListNode tmp=head;
            ListNode tmp2=head.next;
            tmp.next=newhead.next;
            newhead.next=tmp;
            head=tmp2;
        }
        return newhead.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head; // 设置一个虚拟头结点
        ListNode cur1 = dumyhead; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur1.next != null && cur1.next.next != null) {
            temp = cur1.next.next.next;
            firstnode = cur1.next;
            secondnode = cur1.next.next;
            cur1.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur1 = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode A=headA;
        ListNode B=headB;
        int lenA=0;
        int lenB=0;
        while (A!=null){
            lenA++;
            A=A.next;
        }
        while (B!=null){
            lenB++;
            B=B.next;
        }
        int diffval=Math.abs(lenA-lenB);
        boolean flag=lenA>lenB?true:false;
        if(flag){
            while (diffval>0){
                headA=headA.next;
                diffval--;
            }
        }else {
            while (diffval>0){
                headB=headB.next;
                diffval--;
            }
        }
        while (headA!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {//双指针判断有没有环
        ListNode slow=head;
        ListNode fast=head;
        ListNode meet;
        if(fast==null){
            return null;
        }
        while (fast.next!=null&&fast!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                meet=fast;
                while (meet!=head){
                    head=head.next;
                    meet=meet.next;
                }
                return head;
            }
        }
        return null;
    }

}
