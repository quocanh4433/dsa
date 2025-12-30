
import java.util.Arrays;

/*
    QUICK SORT - LOMUTO

    Chọn phần tử cuối cùng (hoặc đầu) làm pivot
    🧩 Ưu điểm: Dễ hiểu và cài đặt.
    ⚠️ Nhược điểm: Có thể kém hiệu quả hơn Hoare, thực hiện nhiều lần hoán đổi. 


    Time: O(nlogn) - worst case: O(n^2) when the arr is sorted
    Space: O(1)

 */


public class QuickSort_Lomuto {
    void quickSort(int[] a, int L, int R) {
        if (L >= R) {
            return;
        }

        int pi = partition(a, L, R);   // pivot index
        quickSort(a, L, pi - 1);        // bên trái pivot
        quickSort(a, pi + 1, R);        // bên phải pivot
    }

    int partition(int[] a, int L, int R) {
        int pivot = a[R];   // ✅ Lomuto: pivot là phần tử cuối
        int i = L;          // vị trí đặt phần tử < pivot

        for (int j = L; j < R; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, R);      // đưa pivot về đúng vị trí
        return i;           // trả về vị trí pivot
    }


    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        QuickSort_Lomuto qs = new QuickSort_Lomuto();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
