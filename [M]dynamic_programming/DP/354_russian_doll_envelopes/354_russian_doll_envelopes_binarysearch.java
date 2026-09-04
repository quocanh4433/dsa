
import java.util.Arrays;

class Solution {
    /*
        time: O(nlogn)
        space: O(n)
    */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // height ↓
            }
            return a[0] - b[0];     // width ↑
        });

        // sau khi sắp xếp width giờ chỉ quan tâm đến height
        // LIS on height
        int[] lis = new int[envelopes.length];
        int size = 0;

        for(int[] env : envelopes) {
            int h = env[1];
            int l = 0, r = size;
            while(l < r) {
                int m = l + (r - l) / 2;

                // binary đang search vị trí đầu tiên mà lis[m] >= h

                if(lis[m] < h) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }

            lis[l] = h;

            if(l == size) {
                size++;
            }
        }

        return size;
    }
}
