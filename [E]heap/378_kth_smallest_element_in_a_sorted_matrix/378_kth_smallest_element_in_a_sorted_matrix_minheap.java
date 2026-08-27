import java.util.PriorityQueue;

class KthSmallestElementInASortedMatrix_MinHeap {

    /*
        tương tự leetcode 23, 632
        
        cho ma trận n x m
        - ở mỗi hàng và cột các phần tử được sắp xếp tăng dần

        *** lưu ý:
        KHÔNG ĐẢM BẢO phần tử đầu tiên của hàng dưới phải lớn hơn phần tử cuối cùng của hàng trên 
        
        


        time O(nlogn)
        space O(n)


        minheap phù hợp khi k nhỏ
        nếu k ~ n^2 thi binary search tốt ơn do space chỉ O(1)
     */

    class Element {

        int val;
        int row;
        int col;

        Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int n = matrix.length;
        if (n * n < k) {
            return -1;
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> {
            // nếu cùng giá trị thi sắp xếp theo row
            if (a.val != b.val) {
                return Integer.compare(a.val, b.val);
            }
            return Integer.compare(a.row, b.row);
        });

        // đưa phần tử đầu tiên của mỗi hàng vào heap
        // for chạy n lần O(n)
        // mỗi lần offer O(logn)
        // time: O(nlogn)
        for (int r = 0; r < n; r++) {
            minHeap.offer(new Element(matrix[r][0], r, 0));
        }

        // chạy tối đa k lân O(k)
        // mỗi lần poll, offer O(log(n)) vi heap chứa n phần tử
        // time O(klogn)
        while (!minHeap.isEmpty()) {
            Element minEl = minHeap.poll();
            int row = minEl.row;
            int col = minEl.col;
            k--;

            if (k == 0) {
                return minEl.val;
            }

            if (col + 1 < n) {
                int nextVal = matrix[row][col + 1];
                minHeap.offer(new Element(nextVal, row, col + 1));
            }
        }

        return -1;
    }
}
