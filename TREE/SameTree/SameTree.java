package SameTree;

import TREE.common.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            /*
            👉 Điều kiện này kết hợp với điều kiên && phía trên
            -> ý nghĩa: chỉ 1 trong 2 node bằng null. Node còn lại khác null ✅


            👉 Điều kiện này đứng 1 mình thì TH p == null và q == null sẽ return false.
            Trong khi cần return về true. Gây LỖI ❌
             */

            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

    }
}
