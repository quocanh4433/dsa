import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    public static class ListNode {

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

    /**
     * 💡 IDEA: 
     * - Lưu val các node vào 1 mảng
     * - Sắp xếp mảng
     * - Tạo danh sach ListNode mới
     * 
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     * 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>(); // Space: O(n)
        for(ListNode ls : lists) { // Time: O(n)
            while(ls != null) {
                nodes.add(ls.val);
                ls = ls.next;
            }
        }

        Collections.sort(nodes); // Time: O(nlogn)

        ListNode res = new ListNode(-1); // Space: O(n)
        ListNode curr = res; // Space: O(1)

        for(int node : nodes) { // Time: O(n)
            curr.next = new ListNode(node);
            curr = curr.next;
        }
        return res.next;
    }
    
    public static void main(String[] args) {
        
    }
}

