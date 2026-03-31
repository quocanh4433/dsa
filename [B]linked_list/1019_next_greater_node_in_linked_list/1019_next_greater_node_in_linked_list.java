import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
class NextGreaterNodeInLinkedList {
    /*
        time O(n)
        space O(n)
    */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new int[]{0};
        }

        List<Integer> list = new ArrayList<>(); // [2 1 5]
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                int idx = stack.pop();
                res[idx] = list.get(i);
            }
            stack.push(i);
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
