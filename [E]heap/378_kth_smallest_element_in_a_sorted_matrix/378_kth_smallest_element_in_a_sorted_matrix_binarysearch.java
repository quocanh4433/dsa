
class KthSmallestElementInASortedMatrix_BinarySearch {

        /*
        tương tự leetcode 23, 632
        
        cho ma trận n x m
        - ở mỗi hàng và cột các phần tử được sắp xếp tăng dần

        ý nghĩa sắp xếp tăng dân theo hang và cột cho biết
        - chắc chắn matrix[0][0] là nhỏ nhất và matrix[n-1][n-1] lớn nhất



        minheap phù hợp khi k nhỏ
        nếu k ~ n^2 thi binary search tốt ơn do space chỉ O(1)



        time O(nlog(matrix[0][0] - matrix[n - 1][n - 1]))
        space O(1)
     */

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(countLessOrEqual(matrix, mid, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // lúc nay return low hay high đêu được
    }

    public int countLessOrEqual (int[][] matrix, int mid, int n) {
        int count = 0;
        int row = n - 1;
        int col = 0;

        while(col < n && row >= 0) {
            if(matrix[row][col] <= mid) { // do các số có thể trung nhau nên cần kiêm tra điều kiện bằng
                count += (row + 1); // tất cả các phần tử ở trên đều nhỏ hơn matrix[row][col]
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
