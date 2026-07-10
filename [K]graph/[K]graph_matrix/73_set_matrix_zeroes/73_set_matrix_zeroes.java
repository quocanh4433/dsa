import java.util.Arrays;

class SetMatrixZeroes {
    /*
        time    O(r * c)
        space   O(r + c)

        ý tưởng: 
        gặp 0 sẽ đánh dấu lại sau đó mới xóa
    
    */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        // đánh dấu vị trí xuất hiện số 0
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = 0;
                    cols[c] = 0;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            if (rows[r] == 0) {
                int k = 0;
                while (k < m) {
                    matrix[r][k] = 0;
                    k++;
                }
            }
        }

        for (int c = 0; c < m; c++) {
            if (cols[c] == 0) {
                int k = 0;
                while (k < n) {
                    matrix[k][c] = 0;
                    k++;
                }
            }
        }
    }
}
