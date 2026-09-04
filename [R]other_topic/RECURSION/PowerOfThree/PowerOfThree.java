public class PowerOfThree {
    /*
        Time: O(log3n) ~ O(logn) do BigO không quan tâm cơ số
        Space:O(1)
    
    */
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        
    }
}
