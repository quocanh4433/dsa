import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    /*
     * SOLUTION 1: BACKTRACKING ARRAY 2D -> TLE
     * 
     * Fail at testcase 63
     * 
     */
    public List<String> findWords_SOLUTION1(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;
        List<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < ROWS && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] != word.charAt(0)) continue;
                    if (backtrack_SOLUTION1(board, r, c, word, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean backtrack_SOLUTION1(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] != word.charAt(i))
            return false;

        board[r][c] = '*';
        boolean isFound = backtrack_SOLUTION1(board, r + 1, c, word, i + 1) ||
                      backtrack_SOLUTION1(board, r - 1, c, word, i + 1) ||
                      backtrack_SOLUTION1(board, r, c + 1, word, i + 1) ||
                      backtrack_SOLUTION1(board, r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return isFound;
    }

    /*
     * SOLUTION 2: BACKTRACKING  (TRIE) 
     * 
     * Time compleixty: O(M × N + W × L)
     * space complexity: O(W × L)
     * 
     *      - Mỗi từ W có độ dài L, 
     *      - M: rows , N : cols
     */

    class TrieNode {
        TrieNode[] children;
        String word; 
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String w : words) {
            TrieNode node = root;
            for(char c : w.toCharArray()) {
                int idx = c - 'a';
                if(node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = w; // Lưu lại từ hoàn chỉnh ở node cuối cùng
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int ROWS = board.length;
        int COLS = board[0].length;
        List<String> res = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, res);
            }
        }
    
        return res;
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];
        if(ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        // Đi xuống TrieNode bên dưới
        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // Ngăn duplicate (trùng word)
        }

        board[r][c] = '#'; // Đánh dấu đã dùng
        dfs(board, r + 1, c, node, res);
        dfs(board, r - 1, c, node, res);
        dfs(board, r, c + 1, node, res);
        dfs(board, r, c - 1, node, res);
        board[r][c] = ch; // Phục hồi
    }
    



    public static void main(String[] args) {
        
    }
}
