import LINKEDLIST.MergeKSortedLists.MergeKSortedLists.ListNode;

public class AddTwoNumbers {
    /*
    
        Time -> O(max(n, m));
        Space -> O(max(n, m))
    
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        int temp = 0;
        int sum = 0;

        while(l1 != null || l2 != null || temp != 0) {
            sum = temp;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int num = sum % 10;
            temp = sum / 10;
            dummy.next =  new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }
    public static void main(String[] args) {
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
