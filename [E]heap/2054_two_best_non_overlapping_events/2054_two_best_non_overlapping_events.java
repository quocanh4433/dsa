import java.util.Arrays;
import java.util.PriorityQueue;

class TwoBestNonOverlappingEvents {
        /*
        tương tựu problem 2008

        time O(nlogn)
        space O(n)

        n: số lượng sự kiện
     */
    public int maxTwoEvents(int[][] events) {
        // step 1: sắp xếp theo thời gian start tăng dần
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // step 2: đưa vào min_heap theo end_time
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // value tốt nhất của 1 event đã kết thúc
        // tai sao cần biến này để tránh duyệt toàn bộ event cũ
        int maxValueSoFar = 0;

        // tại sao cần biến này ?
        // do yếu cầu chỉ tim max value của tối đa 2 sự kiện
        int maxTwoSum = 0;



        for(int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            // giải phóng các event đã kết thúc trước đó
            while(!minheap.isEmpty() && minheap.peek()[0] < start ) {
                maxValueSoFar = Math.max(maxValueSoFar, minheap.poll()[1]);
            }

            // trường hợp 1: Kết hợp sự kiện hiện tại với sự kiện đơn tốt nhất đã kết thúc trước đó
            // trường hợp 2: Chỉ lấy đúng 1 sự kiện hiện tại 
            maxTwoSum = Math.max(maxTwoSum, maxValueSoFar + value);

            // đưa event hiên tại vào heap với value mới
            minheap.add(new int[]{end, value});
        }

        return maxTwoSum;
    } 
}
