
class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    /*
        ý tưởng 
        
        nếu các node liên kết với nhau sẽ nằm cùng nhóm

        time: 
            init parent and size: O(n)
            union + find        : O(m * n)
            tạo result          : O(n)
              
        space: O(n)

        n: số node
        m: số cạnh
    
     */

    private int[] parent;
    private int[] size;

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (size[pa] < size[pb]) { // "số lượng node của pa nhỏ hơn pb"
            // nên swap đề
            // pa luôn là root của cây lớn
            // pb luôn là root của cây nhỏ
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        // cây nhỏ - gắn vào cây lớn 
        parent[pa] = pb;
        size[pb] += size[pa];
    }

    private int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }

        return parent[x];
    }

    public long countPairs(int n, int[][] edges) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) { // 
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        long result = 0;
        long remain = n; // số node chưa xử lý

        /*
            tại sao dùng long?
                worst-case n = 100,000 và các node riêng lẻ không liên kết với nhau

                suy ra mỗi node sẽ không kết nối với 99,999 còn lại, mà có 100,0000 node

                -> result = (100,000 * 99,999) / 2 
                -> result ~ 5 tỷ vượt qua int (~2.2ty)


            tại sao chia 2?
                vì cặp node (A, B) và (B, A) được tính là 1
         */
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) { // chinhs là root
                remain -= size[i];
                result += (long) size[i] * remain;
            }
        }

        return result;
    }
}



/*

input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]


parent = [0, 1, 2, 3, 4, 5, 6]
size = [1, 1, 1, 1, 1, 1, 1]


union([0, 2])
    p0 = 0
    p2 = 2
    khac: 
        size[p0] = 1
        size[p2] = 1

        size[p0] == size[p2]
        không làm gì

        parent[2] = 0;
        size[0] += size[2]

        parent = [0, 1, 0, 3, 4, 5, 6]
        size = [2, 1, 1, 1, 1, 1, 1]

union([0, 5])
    p0 = 0
    p5 = 5
    khac: 
        size[p0] = 2
        size[p5] = 1

        size[p0] > size[p5]
        không làm gì

        parent[5] = 0;
        size[0] += size[5]

        parent = [0, 1, 0, 3, 4, 0, 6]
        size = [3, 1, 1, 1, 1, 1, 1]

union([2, 4])
    p2 = 0
    p4 = 4
    khac: 
        size[p2] = 3
        size[p4] = 1

        size[p2] > size[p4]
        không làm gì

        parent[4] = 0;
        size[0] += size[4]

        parent = [0, 1, 0, 3, 0, 0, 6]
        size = [4, 1, 1, 1, 1, 1, 1]

union([1, 6])
    p1 = 1
    p6 = 6
    khac:
        size[p1] = 1
        size[p6] = 1

        size[p1] == size[p6]
        không làm gì

        parent[6] = 1;
        size[1] += size[6]

        parent = [0, 1, 0, 3, 0, 0, 1]
        size = [4, 2, 1, 1, 1, 1, 1]

union([5, 4])
    p5 = find(5) -> find(0) = 0
    p4 = find(54 -> find(0) = 0
    giống bỏ qua không union


SAU KHI UNION

parent = [0, 1, 0, 3, 0, 0, 1] cho biết node chung nhóm 
size = [4, 2, 1, 1, 1, 1, 1] cho biết số kết nối để tính toán sau này




 */