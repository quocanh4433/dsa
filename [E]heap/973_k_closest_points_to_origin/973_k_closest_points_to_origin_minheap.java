import java.util.PriorityQueue;

class KClosestPointsToOrigin_MinHeap {

     /*
        n: number of point
        worst case k == n

        time O(nlogn)
        space O(n)

        cách này lãng phí bộ nhớ nếu n = 10_000 mà k = 1

        chuyển sang maxheap
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
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        for (int[] p : points) { // time: O(nlogn)
            int x = p[0];
            int y = p[1];
            int dist = x * x + y * y;
            minHeap.offer(new Pair(p, dist));
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) { // time: O(klogn)
            res[i] = minHeap.poll().point;
        }

        return res;
    }
}
