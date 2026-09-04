import java.util.ArrayList;
import java.util.List;

public class Permutation_ArrayBoolean {
    /*
        👍 CÁCH này dễ mở rộng
        👍 Xử lý số trùng nhau

        n: số thứ tụ -> có n! hoán vị

        Time: O(n * n!)
        Space: 
            O(n) : nếu không tính result
            O(n * n!) : vì thuật toán cần lưu n! hoán vị, mỗi hoán vị có n phần tử.
    
    
     */


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, result, used, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result,  boolean[] used, List<Integer> path) {
        // base case
        if(nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue; 
            
            used[i] = true;

            path.add(nums[i]);
            backtracking(nums, result, used, path);
            path.remove(path.size() - 1); // undo

            used[i] = false;
        }
    }
    public static void main(String[] args) {
        
    }
}
