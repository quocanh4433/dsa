import java.util.PriorityQueue;

@SuppressWarnings("unused")
class MergeKSortedLists_Heap {

    /*
        *** 1/. Lưu ý: 
        Do ListNode đã được sắp xếp tăng dần

        time O(nlogk)
        space O(k)

        k tối đa 10^4
        n tối đa 10^9

        tối ưu hơn so với các thêm vào arraylist 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
                node = node.next;
            }
        }

        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            cur.next = minNode;

            // thêm node mới vào minheap
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }

            cur = minNode;
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
