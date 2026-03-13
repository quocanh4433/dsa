import java.util.*;

@SuppressWarnings("unused")
class KthSmallestElementInABST {
    /*
        time
            ▪︎ best case O(h)
            ▪︎ worst case O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
    */
    Stack<TreeNode> stack = new Stack<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return -1;
        }

        // 1️⃣ duyệt sâu về trái càng tốt
        pushLeft(root);

        while (!stack.isEmpty()) {
            // 2️⃣ node nhỏ nhất chưa duyệt
            TreeNode cur = stack.pop();
            k--;


            // 3️⃣ duyệt đến phần tử nhỏ thứ k
            if (k == 0) {
                return cur.val;
            }

            // 4️⃣ nếu tồn tại nhánh phải. phần từ nhỏ tiếp theo nằm ở nhánh trai của nhánh phải này
            if (cur.right != null) {
                pushLeft(cur.right);
            }
        }

        return -1;
    }

    public void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

class TreeNode {

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
