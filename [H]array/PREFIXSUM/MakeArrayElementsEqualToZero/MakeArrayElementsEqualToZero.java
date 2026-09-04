public class MakeArrayElementsEqualToZero {
    /*
     * 💡 IDEA:
     * Tìm sô cách chuyển phần từ trong mảng về 0 bằng leftSum và rightSum
     *      - leftSum == rightSum: cân bằng         ->  2 cách
     *      - leftSum và rightSum chệnh lệch 1      ->  1 cách
     * 
     * 
     * 👉 Bài này áp dụng prefix sum exclusive
     * 
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     */
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[n - i - 1] = rightSum[n - i] + nums[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            if (leftSum[i] == rightSum[i]) {
                ans += 2;
            }
            if (Math.abs(leftSum[i] - rightSum[i]) == 1) {
                ans += 1;
            }
        }

        return ans;
    }

    /*
     * SOLUTION 2: Without extra space (Optimal)
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int countValidSelections_optimal(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        
        for(int num : nums) {
            rightSum += num;
        }
        // OR
        // rightSum = Arrays.stream(nums).sum();

        for(int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if(nums[i] != 0) continue;
            if(leftSum == rightSum) ans += 2;
            if(Math.abs(leftSum - rightSum) == 1) ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }



}



/*
 * CODE TỰ BRANDSTORM
 * SAI HẾT
 * 
 * 
 */

/*
    public int countValidSelections(int[] nums) {
        int currIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(num[i] == 0) {
                currIndex = i;
            }
        }

        int ans = validSection(nums, true, curr) + validSection(nums, false, currIndex);
        return ans;
    }

    public int validSection(int[] nums, boolean isLeft, int currIndex) {
        


        if(isLeft) { // leftside
            if(currIndex - 1 >= 0) {
                int temp = nums[currIndex - 1];

            }
        } else { // rightside
            if(currIndex + 1 <= nums.lnegth) {

            }
        }

        for(int num : nums) {
            if(num > 0) {
                return 0;
            }
        }
        return 1;
    }










 */
