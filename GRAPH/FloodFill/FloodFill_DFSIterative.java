
import java.util.Stack;

public record FloodFill_DFSIterative() {

    /*
     * DEPTH FIRST SEARCH ITERATIVE
     * 
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int r = cur[0];
            int c = cur[1];

            image[r][c] = color;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                // nếu hợp lệ và là màu cũ → push vào stack
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                    stack.push(new int[]{nr, nc});
                }
            }
        }

        return image;
    }


    /*
     * GIẢI VỚI ĐẸ QUY
     * 
     * 
     * 
     */
    public static void main(String[] args) {

    }
}
