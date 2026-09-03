
class SearchA2DMatrix {

    /*
        lưu ý:
        - row sắp xếp tăng dần
        - item đầu row lớn hơn item cuối của row trước đó

        nhờ lưu ý số 2 mà có thể chuyển mảng 2D sang 1D

        công thức chuyển đổi
        row = mid / m
        col = mid % m

        dùng số cột cho cả row và col
        

        time O(log(n * m))
        space O(1)
    
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0;
        int right = r * c - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / c][mid % c]; // lưu ý dùng số cột để chia

            if (mid_val == target) {
                return true;
            } else if (mid_val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
