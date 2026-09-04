
public class RotateImage_ReverseAndTranspose {

    /*
        Time -> O(n^2)
        Space -> O(1)

    */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Chuyên row sang col (transcope)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
