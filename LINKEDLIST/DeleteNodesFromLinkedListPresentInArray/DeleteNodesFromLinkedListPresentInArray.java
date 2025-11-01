package DeleteNodesFromLinkedListPresentInArray;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }

        ListNode res = new ListNode(-1, head);
        ListNode cur = res;

        while(cur.next != null) {
            if(numSet.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }
    public static void main(String[] args) {
        
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
