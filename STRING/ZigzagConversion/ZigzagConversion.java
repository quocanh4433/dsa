
public class ZigzagConversion {

    /*
        Bản chất bài toán: ✅ Là bài toán mô phỏng quy luật lên – xuống
    
        Time: O(n)
        Space: O(n)
    
    */

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder[] rowString = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rowString[i] = new StringBuilder();
        }

        int row = 0;
        int dir = 1; // 1: đi xuống   và  -1: đi lên

        for (char c : s.toCharArray()) {
            rowString[row].append(c);

            if (row == 0) {
                dir = 1;
            } else if (row == numRows - 1) {
                dir = -1;
            }

            row += dir;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder str : rowString) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
