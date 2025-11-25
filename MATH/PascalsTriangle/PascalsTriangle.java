package MATH.PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    /**
     * Time compleixty: O(n^2)
     * 
     * Space Complexity (ngoài output) : O(n)
     * 
     * Space Complexity (bao gồm output) O(n²)
     * 
     * 
     * 
     * TẠI SAO SPACE O(n^2)
     * 
     * n = 5 → bạn lưu: 1 + 2 + 3 + 4 + 5 = 15 số
     * n = 1000 → bạn lưu: 500,500 số
     * 
     * -> n(n+1) / 2​ ≈ (n^2) / 2
     * 
     * - không quan tâm đến hệ số -> O(n^2)​
     * 
     * 
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(); // space: O(n)

        res.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) { // time: O(n)
            List<Integer> newRow = new ArrayList<>(); // space: O(n)
            newRow.add(1);

            for (int j = 1; j < i; j++) { // worst case j = n - 1 -> time: ~O(n)
                List<Integer> prevRow = res.get(i - 1);
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            newRow.add(1);
            res.add(newRow);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
