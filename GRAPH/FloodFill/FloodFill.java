
import java.util.LinkedList;
import java.util.Queue;

public record FloodFill() {

    /*
     * BREATH FIRST SEARCH (NOT USING RECURSION)
     * 
     * 🧩 Why not using recursion?
     * Dễ bị Stack Overflow (tràn stack)
     * Đệ quy lồng quá nhiều layer → khó theo dõi flow.
     * 
     * 
     * 🧩 Ưu và nhược điểm khi dùng adjacency matrix để biểu thị graph ?
     * Tốn bộ nhớ: O(V²)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    q.offer(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }

        }

        return image;
    }

    /*
     * THAY ĐỔI CODE MỘT CHÚT - GỌN HƠN
     * 
     */
    public int[][] floodFill_2(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        // image[sr][sc] = color; // ⚠️ Không cần phần nay

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            image[r][c] = color; // ✅ Thêm phần này

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    q.offer(new int[]{nr, nc});
                    // image[nr][nc] = color; // ⚠️ Không cần phần nay

                }
            }

        }

        return image;
    }

    public static void main(String[] args) {

    }
}
