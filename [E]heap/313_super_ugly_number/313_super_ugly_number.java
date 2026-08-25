import java.util.PriorityQueue;

class SuperUglyNumber {

    /*
        phiên bản mở rộng 264 ugly number II

        *** 1/ lưu ý:
        Số 1 được xem là số ugly mặc định


        *** 2/ ý tưởng: 
        - lấy số ugly đã tìm thấy trước đó nhân với mảng prime
    
     */

 /*
        time O(nlogk)
        space O(n + k)
     */
    class Node {

        long val;
        int prime;
        int idx;

        Node(long val, int prime, int idx) {
            this.val = val;
            this.prime = prime;
            this.idx = idx;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        // *** step 1. khởi tạo mảnh result có kích thước n và result[0] = 1
        long[] ugly = new long[n];
        ugly[0] = 1;

        // *** step 2. tạo heap sắp xếp theo giá trị tăng dần
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.val, b.val));

        // mỗi prime nhân với ugly[0]
        for (int p : primes) {
            minHeap.offer(new Node((long) p * ugly[0], p, 0));
        }

        // *** step 3. 
        for (int i = 1; i < n; i++) {
            // số nhỏ nhất hiện tại
            long minVal = minHeap.peek().val;
            ugly[i] = minVal;

            // loại bỏ các phần từ trong heap == minVal để tránh trùng
            while (!minHeap.isEmpty() && minHeap.peek().val == minVal) { // tại sao cần kiểm tra điều kiện này?

                // lấy phần từ nhỏ nhất ra khỏi heap
                Node node = minHeap.poll();

                // tăng chỉ sô lên 1 chuyển sang ugly tiếp theo
                node.idx++;

                // tính giá trị ugly mới
                node.val = (long) node.prime * ugly[node.idx];

                // đẩy nút vừa cập nhật vào heap
                minHeap.offer(node);
            }
        }

        return (int) ugly[n - 1];
    }
}
