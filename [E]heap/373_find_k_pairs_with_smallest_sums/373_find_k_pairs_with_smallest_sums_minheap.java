import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class FindKPairsWithSmallestSums_MinHeap {

    /*
        n = nums1.length
        m = nums2.length
        k <= n * m 

        - heap duyệt n phần từ - mỗi phần từ offer()        O(min(n, k)log(min(n, k)))
        - while duyệt tối đa k lần - mỗi lần offer()        O(klog(min(n, k)))

        -> time O(nlogn)
        -> space O(min(n, k)) 

     */

    class Element {

        int sum;
        int i; // index nums1
        int j; // index nums2 

        Element(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<Element> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.sum, b.sum));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minheap.offer(new Element(nums1[i] + nums2[0], i, 0));
        }

        while (k > 0 && !minheap.isEmpty()) {
            Element minEl = minheap.poll();
            int i = minEl.i;
            int j = minEl.j;

            k--;
            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minheap.offer(new Element(nums1[i] + nums2[j + 1], i, j + 1));
            }
        }

        return res;
    }
}
