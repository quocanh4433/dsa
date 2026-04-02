
@SuppressWarnings("unused")
class DeleteNodeInABst {

    /*
        time O(n)
        space O(h)
            ▪︎ balanced tree: h = logn
            ▪︎ skew tree: h = On
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //root.val == key

            // root laf node leaf
            if (root.left == null && root.right == null) {
                return null;
            }

            // chỉ có 1 node con hoặc 0
            if (root.left == null) {
                return deleteNode(root.right, key);
            }
            if (root.right == null) {
                return deleteNode(root.left, key);
            }

            // có đủ cả 2 node con
            // có 2 cách tim node nhỏ nhất bên phải (Inorder successor) hoặc node lớn nhất bên trái (Inorder predecessor)
            TreeNode minRight = findMinRight(root.right);
            root.val = minRight.val;
            root.right = deleteNode(root.right, minRight.val);
        }
        return root;
    }

    public TreeNode findMinRight(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;

    }
}

class TreeNode {

    @SuppressWarnings("unused")
    int val;
    @SuppressWarnings("unused")
    TreeNode left;
    @SuppressWarnings("unused")
    TreeNode right;

    @SuppressWarnings("unused")
    TreeNode() {
    }

    @SuppressWarnings("unused")
    TreeNode(int val) {
        this.val = val;
    }

}
