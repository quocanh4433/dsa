package ValidateBinarySearchTree;

import common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {

    /*
    SOLUTION 1: Depth First Search
     * Time: O(n)
     * 
     * Space:
     *  - O(h)
     *  - Cây nghiên 1 bên O(n)
     *  - Cây cân bằng O(logn)
     * 
     * 
     */

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean dfs(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        int value = node.val;
        if (!(value > left && value < right)) {
            return false;
        }

        return dfs(node.left, left, value) && dfs(node.right, value, right);
    }



    /*
     * SOLUTION 2: Breath First Search
     * 
     * Thông thường kiểm tra BST hay dùng DFS đệ quy (vì dễ so sánh min/max), 
     * nhưng BFS vẫn làm được bằng cách lưu thêm thông tin min/max cho mỗi node trong queue.
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     */
    public static  class NodeBFS {
        TreeNode node;
        long min;
        long max;

        NodeBFS (TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isValidBST_BFS(TreeNode root) {
        if(root == null) return true;

        Queue<NodeBFS> queue = new LinkedList<>();
        queue.add(new NodeBFS(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!queue.isEmpty()) {
            NodeBFS el = queue.poll();
            TreeNode node = el.node;
            long min = el.min;
            long max = el.max;

            if(node.val <= min || node.val >= max) return false;

            if(node.left != null) {
                queue.add(new NodeBFS(node.left, min, node.val));
            }

            if (node.right != null) {
                queue.add(new NodeBFS(node.right, node.val, max));
            }
        }

        return true;
    }



    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);

        n0.left = n1; n0.right = n2; 

        System.out.println(isValidBST(n0));
        System.out.println(isValidBST_BFS(n0));
    }
}
