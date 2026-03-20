
@SuppressWarnings("unused")
class SmallestStringStartingFromLeaf {

    /*

        yêu cầu: 
            - tạo string tư leaf - root
            - lấy ra chuỗi nhỏ nhất
            - chuỗi nhỏ nhất là chuỗi có ký tự nhỏ hơn tại vị trí đầu tiên mà 2 chuỗi khác nhau

        vd: s1 = "adz" và s2 = "aadz"
        i = 0 -> a = a
        i = 1 -> d > a . Suy ra s2 < s1 vị trí đầu tiên khac nhau



        time O(n * h)
        space O(h)
    
     */
    String res = "~"; // lớn hơn bất kì chữ cái nào

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        char c = (char) (root.val + 'a');
        path = c + path;

        if (root.left == null && root.right == null) {
            if (path.compareTo(res) < 0) {
                res = path;
            }
        }

        dfs(root.left, path);
        dfs(root.right, path);

        /*
            Tại sao không xóa ký tự cuối khi backtrack?

            - vi string là immutable nên không

                0
              /   \
            1      2

            Dry run

            1)
            node = 0
            path = "a"


            2)  đi left
            node = 1
            path = "ba" // path này là path mới hoàn toàn

            so với res "ba".compareTo("~") -> res = "ba"


            3)  đi right
            node = 2
            path = 'c' + 'a' = "ca"

            

         */
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
