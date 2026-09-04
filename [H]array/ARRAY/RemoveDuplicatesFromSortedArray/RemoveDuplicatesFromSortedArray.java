
public class RemoveDuplicatesFromSortedArray {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     */
    static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int i = 0, j = 1;

        while (i < j && j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4};
        System.out.println(removeDuplicates(nums)); // exception: 4

        int[] nums_2 = {2, 10, 10, 30, 30, 30};
        System.out.println(removeDuplicates(nums_2)); // exception: 3
    }
}
