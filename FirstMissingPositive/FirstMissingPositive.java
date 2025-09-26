
import java.util.Arrays;

public class FirstMissingPositive {

    /**
     * SOLUTION 1: Sort
     *
     * Time complexity: O(nlogn)
     *
     * Space complexity: O(1) or O(n) depend on the sorting algorithm
     *
     */
    static int firstMissingPositive_1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);
        int missing = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] == missing) {
                missing++;
            } else {
                return missing;
            }

            /**
             * Viết gọn code hơn = 1 dong if thay vì 2 như trên
             *
             * if(nums[i] > 0 && nums[i] == missing ) missing++;
             */
        }
        return missing;
    }

    /**
     * FOLLOW UP: You must implement an algorithm that runs in O(n) time and
     * uses O(1) auxiliary space.
     *
     * ------------------ BETTER SOLUTION ------------------
     * -----------------------------------------------------
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     */
    static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;

        /* step 1: clean array */
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = n + 1;
            }
        }

        /* step 2: mark each cell appearing in the array, by converting the index for that number to negative */
        for (int i = 0; i < n; i++) {
            int v = Math.abs(nums[i]);
            if (v >= 1 && v <= n) {
                nums[v - 1] *= -1;
            }
        }

        /* step 3: find the first cell which isn't negative (doesn't appear in the array) */
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int[] nums_2 = {3, 4, -1, 1};
        int[] nums_3 = {7, 8, 9, 11, 12};
        int[] nums_4 = {-1, 1, 3};
        System.out.println(firstMissingPositive_1(nums)); // exception: 3
        System.out.println(firstMissingPositive_1(nums_2)); // exception: 2
        System.out.println(firstMissingPositive_1(nums_3)); // exception: 1
        System.out.println("_________________________"); // exception: 3
        System.out.println(firstMissingPositive(nums)); // exception: 3 Testcase for reason why -> if (nums[i] >= 0) return i + 1;
        System.out.println(firstMissingPositive(nums_2)); // exception: 2  Testcase for why -> int v = Math.abs(nums[i]);
        System.out.println(firstMissingPositive(nums_3)); // exception: 1  
        System.out.println(firstMissingPositive(nums_4)); // exception: 2  
    }
}
