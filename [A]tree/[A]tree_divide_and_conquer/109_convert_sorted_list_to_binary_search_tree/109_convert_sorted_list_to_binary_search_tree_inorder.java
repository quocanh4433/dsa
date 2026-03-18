

@SuppressWarnings("unused")
class ConvertSortedListToBinarySearchTree_Inorder {

    /*
        time O(n)
        space O(logn) 
            ▪︎ phụ thuộc vô recursion mà cây cân băng nên O(logn)
            ▪︎ tại sao cây cân bằng ? do build tree sô node bên phải ~ số node bên trái

        ý tưởng: 
            ▪︎ linked list đã sắp xếp nghĩ đến inorder
            
     */

    ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int n = 0; // số node trong listnode
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        cur = head;

        return build(0, n - 1);
    }

    public TreeNode build(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // build theo inorder left - root - right
        // build left
        TreeNode leftSide = build(l, mid - 1);

        // build root
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next; // dịch sang node tiếp theo
        root.left = leftSide;

        // build right
        root.right = build(mid + 1, r);

        return root;
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
