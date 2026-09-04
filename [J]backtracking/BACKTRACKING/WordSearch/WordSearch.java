public class WordSearch {
    /*
     * SOLUTION 1: BACKTRACKING - VISITTED ARAY
     * 
     */

    /*
     * SOLUTION 2: BACKTRACKING - OPTIONMAL
     * 
     * Time complexity: O(M * N * 4^L)
     * Space complexity: O(L)
     * 
     * M*N: array 2D
     * L: length of Word
     * 
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }
        // 01 Kiem tra bien trai
        if (i < 0 || j < 0) {
            return false;
        }
        // 02 Kiem tra bien phai
        if (i >= board.length || j >= board[0].length) {
            return false;
        }
        // 03 Kiem tra ky tu
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        // 01 + 02 + 03 có thể viết thành 1 dòng
        // if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, word, i + 1, j, idx + 1)
                || dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1);

        board[i][j] = temp;
        return found;
    }
    public static void main(String[] args) {
        char[][]board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word));
    }
}
