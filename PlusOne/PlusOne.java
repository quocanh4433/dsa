
import java.util.Arrays;

public class PlusOne {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(1) nếu không tính output newDigits. O(n + 1) new tính
     * output
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {4, 9, 9};
        int[] nums3 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums))); // exception: [1, 2, 4]
        System.out.println(Arrays.toString(plusOne(nums2))); // exception: [5, 0, 0]
        System.out.println(Arrays.toString(plusOne(nums3))); // exception: [1, 0, 0, 0]
    }
}
