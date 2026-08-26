import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
class MergeKSortedLists_ArrayList {
    /*
        Cách đơn giản 
        - thêm val của tất cả các node vào list 
        - sắp xếp tăng dần 
        - tạo ListNode mới

        time O(nlogn) do hàm sort()
        space O(n)
    
    */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for (ListNode ls : lists) {
            while (ls != null) {
                nodes.add(ls.val);
                ls = ls.next;
            }
        }

        Collections.sort(nodes);

        ListNode res = new ListNode(-1);
        ListNode curr = res;

        for (int node : nodes) {
            curr.next = new ListNode(node);
            curr = curr.next;
        }
        return res.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
