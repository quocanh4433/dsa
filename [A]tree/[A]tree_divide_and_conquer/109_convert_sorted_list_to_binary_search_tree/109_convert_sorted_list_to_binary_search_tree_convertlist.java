import java.util.ArrayList;
import java.util.List;

class ConvertSortedListToBinarySearchTree_ConvertToList {
    /*
        time O(n)
        space O(n)
    */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return build(list, 0, list.size() - 1);
    }

    public TreeNode build(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = build(list, l, mid - 1);
        node.right = build(list, mid + 1, r);

        return node;
    }
}

class ListNode {

    int val;
    ListNode next;
    @SuppressWarnings("unused")
    ListNode() {
    }

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

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    @SuppressWarnings("unused")
    TreeNode left;
    @SuppressWarnings("unused")
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}
