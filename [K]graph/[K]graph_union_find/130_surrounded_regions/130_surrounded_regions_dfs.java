import java.util.LinkedList;
import java.util.Queue;

class SurroundedRegions_DFS {

    /*
        time O(n * m)
        space O(n * m)
     */

    private int n;
    private int m;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private char[][] board;

    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;

        // first row and last row
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                bfs(0, c);
            }

            if (board[n - 1][c] == 'O') {
                bfs(n - 1, c);
            }
        }

        // first col and last col
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') {
                bfs(r, 0);
            }

            if (board[r][m - 1] == 'O') {
                bfs(r, m - 1);
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

            }
        }
    }

    public void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        board[r][c] = '#';

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];

                if (hasValid(nr, nc) && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

    }

    public boolean hasValid(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return false;
        }
        return true;
    }
}
