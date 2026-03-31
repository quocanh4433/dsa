
@SuppressWarnings("unused")
class ReverseNodesInEvenLengthGroups {

    /*  

        time O(n)
        space O(1)
        
        note: 
            we reverse base on actual group length, not the intended group size, 
            because the last group may be shorter
            
     */
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // if listnode has 1 or 2 nodes only
        if (head.next == null || head.next.next == null) {
            return head;
        }

        ListNode node = head;
        int groupSize = 1;

        while (node != null && node.next != null) {
            groupSize++;

            // first check number of node
            int count = 0;
            ListNode temp = node.next; // start couting and reversing from second node
            while (temp != null && count < groupSize) {
                count++;
                temp = temp.next;
            }

            if (count % 2 == 0) {
                ListNode prev = null;
                ListNode cur = node.next;

                for (int i = 0; i < count; i++) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }

                /*
                    2 -> 3 -> 4 -> 5

                    after reverse

                    4(prev) -> 3 -> 2
                    5(cur)

                    lúc này

                    prev là head của group vưa đảo
                    node là node đứng trước group
                    cur là node đứng sau group
                 */
                ListNode tail = node.next; // lấy đuôi chính là node số 2 cũ
                tail.next = cur;
                node.next = prev;
                node = tail;
            } else {
                for (int i = 0; i < count; i++) {
                    node = node.next;
                }
            }
        }

        return head;
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
