public class MedianOfTwoSortedArrays_BinarySearch {
    /*
        Time: O(log min(n + m)) -> Vì chỉ tìm kiếm trên mảng nhỏ hơn
        Space: O(1)
    */


    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Tìm số phần từ bên trái của nums1
        /*
            Tại sao r1 = n1 mà không phải r1 = n1 - 1 như những bài binaryseach khác?
            👉 Bài median cần tìm điểm CẮT không phải index
         */
        int l1 = 0;
        int r1 = n1;

        while (l1 <= r1) {
            /*
                i1: số lương phần từ bên TRÁI điểm CẮT của nums1
                VD:  l1 = 0 , r1 = 1 -> i1 = 0 -> không có phân tử bên trái điểm cắt
                nums1: | x1
             */
            int i1 = (l1 + r1) / 2;
            /*
                i2: số lương phần từ bên TRÁI điểm CẮT của nums2
             */
            int i2 = (n1 + n2 + 1) / 2 - i1;

            int numLeft1 = i1 == 0 ? Integer.MIN_VALUE : nums1[i1 - 1];
            int numRight1 = i1 == n1 ? Integer.MAX_VALUE : nums1[i1];

            int numLeft2 = i2 == 0 ? Integer.MIN_VALUE : nums2[i2 - 1];
            int numRight2 = i2 == n2 ? Integer.MAX_VALUE : nums2[i2];

            if (numLeft1 <= numRight2 && numLeft2 <= numRight1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(numLeft1, numLeft2) + Math.min(numRight1, numRight2)) / 2.0;
                } else {
                    return Math.max(numLeft1, numLeft2);
                }
            } else if (numLeft2 > numRight1) {
                /*
                    nums1: 3 | 4*  7 8
                    nums2: 1 2  5* | 6
                 */
                l1 = i1 + 1;

            } else {
                r1 = i1 - 1;
            }
        }

        return 0.00;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }   
}

