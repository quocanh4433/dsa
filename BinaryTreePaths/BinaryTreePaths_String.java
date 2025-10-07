
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_String {

    /*
        BINARY TREE PATH  --  STRINGBUILDER

        Given the root of a binary tree, return all root-to-leaf paths in any order.
        A leaf is a node with no children. 
     */
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPath(root, "", result);
        return result;
    }

    static void findPath(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }

        if (node.left != null) {
            findPath(node.left, path + node.val + "->", result);
        }

        if (node.right != null) {
            findPath(node.right, path + node.val + "->", result);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths_String btp = new BinaryTreePaths_String();

        // Tạo cây: [1,2,3,null,5]
        TreeNode root = btp.new TreeNode(1);
        root.left = btp.new TreeNode(2);
        root.right = btp.new TreeNode(3);
        root.left.right = btp.new TreeNode(5);

        System.out.println(btp.binaryTreePaths(root));  // Expected: [1->2->5, 1->3]
    }
}
