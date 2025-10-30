import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    /**
     * SOLUTION: HEAP
     * 
     * Time complexity: O(nlogn)
     * 
     * Space complexity: O(n)
     * 
     * 
     */

     public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Space: O(n)
        for(int stone : stones) {// Time: O(n)
            pq.add(stone); // Time: O(logn)
        } // ===> Time: O(nlogn)

        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 != stone2) {
                pq.add(stone1 - stone2);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
    public static void main(String[] args) {
        
    }
}
