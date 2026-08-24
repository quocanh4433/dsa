
import java.util.PriorityQueue;

class KClosestPointsToOrigin_MinHeap {

    /*
        ưu điểm maxheap chỉ lưu k phần tử

        bước 1: lưu từng point vào maxheap

        bước 2: nếu số phần từ vượt quá k thì poll(). do phần từ năm đầu tiên trong maxheap là phần từ xa nhất

        n: number of point
        worst case k == n

        time O(nlogn)
        space O(k)
     */
    class Pair {

        int[] point;
        int dist;

        Pair(int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            int dist = x * x + y * y;
            
            maxHeap.offer(new Pair(p, dist));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().point;
        }

        return res;
    }
}
