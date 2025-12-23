import java.util.Arrays;

public class SetMatrixZeroes {
    /*
        Time -> O(n * m)
        Space -> O(1)

        Ý TƯỞNG:
        Tạo 2 mảng cols và rows để quan sát
    */


    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        Arrays.fill(cols, 1);
        Arrays.fill(rows, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        for(int ir = 0; ir < rows.length; ir++) {
            if(rows[ir] == 0) {
                int k = 0;
                while(k < m) {
                    matrix[ir][k] = 0;
                    k++;
                }
            }
        }

        for(int ic = 0; ic < cols.length; ic++) {
            if(cols[ic] == 0) {
                int k = 0;
                while(k < n) {
                    matrix[k][ic] = 0;
                    k++;
                }
            }
        }

    }
    public static void main(String[] args) {
        
    }
}
