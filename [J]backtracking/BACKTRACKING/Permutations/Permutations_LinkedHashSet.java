import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations_LinkedHashSet {
    /*
        Nhược điểm LinkedHashSet
        ❌ Không sửa được khi nhiều số trùng nhau

        n: số thứ tụ -> có n! hoán vị

        Time: O(n * n!)
        Space: 
            O(n) : nếu không tính result
            O(n * n!) : vì thuật toán cần lưu n! hoán vị, mỗi hoán vị có n phần tử.
    
    
    */



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        backtracking(nums, result, set);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, Set<Integer> set) {
        // base case
        if(nums.length == set.size()) {
            result.add(new ArrayList<>(set));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) { // Bỏ qua số đang kiểm tra
                set.add(nums[i]);
                backtracking(nums, result, set);
                set.remove(nums[i]);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
