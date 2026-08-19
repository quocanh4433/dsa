
class PeakIndexInAMountainArray {

    /*
       Nếu arr[m] < arr[m + 1]: đang ở sươn đi lên thu l
       Nếu arr[m] > arr[m + 1]: đang ở sươn đi xuống thu r

       time O(logn)
       space O(1)
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] < arr[m + 1]) {
                // đang đi lên peak năm bên phải
                l = m + 1;
            } else {
                // đi đi xuống m có thể là peak
                r = m;
            }
        }

        return l;
    }

    public int peakIndexInMountainArray_02(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] < arr[m + 1]) {
                // đang đi lên peak năm bên phải
                l = m + 1;
                continue;
            }

            if (arr[m] > arr[m + 1]) {
                r = m - 1;
            }

        }

        return l;
    }
}
