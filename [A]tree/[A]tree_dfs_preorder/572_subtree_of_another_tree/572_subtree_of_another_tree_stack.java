import java.util.*;

@SuppressWarnings("unused")
class SubtreeOfAnotherTree_Stack {
    /*
        time O(n * m)
            ▪︎ while loop: O(n)
                ▪︎ isSameTree: O(m)
        space O(h) - h: height of root
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)

        n = number of nodes in the main tree root
        m = number of nodes in the subtree subRoot
    */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node.val == subRoot.val && isSameTree(node, subRoot)) {
                    return true;
                }
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
        }

        return false;
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if((node1 == null || node2 == null) || (node1.val != node2.val)) return false;
        /*
            left: FALSE && right: TRUE -> FALSE
            left: TRUE && right: FALSE -> FALSE
            left: TRUE && right: TRUE -> TRUE
            
            trường hợp đặc biêt 1 trong 2 node chỉ có 1 giá trị

            example:  root = [1, 1]  subRoot = [1]

            left: FALSE && right:FALSE -> TRUE
         */
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
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