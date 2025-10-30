
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapInJava {
    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(3);
        minHeap.add(40);
        System.out.println("Heap (logical): " + Arrays.toString(minHeap.toArray()));
        while (minHeap.isEmpty() == false) {
            System.out.println(minHeap.poll());
        }
    }
}
