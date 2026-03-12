
@SuppressWarnings("unused")
class SerializeAndDeserializeBST {

    /*
        ứng dụng tính chất của BST
        node.left < node < node.right

        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(",");
        int[] index = new int[1];

        return build(arr, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(String[] arr, int[] index, int min, int max) {
        if (index[0] >= arr.length) {
            return null;
        }

        int val = Integer.parseInt(arr[index[0]]);

        if (val < min || val > max) {
            return null;
        }

        index[0]++;
        TreeNode node = new TreeNode(val);

        node.left = build(arr, index, min, val);
        node.right = build(arr, index, val, max);

        return node;
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
