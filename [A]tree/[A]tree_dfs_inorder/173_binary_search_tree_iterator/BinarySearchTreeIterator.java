import java.util.*;

public class BinarySearchTreeIterator {

    class BSTIterator {

        /*
        next() → trả về node nhỏ nhất tiếp theo
        hasNext() → còn node nào chưa duyệt không

        follow-up:
            next() -> O(1)
            hasNext() -> O(1)
         */
        Stack<TreeNode> stack = new Stack<>(); // stack giữu cho node nhỏ nhất được lấy đầu tiên

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        public void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();

            if (node.right != null) {
                pushLeft(node.right);
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
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
