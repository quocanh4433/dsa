public class PowerOfFour_Recursion {
    /*
        Time O(log4n)
        Space: O(log4n)
    */

    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
    public static void main(String[] args) {
        
    }
}
