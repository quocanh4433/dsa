
public class TrappingRainWater {

    /**
     * SOLUTION 1: hashmap
     *
     * Time complexiy: O(n)
     *
     * Space complexity: O(n)
     *
     */
    public static int trap_1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return res;
    }

    /**
     * SOLUTION 2:
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     *
     * Ý tưởng
     *
     * - Bên nào thấp hơn (leftMax hay rightMax) sẽ quyết định “cổ chai” hiện
     * tại.
     *
     * - Nếu bên trái thấp hơn, lượng nước hứng tại left phụ thuộc vào leftMax
     * (không cần quan tâm rightMax, vì chắc chắn rightMax ≥ height[right] ≥
     * height[left]).
     *
     * - Tương tự với bên phải.
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int l = 0, r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        while (l < r) {
            // [1 0 0 2]
            // [0 0 0 2]
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
                /*
                    Mà leftMax chắc chắn nhỏ hơn rightMax vậy Math.min(leftMax, rightMax) = leftMax
                    -> res = res + (Math.min(leftMax, rightMax) - height[l]);
                    -> res = res + (leftMax - height[l])
                    -> res += leftMax - height[l]
                 */
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;

    }

    /**
     * SOLUTION 3: Stack
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     *
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums2 = new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        System.out.println(trap_1(nums)); // exception: 6
        System.out.println(trap_1(nums2)); // exception: 9
        System.out.println("-------------------");
        System.out.println(trap(nums)); // exception: 6
        System.out.println(trap(nums2)); // exception: 9
    }
}
