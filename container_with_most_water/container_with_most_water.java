public class container_with_most_water {
    /**
     * 11. Container With Most Water
     * 
     * You are given an integer array height of length n. There are n vertical lines
     * drawn such that the two endpoints of the ith line are (i, 0) and (i,
     * height[i]).
     * 
     * Find two lines that together with the x-axis form a container, such that the
     * container contains the most water.
     * 
     * Return the maximum amount of water a container can store.
     * 
     * Notice that you may not slant the container.
     * 
     * Example 1:
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array
     * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
     * container can contain is 49.
     * 
     * 
     * Example 2:
     * Input: height = [1,1]
     * Output: 1
     * 
     * Constraints:
     * 
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     * 
     * 
     * 
     * Time complexity : O(n)
     * Space complexity: O(1)
     * 
     */


    public static int maxArea (int[] height) {
        if(height == null || height.length == 0) return 0;

        int max = 0;
        int start = 0, end = height.length - 1;
        
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            int w = end  - start;
            max = Math.max(max, w * h);

            if(height[start] < height[end]) start++; else end--;
        }

        return max;
    }

    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        // System.out.println(maxArea(height));


        /* NOTE: FAIL AT TEST CASE */
        int[] height_2 = {8,7,2,1};
        System.out.println(maxArea(height_2));

    }
}
