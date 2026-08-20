
import java.util.PriorityQueue;

class MaximumLengthOfPairChain {

    /*
        time O(nlogn)
        space O(n)
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] pair : pairs) {
            minHeap.offer(pair);
        }

        int count = 0;
        int currentEnd = Integer.MIN_VALUE;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            if (curr[0] > currentEnd) {
                count++;
                currentEnd = curr[1];
            }

        }

        return count;
    }
}
