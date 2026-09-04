import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /*
     * SOLUTION 1: BACKTRACKING
     * 
     * Time complexity: O(n^(T/m))
     * Space complexity: O(n^(T/m))
     * 
     * T: giá trị target
     * m: giá trị của các phần tử nhỏ nhất (min(candidates))
     * 
     * 👉 Tại sao T/m?
     * Mỗi lần ta thêm một số ≥ m,    → target giảm ít nhất m.
     * 
     * 
     * 👉 Tại sao trong neetcode time và space là O(2^(T/m)) ?
     * O(2^(T/m)) là cách viết “đơn giản hóa”, thường gặp trong lời giải phổ thông.
     * 
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, 0, curr, res);
        return res;
    }
    public void backtrack(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            // 👉 Tại sao res.add(curr)? ❌
            // Nhưng curr là list tham chiếu, nó sẽ tiếp tục bị thay đổi khi quay lui (curr.remove(...)).
            // Cần tạo thêm bản sao
            res.add(new ArrayList<>(curr)); // ✅
            return;
        }
        
        if(target < 0) return;

        for(int k = idx; k < candidates.length; k++) {
            curr.add(candidates[k]);
            backtrack(candidates, target - candidates[k], k, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    /*
     * SOLUTION 2: BACKTRACKKING - OPTIMAL
     * 
     * 👉 Vấn đề solution 1 là gì?
     * Cắt nhánh trễ
     * 
     * 👉 Cải thiện như thế nào?
     * 
     * 
     * 
     */
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates); // ✅ sort để cắt nhánh sớm
        backtrack(candidates, target, 0, curr, res);
        return res;
    }
    public void backtrack_2(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int k = idx; k < candidates.length; k++) {
            // ✅ Cắt nhánh — vì mảng đã sort nên các phần tử sau sẽ lớn hơn
            if (candidates[k] > target) break;
            
            curr.add(candidates[k]);
            backtrack(candidates, target - candidates[k], k, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
