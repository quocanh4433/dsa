
import java.util.*;

@SuppressWarnings("unused")
class VerticalOrderTraversalOfABinaryTree {
    /*
        time O(n logn)
            ▪︎ while loop O(n)
            ▪︎ put treemap O(logn)
        space O(n logn)
            ▪︎ var res O(n)
            ▪︎ priority queue poll() O(logn)
    */

    class Pair {

        TreeNode node;
        int col;
        int row;

        Pair(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /*
            first treemap TreeMap<Integer, ...>: sort increasing col 
            second treemap TreeMap<Integer, TreeMap<Integer, ...>>: sort increasing row
            priority queue TreeMap<Integer, TreeMap<Integer, ProrityQueue<Integer>>> sort increasing value
         */
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            TreeNode node = cur.node;
            int col = cur.col;
            int row = cur.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, col - 1, row + 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            res.add(list);
        }

        return res;
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
