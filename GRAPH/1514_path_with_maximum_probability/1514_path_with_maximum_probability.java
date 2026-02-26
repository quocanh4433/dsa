
import java.util.*;

class Solution {

    /*
        time: O(elogv)
        space: O(e + v)


        - Dijkstra truyền thống	
            ▪︎ Khoảng cách nhỏ nhất	
            ▪︎ Cộng trọng số	
            ▪︎ Min-heap	

        - Bài này
            ▪︎ Xác suất lớn nhất
            ▪︎ Nhân xác suất
            ▪︎ Max-heap
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // build graph
        List<double[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][0];
            int targetNode = edges[i][1];
            double p = succProb[i];

            // do undirected graph nên thêm 2 lần
            graph[node].add(new double[]{targetNode, p});
            graph[targetNode].add(new double[]{node, p});
        }

        // phân quan trọng của dijkstra
        // prob[i] xác suất cao nhất đi tới từ start tới i
        double[] prob = new double[n];
        prob[start_node] = 1.0;

        // max-heap probability
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int curNode = (int) cur[0];
            double curProb = cur[1];

            // đi dến node end thì trả về kết quả
            if (curNode == end_node) {
                return curProb;
            }

            // bỏ qua nếu xác suất hiện tại thấp hơn xác suất trước đó
            if (prob[curNode] > curProb) {
                continue;
            }

            // đi qua nhưng node kết cấn curNode
            for (double[] next : graph[curNode]) {
                int v = (int) next[0];
                double p = next[1];
                double newProb = p * curProb;

                if (newProb > prob[v]) {
                    prob[v] = newProb;
                    pq.offer(new double[]{v, newProb});
                }
            }
        }

        return 0.0;
    }
}
