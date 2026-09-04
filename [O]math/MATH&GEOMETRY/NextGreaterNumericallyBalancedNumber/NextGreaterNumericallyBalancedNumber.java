package NextGreaterNumericallyBalancedNumber;

public class NextGreaterNumericallyBalancedNumber {
    /*
     * SOLUTION 1: BRUTE FORCE
     * 
     * Time complexity: O(k × log n)
     * space complexity: O(1)
     * 
     * K: số lần thử
     * 
     */

    public static  int nextBeautifulNumber(int n) {
        for (int i = n + 1;; i++) {
            if (isBalance(i)) {
                return i;
            }
        }
    }

    public static boolean isBalance(int x) {
        int[] count = new int[10]; // [0,0,0,0,0,0,0,0,0,0]
        char[] chars = String.valueOf(x).toCharArray();

        // Đếm số lần xuất hiện 
        for (char c : chars) {
            count[c - '0']++;
        }

        // Loại những số không phải là balance
        for (int i = 0; i <= 9; i++) {
            if (count[i] != 0 && count[i] != i) {
                /*
                 * count[i] != 0: chỉ xét nhưng số có xuất hiện
                 * count[i] != i: sô thứ i KHONG xuất hiện đúng i lần
                 */
                return false;
            }
        }
        return true;
    }

    /*
     * SOLUTION 2: Pre-Generate
     * 
     * 
     */

     /*
     * SOLUTION 3: DFS
     * 
     * 
     */
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));
    }
}
