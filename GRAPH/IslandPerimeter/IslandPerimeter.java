package GRAPH.IslandPerimeter;

public class IslandPerimeter {

    /*
     * 💡 IDEA: 
     * 
     * Mặc định ô == 1 có perimeter = 4. Sau đó trừ dần perimeter theo điều kiện 
     * Nếu ô đó có 1 hàng xóm cũng là đất, thì 2 ô chia sẻ 1 cạnh, nên ta trừ đi 2 cạnh (mỗi ô mất 1 cạnh).
     * 
     * 
     * 🧩 Tại sao xét theo cặp TRÊN + TRÁI mà không xét theo cặp DƯỚI + PHẢI?
     * Xét theo cặp nào cũng đúng chỉ khác điều kiện một chút
     * 
     * 
     * 🧩 Tại sao không xét theo cặp TRÊN + DƯỚI hoặc TRÁI + PHẢI?
     * Xem file explain.md
     * 
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // XÉT THEO DƯỚI + PHẢI
                    // If cell to the right is also land
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }

                    // If cell below is also land
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // XÉT THEO TRÊN + TRÁI
                    // if (j > 0 && grid[i][j - 1] == 1) {
                    //     perimeter -= 2;
                    // }
                    // if (i > 0 && grid[i - 1][j] == 1) {
                    //     perimeter -= 2;
                    // }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {

    }
}
