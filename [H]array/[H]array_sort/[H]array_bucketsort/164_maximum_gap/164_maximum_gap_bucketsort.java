import java.util.Arrays;

class MaximunGap_BucketSort {

    /*
        time O(n)
        space O(n)
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int minVal = nums[0];
        int maxVal = nums[0];

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (minVal == maxVal) {
            return 0;
        }

        int n = nums.length;

        // bước 2. tính kích thước thùng và số lượng thùng
        // kích thước bucket chắc chắn nhỏ hơn hoặc băng maxVal - minVal
        int bucketSize = Math.max(1, (maxVal - minVal) / n - 1);

        // sô lượng bucket
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // bước 3: phân bổ các phần tử vào thùng - O(n)
        for (int num : nums) {
            int bucketIdx = (num - minVal) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // bước 4: duyệt qua các thùng để tìm gap lớn nhất - O(n)
        int maxGap = 0;
        int previousMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            // bỏ qua thùng rỗng
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            // gap bằng min thùng hiện tại trừ đi max thùng trước đó
            // khoảng cách lớn nhất (Maximum Gap) chắc chắn KHÔNG THỂ nằm bên trong cùng một thùng, mà luôn nằm ở RANH GIỚI giữa hai thùng khác nhau.
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
