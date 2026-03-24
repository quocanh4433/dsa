
class Solution {
    /*
        time O(n)
        space O(n)

        chưa tận dụng được tính chất của "completed binary tree"
    
    */
    public int countNodes(TreeNode root) {
        return count(root, 0);
    }

    private int count(TreeNode node, int count) {
        if (node == null) {
            return count;
        }

        count++;
        count = count(node.left, count);
        count = count(node.right, count);

        return count;
    }
}

class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toStringHelper(this);
    }

    private String toStringHelper(TreeNode node) {
        if (node == null) {
            return "N";
        }
        return node.val + "(" + toStringHelper(node.left) + "," + toStringHelper(node.right) + ")";
    }
}
