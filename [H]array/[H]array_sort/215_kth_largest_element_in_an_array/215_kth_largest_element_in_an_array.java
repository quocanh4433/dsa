import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    /*
        time O(nlogk)
        space O(k)

        có thể sư dụng maxHeap sau đó poll k - 1 lần
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }
}
