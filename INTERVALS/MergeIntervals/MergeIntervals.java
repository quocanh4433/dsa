import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /*
        Time -> O(nlogn)
        Space -> O(n)
    
    */

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int idx = res.size() - 1;
            int[] prev = res.get(idx);
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);


        /*
            CHI SU DUNG 1 BIEN DE QUAN SAT

            Time -> O(nlogn)
            Space -> O(1)
    
         */

        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List<int[]> merged = new ArrayList<>();
        // int[] prev = intervals[0];
        // for (int i = 1; i < intervals.length; i++) {
        //     int[] interval = intervals[i];
        //     if (interval[0] <= prev[1]) {
        //         prev[1] = Math.max(prev[1], interval[1]);
        //     } else {
        //         merged.add(prev);
        //         prev = interval;
        //     }
        // }
        // merged.add(prev);
        // return merged.toArray(new int[merged.size()][]);        
    }
    public static void main(String[] args) {
        
    }
}
