
import java.util.ArrayList;
import java.util.List;

class LongestPathWithDifferentAdjacentCharacters {

    /*
        time O(n)
        space O(n)

        gần giống leetcode 543
     */
    int res = 1;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        if (n == 0) {
            return 0;
        }

        // build list[] tree
        // tree[i] = list<int>: node i có list các node con ....
        // tree[0] = [1, 2]: node 0 có 2 node con là 1, 2 
        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // build parent từ node con nên bắt đầu tư i = 1
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        dfs(0, tree, s);
        return res;
    }

    public int dfs(int node, List<List<Integer>> tree, String s) {
        // do 2 nhánh đi xuyêt node
        int longest = 0; // nhánh dài nhất
        int secondLongest = 0; // nhánh dài thứ 2

        for (int child : tree.get(node)) {
            // [QUANTRONG] dfs xuông node con trước sau đó mới kiếm tra trùng
            // vì kết quả có thể nằm dưới nhánh con

            // lúc này bai toán trở thành child 
            int childLen = dfs(child, tree, s);

            // no pair of adjacent nodes
            // kiểm tra 2 node liền kề
            if (s.charAt(node) == s.charAt(child)) {
                continue;
            }

            if (childLen > longest) {
                secondLongest = longest;
                longest = childLen;
            } else if (childLen > secondLongest) {
                secondLongest = childLen;
            }
        }

        // cập nhật kết quả global
        res = Math.max(res, longest + secondLongest + 1);

        /*
            tại sao không return longest + secondLongest + 1 ?
        
              X
             / \
            A   B

            dfs(A) = 2
            dfs(B) = 3
            
            kêt quả tại X = 3 + 2 + 1
          
            nhưng tại A và B chỉ cần return về longest + 1
        
         */
        return longest + 1;
    }
}
