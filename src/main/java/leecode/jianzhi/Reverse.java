package leecode.jianzhi;

import leecode.linklist.ListNode;

public class Reverse {
    public ListNode reverseList(ListNode head) {

        ListNode pre = head;
        head.next = null;
        ListNode cur = pre.next;
        while (cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur =nex;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
