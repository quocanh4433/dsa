
public class SearchA2DMatrix {

    /*
     * SOLUTION 1: BRAINSTORM
     * n: len(matrix)
     * m: len(matrixMid)
     * 
     * 🕓 Time complexity: O(log(n) + m) ~ O(m)
     * 💾 Space complexity: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0, right = matrix.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int[] matrixMid = matrix[mid];
            int first = 0;
            int last = matrixMid.length - 1;

            if (matrixMid[first] > target) {
                right = mid - 1;
            } else if (matrixMid[last] < target) {
                left = mid + 1;
            } else {
                for (int num : matrixMid) {
                    if (num == target) {
                        return true;
                    }
                }
                break;
            }
        }

        return false;
    }

    /*
     * SOLUTION 2: 2-BINARY SEARCH
     * 
     * 
     * 🕓 Time complexity: O(log(n) + log(m))
     * 💾 Space complexity: O(1)
     */
    public static boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0, right = matrix.length - 1;
        int[] row = new int[matrix[0].length];

        while (left <= right) {
            int mid = (right + left) / 2;
            int[] rowMid = matrix[mid];
            int first = 0;
            int last = rowMid.length - 1;

            if (rowMid[first] <= target && rowMid[last] >= target) {
                row = rowMid;
                break;
            } else if (rowMid[first] > target) {
                right = mid - 1;
            } else if (rowMid[last] < target) {
                left = mid + 1;
            }
        }

        int l = 0, r = row.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (row[m] == target) {
                return true;
            } else if (row[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }

        return false;
    }

    /*
     * SOLUTION 3: USING one BINARY SEARCH - NEETCODE
     * 
     * 🧠 Ý tưởng: xem array 2D như array 1D
     * 
     * 🕓 Time complexity: O(log(n) + log(m))
     * 💾 Space complexity: O(1)
     */
    public static boolean searchMatrix_3(int[][] matrix, int target) {
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(nums, 13));
        System.out.println("-");
        System.out.println(searchMatrix_2(nums, 13));
        System.out.println("-");
        System.out.println(searchMatrix_3(nums, 13));
    }
}
