import java.util.List;
import java.util.PriorityQueue;

class SmallestRangeCoveringElementsFromKLists {

    /*
        *** 1/. ý tưởng:
        
        - Bài toán yêu cầu tìm khoảng [a, b] nhỏ nhất chứa ít nhất 1 phần tử từ mỗi danh sách trong K danh sách.
        - Ta sử dụng Min-Heap để lưu K phần tử đại diện cho K danh sách tại mỗi thời điểm.
        - Khoảng hiện tại sẽ là [minVal, maxVal] (trong đó minVal lấy từ Min-Heap, maxVal là giá trị lớn nhất trong K phần tử hiện tại).
        - Kỹ thuật Tham Ăn (Greedy): Để tìm khoảng nhỏ hơn, cách duy nhất là tăng minVal lên.
          Do đó, ta liên tục rút phần tử nhỏ nhất (minEl) ra khỏi Heap và bổ sung phần tử KẾ BÊN của CÙNG danh sách đó vào Heap.
        - Điều kiện dừng: Khi 1 danh sách đã duyệt hết phần tử, ta không thể duy trì đủ K đại diện nữa -> break.




        time O(nlogk)
        space O(k)

        n: tổng số phần từ trộng tất cả các list cộng lại 
        k: số list trong nums
     */

    class Element {

        int val;
        int listIdx; // cho biết element thuộc list nào
        int idx; // trong biết elementow rđâu trong list

        Element(int val, int listIdx, int idx) {
            this.val = val;
            this.listIdx = listIdx;
            this.idx = idx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int currRangeEnd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            minHeap.offer(new Element(list.get(0), i, 0));
            currRangeEnd = Math.max(currRangeEnd, list.get(0));
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // heap luôn duy trì số lượng theo nums.size();
        // nếu heap.size() != nums.size() tức là có list con trong nums hết phần từ để duyệt tiếp
        while (minHeap.size() == nums.size()) {
            Element minEl = minHeap.poll();
            int currRangeStart = minEl.val;

            // cập nhật range mới nếu timfthaays range tốt hơn
            if (currRangeEnd - currRangeStart < rangeEnd - rangeStart) {
                rangeStart = currRangeStart;
                rangeEnd = currRangeEnd;
            }

            // để duy trì heap.size() == nums.size() cần offer thêm 1 el mới 
            // el mới là phần tử cùng list với minEl và kế bến
            // kiểm tra el mới có vượt quá chiều dài list
            if (minEl.idx + 1 < nums.get(minEl.listIdx).size()) {

                // lấy giá trị của el mới
                int nextVal = nums.get(minEl.listIdx).get(minEl.idx + 1);

                // thêm el mới vào heap
                minHeap.offer(new Element(nextVal, minEl.listIdx, minEl.idx + 1));

                // cập nhật lại currRanEnd nếu giá trị el mới lớn hơn
                currRangeEnd = Math.max(currRangeEnd, nextVal);
            } else {
                // nếu 1 list con trong nums đã hết phần tử 
                break;
            }
        }

        return new int[]{rangeStart, rangeEnd};

    }
}
