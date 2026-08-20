import java.util.Arrays;
import java.util.PriorityQueue;

class MaximumEarningsFromTaxi {

    /*
        time O(mlogm)
        space O(m)

        m: số chuyến đi
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        // Step 1: sắp xếp theo start_time tăng dần
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: sắp xếp min_heap theo cặp [end_time, lợi nhuậ tích lũy]
        // end_time tăng dần
        PriorityQueue<long[]> min_heap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long prevProfit = 0; // lợi nhuận trước đó
        long bestProfit = 0; // lợi nhuận tốt nhất của toàn bộ điểm đi qua

        for (int[] ride : rides) {
            int start = ride[0];
            int end = ride[1];
            int tip = ride[2];

            // Xử lý tất cả các chuyến đi trong heap đã hoàn thành trước hoặc tại thời điểm start
            while (!min_heap.isEmpty() && min_heap.peek()[0] <= start) {
                long[] prev = min_heap.poll();
                prevProfit = Math.max(prevProfit, prev[1]);
            }

            // lợi nhuận tích lũy hiện tại
            long currentProfit = prevProfit + (end - start + tip);

            min_heap.offer(new long[]{end, currentProfit});

            bestProfit = Math.max(bestProfit, currentProfit);
        }

        return bestProfit;
    }
}
