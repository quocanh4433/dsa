
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    /*
        Time -> O(nlogn)
        Space -> O(n)

        Gộp newInterval vào intervals để chuyển sang dạng merge intervals
    */


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        };

        // Gộp intervals và newInterval
        int[][] newIntervals = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            if (i == n) {
                newIntervals[i] = newInterval;
                continue;
            }
            newIntervals[i] = intervals[i];
        }

        // Sort
        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(newIntervals[0]);

        // Interative through each element
        for (int i = 1; i < newIntervals.length; i++) {
            int[] curr = newIntervals[i];
            int[] prev = res.get(res.size() - 1);
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

  

    public static void main(String[] args) {
        
    }
}
