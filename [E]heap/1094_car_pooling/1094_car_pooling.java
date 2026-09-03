import java.util.Arrays;
import java.util.PriorityQueue;

class CarPooling {
     /*
        time O(nlogn)
        space O(n)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        // minheap cho biêt chuyến trả khách sớm nhất
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        int current_capacity = 0;

        for(int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            // int to = trip[2];

            // trả khách ở nhưng chuyến đã hoàn thành
            while(!minheap.isEmpty() && minheap.peek()[2] <= from) {
                current_capacity -= minheap.poll()[0];
            }

            // đón khách mới
            current_capacity += numPassengers;

            // kiểm tra quá tải
            if(current_capacity > capacity) return false;

            minheap.offer(trip);    
        }

        return true;
    }
}
