
public class FindTheLongestValidObstacleCourseAtEachPosition_BinarySearch {

    /*
        time O(nlogn)
        sapce O(n)

        1 <= n <= 10**5
     */

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] result = new int[n];
        int[] tail = new int[n];
        int size = 0; // đồ dài đang xét

        for (int i = 0; i < n; i++) {
            int x = obstacles[i];

            // tìm vị trí chèn x vào tail
            // tìm phần tư đầu tiên lớn hơn x
            int l = 0, r = size;
            while (l < r) {
                int m = (l + r) / 2;
                if (tail[m] > x) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            tail[l] = x;
            if (l == size) {
                size++;
            }
            result[i] = l + 1;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
