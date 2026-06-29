
import java.util.*;

class Solution {
    /*
        n: node
        e: edge

        - build graph O(n + e)
        - Dijkstra
            - offer: O(E log V)
            - poll : O(E log V)
            - relax edges: O(E)
            => Dijkstra = O(E log V)


        -> O(n + e + elogn) mà elogn >> e
        -> O(n + elogn) mà elogn >> n
        -> O(elgn)

        suy ra time: O(elogn)



        - graph O(n + e)
        - dist O(n)
        - pq O(e) tại sao không phải O(n)
            - do mỗi edge gây ra 1 lân push

        suy ra space O(n + e)


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
        List<List<double[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            double p = succProb[i];
            graph.get(u).add(new double[]{(double) v, p});
            graph.get(v).add(new double[]{(double) u, p});
        }

        // prob[i] xác suất cao nhất đi tới từ start tới i
        double[] prob = new double[n];
        prob[start_node] = 1.0;

        // sắp xếp xác suất cao nhất lên trên
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.offer(new double[]{1.0, (double) start_node});

        while(!pq.isEmpty()) {
            double[] cur = pq.poll();
            double curprop = cur[0];
            int node = (int) cur[1];

            // đi dến node end thì trả về kết quả
            if(node == end_node) return curprop;

            if(prob[node] > curprop) continue;

            for(double[] next : graph.get(node)) {
                int v = (int) next[0];
                double newprop = next[1] * curprop; 
                
                if(newprop > prob[v]) { // tìm thấy đường đi có xác suất cao hơn
                    prob[v] = newprop;
                    pq.offer(new double[]{newprop, (double) v});
                }
            }
        }

        return 0.0;
     }
}
