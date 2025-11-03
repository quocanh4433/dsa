
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

    /*
     * 💡 IDEA: Chỉ giữ heap.size() === k. Muốn tìm sô điểm lớn thứ 4 => heap.size() <= 4;
     * 
     * Time complexity: O(m * logk)
     * Space complexity: O(k)
     * 
     * M: number of call add()
     * 
     */
    class KthLargest {

        private Queue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.minHeap = new PriorityQueue<>();
            this.k = k; // 👉 Tại sao ở đây cần this.k?
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) { // 👉 Tại sao ở đây không cần this.k?
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }

            return minHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}
