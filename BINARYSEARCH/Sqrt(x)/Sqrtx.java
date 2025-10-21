package Sqrtx;

public class Sqrtx {

    /*
     * Time complexity: O(logn)
     * 
     * Sapce complexity: O(1)
     * 
     * ❓ Tại sao r = x / 2?
     * 👉 sqrt(x) thì kết quả CHỈ nằm trong khoảng [1, x/2]
     * VD: 
     * sqrt(4) = 2 -> 2 thuộc [1,2]
     * sqrt(16) = 4 -> 4 thuộc [1,8]
     * sqrt(8) = 2.8 -> 2.8 thuộc [1,4]
     */
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int l = 1, r = x / 2;
        int ans = x;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8)); // 2
        System.out.println(mySqrt(3)); // 1
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(0)); // 0
        System.out.println(mySqrt(1)); // 1
        /* FAIL AT TESTCASE Why type is "long square" not "int square"*/
        System.out.println(mySqrt(2147395599)); // 46339 
    }
}
