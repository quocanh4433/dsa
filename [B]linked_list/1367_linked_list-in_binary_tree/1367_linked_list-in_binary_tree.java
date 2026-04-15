
@SuppressWarnings("unused")
class LinkedListInBinaryTree {

    /*
        time O(n * m)
            n: node of tree
            m: node of linked-list (worst-case)
        space O(h * m)
            skewed tree: h ~ n
            balanced tree: h ~ logn
            m: node of linked-list (worst-case)
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head != null && root == null) {
            return false;
        }

        // trường hợp bắt đầu root cũng chính là bắt đầu head
        if (checkPath(head, root)) {
            return true;
        }

        // không bắt đầu ơ root thì có thể left hoặc right
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean checkPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null || head.val != root.val) {
            return false;
        }

        boolean left = checkPath(head.next, root.left);
        boolean right = checkPath(head.next, root.right);

        return left || right;
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

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    TreeNode left;
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}
