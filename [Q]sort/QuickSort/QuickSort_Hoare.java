
import java.util.Arrays;

/*
    QUICK SORT - HOARE

    Chọn phần tử giữa làm pivot
    🧩 Ưu điểm: Thường hiệu quả hơn, thực hiện ít lần hoán đổi hơn Lomuto.
    ⚠️ Nhược điểm: Phức tạp hơn Lomuto, cần cẩn thận hơn khi xử lý các chỉ số. 

    Time: O(nlogn) - worst case: O(n^2) when the arr is sorted
    Space: O(1)

 */


public class QuickSort_Hoare {
    void quickSort(int[] a, int L, int R) {
        if(L >= R) return;
        /* pi is partitioning index (điểm phân vùng) */
        int pivot = partition(a, L, R);
        quickSort(a, L, pivot - 1);
        quickSort(a, pivot, R);
    }

    int partition(int[] a, int L, int R) {
        // choose the pivot
        int key = a[(L + R) / 2];
        int i = L, j = R;

        while(i <= j) {
            while(a[i] < key) {
                i++;
            }

            while (a[j] > key) {
                j--;
            }

            if(i <= j) {
                if(i < j) {
                    swap(a, i, j);
                }
                i++;
                j--;
            }
        }

        return i;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        QuickSort_Hoare qs = new QuickSort_Hoare();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
