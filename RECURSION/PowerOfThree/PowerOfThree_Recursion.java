public class PowerOfThree_Recursion {
    /*
        Time O(log3n)
        Space: O(log3n) do call stack recursion
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        
    }
}
