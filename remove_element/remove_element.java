
public class remove_element {

    /*
        Remove Element
        You are given an integer array nums and an integer val. Your task is to remove all occurrences of val from nums in-place.

        After removing all occurrences of val, return the number of remaining elements, say k, such that the first k elements of nums do not contain val.

        Note:
        The order of the elements which are not equal to val does not matter.
        It is not necessary to consider elements beyond the first k positions of the array.(Không cần quan tâm đến các phần từ nằm sau k)
        To be accepted, the first k elements of nums must contain only elements not equal to val.
        Return k as the final result.

        Example 1:
        Input: nums = [1,1,2,3,4], val = 1
        Output: [2,3,4]
        Explanation: You should return k = 3 as we have 3 elements which are not equal to val = 1.

        Example 2:
        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: [0,1,3,0,4]
        Explanation: You should return k = 5 as we have 5 elements which are not equal to val = 2.

        Constraints:
        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100

     */
 /*
     * SOLUTION 1: two pointer
     * 
     * first pointer: traverse array i 
     * seconde pointer to count k
     * 
     * 
     * Time complexity O(n)
     * Space complexity O(1)
     * 
     * 
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /*
     * SOLUTION 2: descrease length of array
     */
    public static int remvoElement_2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                ++i;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int k = removeElement(new int[]{1, 1, 2, 4, 3}, 1);
        int p = remvoElement_2(new int[]{1, 1, 2, 4, 3},
                1);
        System.out.println("k = " + k + ", p = " + p);
    }
}
