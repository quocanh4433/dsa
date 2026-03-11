
import java.util.Stack;

@SuppressWarnings("unused")
class CountGoodNodesInBinaryTree_Stack {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            int maxSoFar = cur.getValue();

            if (node.val >= maxSoFar) {
                count++;
            }

            int newMaxSoFar = Math.max(node.val, maxSoFar);

            if (node.right != null) {
                stack.push(new Pair<>(node.right, newMaxSoFar));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, newMaxSoFar));
            }
        }

        return count;
    }
}

class Pair<K, V> {

    K node;
    V maxSoFar;

    @SuppressWarnings("unused")
    Pair() {
    }

    Pair(K node, V maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }

    public K getKey() {
        return this.node;
    }

    public V getValue() {
        return this.maxSoFar;
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
