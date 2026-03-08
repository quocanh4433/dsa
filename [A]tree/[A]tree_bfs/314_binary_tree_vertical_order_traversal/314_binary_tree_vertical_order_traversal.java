
import java.util.*;

class BinaryTreeVerticalOrderTraversal {
    /*
        treemap<>()
            time O(nlogn)
                ▪︎ while loop: O(n)
                ▪︎ treemap.put: O(logn)
            space O(n)
        hashmap<>()
            time O(n)
            space O(n)
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int minCol = 0;
        int maxCol = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            TreeNode node = cur.node;
            int col = cur.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, col - 1));
                minCol = Math.min(minCol, col - 1);
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, col + 1));
                maxCol = Math.max(maxCol, col + 1);
            }
        }

        for(int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}

class Pair {

    TreeNode node;
    int col;

    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
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
