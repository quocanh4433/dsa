import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray_QuickSort {

    /*
        Time: O(nlogn)
        Space: O(n)
    
    
    */

    public List<Integer> targetIndices(int[] nums, int target) {
        quickSort(nums, 0, nums.length - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    void quickSort(int[] a, int L, int R) {
        if (L >= R) {
            return;
        }

        int pivotVal = a[R];
        int pivot = L;

        for (int i = L; i < R; i++) {
            if (a[i] <= pivotVal) {
                swap(a, pivot, i);
                pivot++; // tại sao pivot tăng lên 1 -> để tránh ghi đè cho lần sau
            }
        }
        swap(a, pivot, R);

        quickSort(a, L, pivot - 1);
        quickSort(a, pivot + 1, R);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        
    }
}
