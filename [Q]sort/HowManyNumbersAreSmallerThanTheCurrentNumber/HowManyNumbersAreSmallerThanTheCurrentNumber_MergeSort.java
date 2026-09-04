
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber_MergeSort {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        // clone arr nums
        int[] nums_sort = nums.clone(); 

        // sort
        mergeSort(nums_sort, 0, n - 1);

        // mapping
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums_sort[i])) {
                map.put(nums_sort[i], i);
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public void mergeSort(int[] arr, int L, int R) {
        if (L < R) {
            int M = (L + R) / 2;

            // Chia mảng
            mergeSort(arr, L, M);
            mergeSort(arr, M + 1, R);

            // Trộn 2 mảng đã sắp xếp
            merge(arr, L, R, M);
        }
    }

    public void merge(int[] arr, int L, int R, int M) {
        // Số phần tử có trong mảng con bên trái và phải
        int nLeft = M - L + 1;
        int nRight = R - M;

        int[] arrLeft = new int[nLeft];
        int[] arrRight = new int[nRight];

        // Copy dữ liệu
        for (int i = 0; i < nLeft; i++) {
            arrLeft[i] = arr[L + i];
        }

        for (int i = 0; i < nRight; i++) {
            arrRight[i] = arr[M + i + 1];
        }

        // Merge
        int i = 0, j = 0, k = L;

        /*
            Vì sao k = left chứ không phải 0?
            ⚠️ Cực kỳ quan trọng
            Merge Sort KHÔNG merge toàn bộ mảng, mà chỉ merge một đoạn con:
            👉 Kết quả merge phải ghi đúng vào đoạn này
         */
        while (i < nLeft && j < nRight) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[k] = arrLeft[i];
                i++;
            } else {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }

        // copy phần còn lại
        while (i < nLeft) {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }

        while (j < nRight) {
            arr[k] = arrRight[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        HowManyNumbersAreSmallerThanTheCurrentNumber_MergeSort ms = new HowManyNumbersAreSmallerThanTheCurrentNumber_MergeSort();
        int[] ans = ms.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ans));
    }
}
