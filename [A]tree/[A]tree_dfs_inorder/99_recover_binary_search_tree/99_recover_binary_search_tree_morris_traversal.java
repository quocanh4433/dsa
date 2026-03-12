
@SuppressWarnings("unused")
class RecoverBinarySearchTree_MorrisTraversal {

    /*
        ▪︎ T/C: inorder trong BST được dãy sắp xếp tăng dần

        ▪︎ theo yêu cầu chỉ có 2 node cần swap

        time O(n)
        space O(1)
     */
    
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        TreeNode cur = root;

        while (cur != null) {
          
            //.....................
        }
     

     
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
