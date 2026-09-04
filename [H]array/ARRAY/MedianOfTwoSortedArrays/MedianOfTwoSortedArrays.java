
import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    /*
        Time:   O(n + m)
        Space:  O(n + m)


        ✍️ FOLLOW UP: Giải với Time O(log(n + m))
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Merge two array
        int[] mergedArr = new int[m + n];
        for (int i = 0; i < n; i++) {
            mergedArr[i] = nums1[i];
        }

        for (int j = 0; j < m; j++) {
            int idx = j + n;
            mergedArr[idx] = nums2[j];
        }

        /*
            📌 Cách merge 2 array ngắn gọn

            System.arraycopy(nums1, 0, mergedArr, 0, n);
            System.arraycopy(nums2, 0, mergedArr, n, m);
        */

        // Sort Array
        Arrays.sort(mergedArr);
        int len = mergedArr.length;
        int mid = len / 2;
        if (len % 2 == 0) {
            return (mergedArr[mid] + mergedArr[mid - 1]) / 2.0;
        } else {
            return mergedArr[mid];
        }
    }

    public static void main(String[] args) {
        
    }
}
