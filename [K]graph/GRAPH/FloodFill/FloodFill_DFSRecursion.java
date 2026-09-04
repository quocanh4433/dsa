
public class FloodFill_DFSRecursion {

    /*
     * RECUSRSION
     * 
     * 
     * NHƯỢC ĐIỂM:
     * 
     * - Do constrains theo leetcode:   1 <= colLength, rowLength <= 50. ⚠️ Nên sử dụng recursion vẫn được
     * 
     * - Nếu constrains 1 <= colLength, rowLength <= 10000 
     * 
     * => Time complexity: O(colLength * rowLength) = O(10^8)❌
     * => Space complexity: O(colLength * rowLength) = O(10^8)❌
     * => Stackoverflow
     * 1 int = 4 bytes → 400 MB❌
     * 
     */
    private int oldColor;
    private int newColor;
    private int colLength;
    private int rowLength;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        colLength = image.length;
        rowLength = image[0].length;
        oldColor = image[sr][sc];
        newColor = color;

        // Nếu màu mới giống màu cũ thì không cần làm gì
        if (oldColor == color) {
            return image;
        }

        dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int r, int c) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }

        // Nếu ô này không phải màu cần thay thì bỏ qua
        if (image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r + 1, c);
        dfs(image, r - 1, c);
        dfs(image, r, c + 1);
        dfs(image, r, c - 1);
    }

    public static void main(String[] args) {

    }
}
