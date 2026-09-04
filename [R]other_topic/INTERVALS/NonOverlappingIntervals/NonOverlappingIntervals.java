
import java.util.Arrays;

public class NonOverlappingIntervals {

    /*
        Time -> O(nlogn)
        Space -> O(1) or O(n) depending on the sorting algorithm.
    */

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        /*
            👉 Tại sao lại sắp xếp tăng dần theo thời gian kết thúc ?

            Nếu bạn giữ 1 interval kéo dài quá lâu:
                → Chồng lên nhiều interval khác
                → Khiến bạn phải remove nhiều hơn
            
            VD: [1,100], [2,3], [4,5]   ->    [2,3], [4,5], [1,100]

            Khi sắp xếp tăng dần theo thời gian kết thúc mình chỉ cần remove đi [1,100]
            

        */


        int remove = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];

            if (curr[0] < prevEnd) {
                remove++;
            } else {
                // Không chồng → cập nhật end
                prevEnd = curr[1];
            }
        }
        return remove;
    }

    public static void main(String[] args) {

    }
}
