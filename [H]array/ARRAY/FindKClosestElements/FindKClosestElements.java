import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    /*
     * SOLUTION 1: TWO POINTER
     *
     * Ý tưởng
     *
     *      - Ban đầu cho toàn bộ mảng là window
     *
     *      - Giảm window còn k phần từ
     *
     *      - Array đã sắp xếp nên value ở left luôn nhỏ hơn value ở right;
     *
     *      - Nếu khoảng cách từ left tới x lớn hơn rigth tới x thì thu window từ left, ngược lại
     *
     *
     * 
     * Time complexity: O(n - k), k là số phần tử cần tìm
     * Space complexity: O(1)
     *
     * 
     * PROS: 
     *      - Dễ hiểu, dễ code - Trực quan (loại từng phần tử xa nhất).
     * CONS: 
     *      - Nếu n rất lớn mà k nhỏ → phải loại gần hết mảng → chậm hơn
     *
     *
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null) {
            return new ArrayList<>();
        }

        int l = 0;
        int r = arr.length - 1;

        while (r - l + 1 > k) {
            if ((Math.abs(arr[l] - x)) > (Math.abs(arr[r] - x))) {
                l++;
            } else {
                r--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }

        return res;

    }

    /*
     * SOLUTION 2: BINARY SEARCH + WINDOW
     * 
     * PROS: 
     *      - Cần hiểu binary search trên cửa sổ (khó hiểu hơn cho người mới).
     * CONS: 
     *      - Nhanh hơn khi n lớn, k nhỏ 
     *      - Đáp ứng đúng tie-breaking rule
     * 
     * 
     * QUAY LẠI LÀM CÁCH NÀY KHI HỌC ĐẾN BINARY SEARCH 
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 1, 2, 3, 4, 5};
        System.out.println(findClosestElements(nums, 4, 3)); // exception: {1, 2, 3, 4}
        System.out.println(findClosestElements(nums2, 4, -1)); // exception: {1, 1, 2, 3}
    }
}
