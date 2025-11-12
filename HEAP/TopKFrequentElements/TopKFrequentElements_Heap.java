package HEAP.TopKFrequentElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements_Heap {

    /*
     * Time complexity: O(nlogk)
     * 
     * Space complexity: O(n)
     * 
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < k) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();  // space: O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // space: O(k)

        for (int key : map.keySet()) { // time: O(n) + heapify O(logk) -> O(nlogk)
            int freq = map.get(key);
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{key, freq});
                continue;
            } else if (freq > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.offer(new int[]{key, freq});
            }
        }

        int[] res = new int[k]; // space: O(k)

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
