import java.util.Arrays;

class CheapestFlightsWithinKStops {
    /*
        time O((k + 1) × e)
            - có k + 1 vòng lặp mỗi lần lặp duyệt toàn bộ e
            - worst case k = n 
            -> nên có thể ghi: O(n * e)

        space O(n)
    
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. khởi tạo
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] temp = dist.clone();

            for(int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                
                if (dist[from] == INF) {
                    continue;
                }

                temp[to] = Math.min(temp[to], dist[from] + price);
            }

            dist = temp;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}

/*
    1/ khởi tạo
    dist = [0, INF, INF, INF]


    2/ muốn có k điểm dừng thì phải có k + 1 edge

    DUYỆT LẦN 1
    
    temp = [0, INF, INF, INF]

    duyệt [0,1,100]
        - dist[0] = 0 
        - temp[1] = min(INF, 0 + 100) = 100
         temp = [0, 100, INF, INF]

    duyệt [1,2,100]
        - dist[1] = INF → bỏ qua

    duyệt [2,0,100]
        - dist[2] = INF → bỏ qua

    duyệt [1,3,600]
        - dist[1] = INF → bỏ qua

    duyệt [2,3,200]
        - dist[2] = INF → bỏ qua


    Sau vòng 1:
    dist = [0, 100, INF, INF]


    DUYỆT LẦN 2

    temp = [0, 100, INF, INF]

    duyệt [0,1,100]
        - dist[0] = 0 
        - temp[1] = min(100, 0 + 100) = 100
        temp = [0, 100, INF, INF]

    duyệt [1,2,100]
        - dist[1] = 100
        - temp[2] = min(INF, 100 + 100) = 200
        temp = [0, 100, 200, INF]

    duyệt [2,0,100]
        - dist[2] = INF → bỏ qua

    duyệt [1,3,600]
        - dist[1] = 100
        - temp[3] = min(INF, 100 + 600) = 700
        temp = [0, 100, 200, 700]

    duyệt [2,3,200]
        - dist[2] = INF → bỏ qua


    Sau vòng 2:
    dist = [0, 100, 200, 700]


    dst = 3

    trả về dist[dst] = 700

    tức đi từ 0 -> 1 -> 3


    tại sao không đi từ 0 -> 1 -> 2 -> 3 price chỉ có 400?
    vì có 3 edges tương ứng dừng 2 lần, mà yêu cầu là k = 1 tức chỉ được dừng tối đa 1 lần


    kết quả 700 sau 2 vòng for cho biết

    700 chính là kết quả tốt nhất trong tập có 2 edges
 */
