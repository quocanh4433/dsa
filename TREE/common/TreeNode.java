package common;

public class TreeNode {

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
