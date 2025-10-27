
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_StringBuilder {

    /*
        BINARY TREE PATH  --  STRINGBUILDER

        Given the root of a binary tree, return all root-to-leaf paths in any order.
        A leaf is a node with no children. 


        Time Complexity: O(N²)
            - Có N là số node trong cây.
            - Mỗi node được duyệt đúng 1 lần, nhưng khi gặp node lá, ta thực hiện sb.toString() để thêm vào danh sách — thao tác này tốn O(H) trong đó H là chiều cao của cây (do cần copy chuỗi).
            - Trường hợp xấu nhất (cây nghiêng), tổng hợp lại thành O(N²).

        Space Complexity: O(H)
            - H là chiều cao của cây (do stack đệ quy và StringBuilder chứa đường đi hiện tại).
            - Nếu cây cân bằng → H = log N, còn nếu cây nghiêng → H = N.
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
        StringBuilder path = new StringBuilder();
        findPath(root, path, result);
        return result;
    }

    static void findPath(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }

        int returnPoint = path.length();
        // Nó ghi nhớ vị trí cũ của chuỗi sb trước khi thêm giá trị mới.
        // sau khi đệ quy xong, ta dùng sb.setLength(len) để quay lại trạng thái ban đầu — đây chính là backtracking.
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            findPath(node.left, path, result);
            findPath(node.right, path, result);
        }

        path.setLength(returnPoint);
    }

    public static void main(String[] args) {
        BinaryTreePaths_StringBuilder btp = new BinaryTreePaths_StringBuilder();

        // Tạo cây: [1,2,3,null,5]
        TreeNode root = btp.new TreeNode(1);
        root.left = btp.new TreeNode(2);
        root.right = btp.new TreeNode(3);
        root.left.right = btp.new TreeNode(5);

        System.out.println(btp.binaryTreePaths(root));  // Expected: [1->2->5, 1->3]
    }
}
