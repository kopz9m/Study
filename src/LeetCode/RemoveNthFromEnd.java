package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {
    public static void main(String[] args) {

        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);
        ListNode Node4 = new ListNode(4);
        ListNode Node5 = new ListNode(5);

        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        Node4.next = Node5;

        RemoveNthFromEnd r = new RemoveNthFromEnd();

        ListNode res = r.removeNthFromEnd(Node1,2);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next == null && n == 1){
//            return null;
//        }
        // count
        int length = 1;
        ListNode head1 = head;
        while (head1.next != null){
            length++;
            head1 = head1.next;
        }

        if(length == n){
            return head.next;
        }

        ListNode head2 = head;
        int indexToDelete = length - n;

        int count = 0;
        while (head2.next != null){
            if (count!=indexToDelete-1){
                head2 = head2.next;
                count++;
            } else {
                ListNode NodeAfterTarget = head2.next.next;
                head2.next = NodeAfterTarget;
                break;
            }
        }

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

