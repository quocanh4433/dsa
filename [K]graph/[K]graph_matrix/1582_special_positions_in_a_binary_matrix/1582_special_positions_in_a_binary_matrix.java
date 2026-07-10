
class SpecialPositionsInABinaryMatrix {
    /*
        time O(r * c)
        space O(r + c)
    */
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == 1) {
                    rows[r]++;
                    cols[c]++;
                }
            }
        }

        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if(mat[r][c] == 1 && rows[r] == 1 && cols[c] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}