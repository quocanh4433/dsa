import java.util.PriorityQueue;

class MaximumNumberOfEatenApples {

    /*
        apples[i]: is number of apples that you grow on ith day
        days[i]: the maximun number of days the the apples grown on ith day can be eaten  

        time O(nlogn)
        sapce O(n)

        n: number of days
     */
    public int eatenApples(int[] apples, int[] days) {
        // int[] {expire_day, number_of_apple}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int currentDay = 0;
        int n = days.length;

        // vòng lặp chạy đến khi vẫn còn hái HOẶC còn táo trong kho
        while (currentDay < n || !pq.isEmpty()) {
            // 1. thu hoạch táo khi currentday không phải ngày cuối và cây hôm đó có thêm táo
            if (currentDay < n && apples[currentDay] > 0) {
                // nếu offer vào minheap các phân từ cso trùng ngày expire>
                pq.offer(new int[]{currentDay + days[currentDay], apples[currentDay]});
            }

            // 2. bỏ táo hư
            while (!pq.isEmpty() && pq.peek()[0] <= currentDay) {
                pq.poll();
            }

            // 3. ưu tiên ăn táo sắp hư
            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                curr[1]--; // giảm số lượng
                count++;

                // nếu vẫn còn táo thì đẩy vào heap
                if (curr[1] > 0) {
                    pq.offer(curr);
                }
            }

            currentDay++;
        }

        return count;
    }
}
