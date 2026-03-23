
@SuppressWarnings("unused")
class SerializeAndDeserializeBinaryTree {
    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: O(logn)
            ▪︎ skew tree: O(n)


        ý tưởng: 
            ▪︎ khác với bst binary tree khi encode cần trả về null
    
    */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    public void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int i = 0; // index in arr

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        return dfsDeserialize(arr);
    }

    public TreeNode dfsDeserialize(String[] arr) {
        if (arr == null) {
            return null;
        }

        String val = arr[i];

        if (val.equals("null")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        i++;

        root.left = dfsDeserialize(arr);
        root.right = dfsDeserialize(arr);

        return root;
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
