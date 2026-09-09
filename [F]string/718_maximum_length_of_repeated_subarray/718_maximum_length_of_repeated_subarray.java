
import java.util.HashSet;
import java.util.Set;

class MaximumLengthOfRepeatedSubarray {

    /*
        độ dài mảng con từ 0 đến min(n, m)

        thay vi thử từng độ dài từ 0 đến min(n, m) dùng binary search

        ở mảng dài len nếu có subarray -> tăng len (low = len + 1)
        ở mảng dài len nếu k có subarray -> giảm len (high = len - 1)

        len: đại diện cho mid trong binary search
        

        time O( (n + m) * log(n + m))
            - binary search O(min(n, m))
            - find() O(n + m)

        space O(n) với n < m
     */
    public int findLength(int[] nums1, int[] nums2) {
        // dam bao len(nums1) luon nho hon len(nums2)
        // do them phan tu nums1 vao hashset
        if (nums1.length > nums2.length) {
            return findLength(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        int res = 0;

        while (low <= high) {
            int len = (high + low) / 2;

            if (find(nums1, nums2, len)) {
                res = len;
                low = len + 1;
            } else {
                high = len - 1;
            }
        }

        return res;
    }

    public boolean find(int[] nums1, int[] nums2, int len) {
        if (len == 0) {
            return true;
        }

        long BASE = 109; // do chiều dài mảng là 100 nên sô nguyên tố lớn hơn gần nhất là 109
        long MOD = 1_000_000_007L;

        // tinh highpower
        long highPower = 1;
        for (int i = 0; i < len - 1; i++) {
            highPower = (highPower * BASE) % MOD;
        }

        long hashVal = 0;
        Set<Long> hashvalSet = new HashSet<>();

        // tính hash cho toàn bộ mảng con có chiều dài len trong nums1
        for (int i = 0; i < nums1.length; i++) {
            if (i >= len) { // vượt quá độ dài nên cần bỏ bớt phần tử đầu cuối
                long removedVal = (nums1[i - len] * highPower) % MOD;
                hashVal = (hashVal - removedVal + MOD) % MOD;
            }

            // thêm phần từ mới
            hashVal = (hashVal * BASE + nums1[i]) % MOD;

            // nếu duyệt đủ độ dài len thi thêm vào set
            // tại sao không phải là i == len - 1?
            if (i >= len - 1) {
                hashvalSet.add(hashVal);

                // đây là lí do vi sao cho len(nums1) nhỏ hơn len(nums2)
                // nums1 giống như mẫu thử đưa và set 
                // nếu số lượng mẫu kiểm tra nhỏ thì việc kiểm tra trùng sau này ít hơn 
            }
        }

        // tính hash cho toàn bộ mảng con có chiều dài len trong nums2
        hashVal = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (i >= len) { // vượt quá độ dài nên cần bỏ bớt phần tử đầu cuối
                long removedVal = (nums2[i - len] * highPower) % MOD;
                hashVal = (hashVal - removedVal + MOD) % MOD;
            }

            // thêm phần từ mới
            hashVal = (hashVal * BASE + nums2[i]) % MOD;

            if (i >= len - 1) {
                if (hashvalSet.contains(hashVal)) {
                    return true;
                }
            }
        }

        return false;
    }
}
