import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RelativeRanks {
    /*
     * SOLUTION 1: HEAP
     * 
     */

    public String[] findRelativeRanks(int[] score) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : score) {
            pq.add(s);
        }

        Map<Integer, String> medals = new HashMap<>();
        int ordinalNumber = 1;
        while (!pq.isEmpty()) {
            int s = pq.poll();
            switch (ordinalNumber) {
                case 1 ->
                    medals.put(s, "Gold Medal");
                case 2 ->
                    medals.put(s, "Silver Medal");
                case 3 ->
                    medals.put(s, "Bronze Medal");
                default ->
                    medals.put(s, String.valueOf(ordinalNumber));
            }
            ordinalNumber++;
        }

        int n = score.length;
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            int s = score[i];
            ans[i] = medals.get(s);
        }
        return ans;
    }


    /*
     * TỰ CODE - CODE NGU VÃI CỨT
     * 
     * 
     */
    public String[] findRelativeRanks_Heap(int[] score) {
        List<Integer> scores = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<String> ans = new ArrayList<>();
        for(int s : score) {
            pq.add(s);
            ans.add(String.valueOf(s));
            scores.add(s);
        }

        Map<Integer, String> medals = new HashMap<>();
        medals.put(1, "Gold Medal");
        medals.put(2, "Silver Medal");
        medals.put(3, "Bronze Medal");

        for(int i = 1; i <= 3; i++) {
            int s = pq.poll();
            int idx = scores.indexOf(s);
            String medal = medals.get(i);
            ans.set(idx, medal);
        }

        return ans.toArray(new String[0]);
    }



    public static void main(String[] args) {
        
    }
}
