import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedianFromDataStream {
    /*
     * SOLUTION 1: A NAVIE SOLUTION
     * 
     * BUT TIME LIMITE EXCEEDED
     * 
     * ❓ Tại sao LTE?
     * “Vì addNum() bị gọi nhiều lần, mỗi lần O(n log n), nên tổng thời gian là O(n² log n) → TLE.”
     * 
     * 
     */
    class MedianFinder_TLE {
        private List<Integer> arr;

        public MedianFinder_TLE() {
            arr = new ArrayList<>();
        }
        
        public void addNum(int num) {
            arr.add(num);
        }
        
        public double findMedian() {
            // Sắp xếp tăng dần List
            Collections.sort(arr);

            // Sắp xếp tăng dần static Array
            // Array.sort(arr);

            int n = arr.size();
            if(arr.size() % 2 != 0) {
                return arr.get(n / 2);
            }

            int num1 = arr.get(n / 2);
            int num2 = arr.get(n / 2 - 1);
            return (num1 + num2) / 2.0;
        }
    }

    /*
     * SOLUTION 2: HEAP
     * 
     * 
     * 
     */
    
    public static void main(String[] args) {
        
    }
}   
