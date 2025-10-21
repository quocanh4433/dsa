package SingleElementInASortedArray;

public class SingleElementInASortedArray {

    /*
     * SOLUTION 1: BRAINSTORM
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int j = 1;
        int res = 0;
        int n = nums.length;

        while (i < j && j < n) {
            if (nums[i] != nums[j]) {
                res = nums[i];
                i++;
                j++;
            } else {
                i += 2;
                j += 2;

                if (j > n && i < n) {
                    return nums[i]; // [1,1,2]
                }
            }
        }
        return res;
    }

    /*
     * SOLUTION 2: BINARY SEARCH
     * 
     * Time complexity: O(logn)
     * Space complexity: O(1)
     */
    public static int singleNonDuplicate_2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            boolean equalLeft = middle > 0 && nums[middle] == nums[middle - 1];
            boolean equalRight = middle < n - 1 && nums[middle] == nums[middle + 1];

            if (!equalLeft && !equalRight) {
                return nums[middle];
            }

            if ((equalLeft && middle % 2 == 0) || (equalRight && middle % 2 != 0)) { // [1,1,2,3,-*3*-,8,8] || [1,1,2,-*3*-,3,8,8]
                right = middle - 1;
            } else {
                left = middle + 1;
            }

            // if (!equalLeft && middle % 2 != 0) {  // [1,1,2,-*3*-,3,8,8]
            //     right = middle - 1;
            // } else if (equalLeft && middle % 2 == 0) { // [1,1,2,3,-*3*-,8,8]
            //     right = middle - 1;
            // } else if (equalLeft && middle % 2 != 0) { // [1,-*1*-,2,3,3,8,8]
            //     left = middle + 1;
            // } else if (!equalLeft && middle % 2 == 0) { // [-*1*-,1,2,3,3,8,8]
            //     left = middle + 1;
            // }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
