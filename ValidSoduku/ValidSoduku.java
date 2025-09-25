
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSoduku {

    /**
     * THIS CODE IS TOO LONG - SHORTER VERSION OF THE CODE IS BELOW
     */
    static boolean isValidSudoku_1(char[][] board) {
        // prob1: check dublicate in the row
        for (int i = 0; i < 9; i++) {
            Set<Character> tmp = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (tmp.contains(c)) {
                    return false;
                }
                tmp.add(c);
            }
        }

        // prob2: check dublicate in the col
        for (int i = 0; i < 9; i++) {
            Set<Character> tmp = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (tmp.contains(c)) {
                    return false;
                }
                tmp.add(c);
            }
        }

        // prob3: check dublicate in the sub-boxed
        int[][] starts = {
            {0, 0}, {0, 3}, {0, 6},
            {3, 0}, {3, 3}, {3, 6},
            {6, 0}, {6, 3}, {6, 6},};

        for (int[] s : starts) {
            int init_r = s[0];
            int init_c = s[1];
            Set<Character> tmp = new HashSet<>();

            for (int i = init_r; i < init_r + 3; i++) {
                for (int j = init_c; j < init_c + 3; j++) {
                    char c = board[i][j];
                    if (c == '.') {
                        continue;
                    }
                    if (tmp.contains(c)) {
                        return false;
                    }
                    tmp.add(c);
                }
            }
        }

        return true;

    }

    /**
     * SHORTER VERSION
     *
     * ✅ Ưu điểm: code ngắn, tiện test nhanh
     *
     * ❌ Nhược điểm: chậm, tốn bộ nhớ do tạo nhiều string
     */
    static boolean isValidSudoku_2(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }

                if (!seen.add(val + "in row" + r)
                        || !seen.add(val + "in col" + c)
                        || !seen.add(val + "in box" + (r / 3) + "-" + (c / 3))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * BETTER SOLUTION
     *
     * Time: O(n * n);
     */
    static boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> subBoxes = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            subBoxes.put(i, new HashSet<>());
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char value = board[r][c];

                if (value == '.') {
                    continue;
                }

                int idx_box = (r / 3) * 3 + (c / 3);
                System.out.println(idx_box);
                Set<Character> cur_row = rows.get(r);
                Set<Character> cur_col = cols.get(c);
                Set<Character> cur_box = subBoxes.get(idx_box);

                if (cur_row.contains(value) || cur_col.contains(value) || cur_box.contains(value)) {
                    return false;
                }

                cur_row.add(value);
                cur_col.add(value);
                cur_box.add(value);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] validBoard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoardBox = {
            {'5', '3', '9', '.', '7', '.', '.', '.', '.'}, // '9' trùng ô vuông con với hàng 2, cột 2
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(validBoard));
        System.out.println(isValidSudoku(invalidBoardBox));
        System.out.println(isValidSudoku_1(validBoard));
        System.out.println(isValidSudoku_2(invalidBoardBox));
    }
}
