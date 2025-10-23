package SerializeAndDeserializeBinaryTree;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     * 👉 Tại sao method deserialize dùng "int[] i = {0}" thay vì "int i = 0"?
     * - Giải thích ở ./NOTE/Tree.md
     * 
     */


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join(",", list);
    }

    public static void dfsSerialize(TreeNode node, List<String> list) {
        if(node == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.val));
        dfsSerialize(node.left, list);
        dfsSerialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] arr = data.split(",");
        int[] i = {0}; 
        return dfsDeserialize(arr, i);
    }

    public static TreeNode dfsDeserialize(String[] vals, int[] i ) {
        if(vals == null) return null;
      
        String val = vals[i[0]];
        if (vals[i[0]].equals("N")) {
            i[0]++; // Tăng i cho lần đệ quy tiếp theo
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        i[0]++; // Tăng i cho lần đệ quy tiếp theo
        node.left = dfsDeserialize(vals, i);
        node.right = dfsDeserialize(vals, i);

        return node;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(6);

        n0.left = n1;
        n0.right = n2;

        n2.left = n4;
        n2.right = n3;

        String serial = serialize(n0);
        System.out.println(serial);
        System.out.println(deserialize(serial));

    }
}
