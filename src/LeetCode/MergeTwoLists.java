package LeetCode;

public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode ans;

        if(list1 == null && list2 == null){
            return null;
        } else if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }

        if (list1.val < list2.val){
            ans = list1;
        } else {
            ans = list2;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        while(head1 != null || head2 != null){

            if(head1 == null){
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
            }else if (head2 == null){
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;
            }else if (head1.val < head2.val ){
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
            }
        }
        return ans;
    }
}
