import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // Time complexity: O(729) -> O(1)
    // Space complexity: O(729) -> O(1)
    // Tại sao 729?
    // n < 2^31 -1 
    // tông bình phương là của 9 số 9 = 729

    // “Happy Number là phiên bản số học của Linked List Cycle.”
    static Set<Integer> cache = new HashSet<>();
    public static  boolean isHappy(int n) {
        int sum = squaredSum(n);
        if(sum == 1) return true;
        if(cache.contains(sum)) return false;
        cache.add(sum);
        return isHappy(sum);
    }

    public static  int squaredSum(int n) {
        int sum = 0;
        while(n >= 1) {
            int num = n % 10;
            sum += num*num;
            n /= 10;
        }
        return sum;
    }

    /*
     * SOLUTION 2: Dùng Floyd’s Cycle Detection (rùa–thỏ)
     * 
     */

    public static void main(String[] args) {
        System.out.println(isHappy(7)); // true
        System.out.println(isHappy(52)); // false
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2)); // true
    }
}
