import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
     * SOLUTION 2: HEAP + isEven
     * 
    * Time complexity: O(mlogn) mà m ~ n -> O(nlogn)
     * 
     * Space complexity: O(n)
     * 
     * m: số lần gọi do đây là data stream không phải mảng cố định
     * 
     * n: số phần tử trong heap
     * 
     * 
     */
    class MedianFinder_2 {

        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;
        boolean isEven;

        public MedianFinder_2() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            isEven = true;
        }

        public void addNum(int num) {
            if (isEven) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
            isEven = !isEven;
        }

        public double findMedian() {
            return isEven ? (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
     * obj.findMedian();
     */



     /*
     * SOLUTION 3: HEAP + Number of element
     * 
     * Time complexity: O(mlogn) mà m ~ n -> O(nlogn)
     * 
     * Space complexity: O(n)
     * 
     * m: số lần gọi do đây là data stream không phải mảng cố định
     * 
     * n: số phần tử trong heap
     * 
     * 
     */
    class MedianFinder_3 {
        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;
        
        public MedianFinder_3() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }
        
        public void addNum(int num) {
            // Mặc định thêm vào maxHeap
            maxHeap.offer(num);

            if(maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(maxHeap.poll());
            }
            
            if(minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        public double findMedian() {
            if(maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if(maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } 
            return minHeap.peek();
        }
    }

    
    public static void main(String[] args) {
        
    }
}   
