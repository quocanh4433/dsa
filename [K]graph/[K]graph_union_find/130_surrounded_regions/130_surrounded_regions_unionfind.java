
class SurroundedRegions_UnionFind {

    /*
        time O(n * m)
        space O(n * m)

        ý tưởng
        
        duyệt ma trận lần 1:
            - union nhưng node ở biên với node dummy 
            - nhưng node hợp lệ nối với nhau

        duyệt ma trận lần 2:
            - nêu node bằng 'O' và find(node) != dummy tức là node hợp lệ chuyển thành 'X'

     */

    private int n;
    private int m;
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[] parent;

    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;

        int dummy = n * m;
        this.parent = new int[n * m + 1];

        for (int i = 0; i <= dummy; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (board[r][c] == 'X') {
                    continue;
                }

                int cur = r * m + c;

                // on the edge
                if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
                    union(cur, dummy);
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (hasOutside(nr, nc) || board[nr][nc] == 'X') {
                        continue;
                    }
                    int next = nr * m + nc;
                    union(cur, next);
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'X') {
                    continue;
                }

                int cur = r * m + c;

                if (find(cur) == find(dummy)) {
                    continue;
                }

                board[r][c] = 'X';
            }
        }

    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return;
        }
        parent[rootU] = rootV;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean hasOutside(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}
