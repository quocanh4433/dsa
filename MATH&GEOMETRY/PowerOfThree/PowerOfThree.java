package MATH.PowerOfThree;

public class PowerOfThree {
    /*
     * Time complexity: O(log3n) ~ O(logn)
     * Space: O(log3n) ~ O(logn)
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) {
            return true;
        }
        if (n % 3 != 0 || n <= 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }


    /*
     * Time complexity: O(log3n) ~ O(logn)
     * Space complexity: 1
     */

     public boolean isPowerOfThree_2(int n) {
        while (n > 1) {
            if(n % 3 != 0) return  false;
            n = n / 3;
        }

        return n == 1;
     }
    public static void main(String[] args) {
        
    }
}
