import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    /*
        BEST SOLUTION

        Time: O(n)
        Space: O(1) (không tính list kết quả)


        Mục tiêu thật là:
        Sau khi sort, các phần tử < target, = target, > target sẽ nằm ở đâu?
        👉 Nếu bạn hiểu tính chất của mảng đã sắp xếp, bạn sẽ bỏ được bước sort tốn O(n log n).

        Kiểm tra việc bạn có biết:
        - Chỉ cần đếm số phần tử nhỏ hơn target
        - Và đếm số phần tử bằng target
        👉 Là đã xác định được toàn bộ vị trí cần tìm.
    */

    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0, equal = 0;

        for(int num : nums) {
            if(num < target) less++;
            else if(num == target) equal++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < equal; i++) {
            res.add(i + less);
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
