
import java.util.*;

@SuppressWarnings("unused")
class MaximumWidthOfBinaryTree {

    /*
        time O(n)
        space O(w) or O(n)
            ▪︎ w: width of tree 
            ▪︎ last level perfetch binary tree w ≈ 2^(h-1) ≈ n/2 ≈ n
     */
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long start = q.peek().getValue();
            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> cur = q.poll();
                TreeNode node = cur.getKey();
                long index = cur.getValue() - start;

                if (i == 0) {
                    first = index;
                }
                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, index * 2));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(node.right, index * 2 + 1));
                }
            }

            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
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

class Pair<K, V> {

    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
