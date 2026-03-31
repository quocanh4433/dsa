import java.util.Stack;

@SuppressWarnings("unused")
class RemoveNodesFromLinkedList {
    /*
        time O(n)
        space O(n)
    */
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null) {
            while (!stack.isEmpty() && cur.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }

        ListNode res = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = res;
            res = node;
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
