import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
class MaximumTwinSumOfALinkedList_1 {
    /*
        time O(n)
        space O(n)
    */
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>(); // key: index - value: value of node
        ListNode cur = head;
        int n = 0;
        int i = 0;
        while (cur != null) {
            map.put(i, cur.val);
            n++;
            i++;
            cur = cur.next;
        }

        cur = head;
        i = 0;
        int res = 0;
        while (cur != null && i <= (n / 2) - 1) {
            int twinIndex = n - 1 - i;
            res = Math.max(res, cur.val + map.get(twinIndex));

            i++;
            cur = cur.next;
        }

        return res;
    }
}

class ListNode {

    @SuppressWarnings("unused")
    int val;
    ListNode next;

    @SuppressWarnings("unused")
    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
