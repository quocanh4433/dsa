import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class UglyNumberII {

    /*
        *** 1/ Cách tạo dãy ugly number 
        Dãy ugly được tạo thành từ:
        Từ 1, nhân 2, 3, 5  Ta được: 2, 3, 5
        Từ 2, nhân 2, 3, 5  Ta được: 4, 6, 10
        Từ 3, nhân 2, 3, 5  Ta được: 6 (đã có), 9, 15
        Từ 4, nhân 2, 3, 5  Ta được: 8, 12, 20

        Sắp xếp lại theo thứ tự tăng dần, bạn sẽ có dãy: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ...
        Yêu cầu lấy ra phần từ thứ n ví dụ n = 10 trả về 12


        *** 2/ Ý tưởng 
        Ngoài trừ số 1 thì số ugly mới được tạo ra từ sô ugly cũ nhân với 2, 3, 5

        b1: thêm số 1 vào minHeap
        b2: lấy sô 1 ra khỏi minheap nhân cho 2 3 5 tạo bộ 3 số ugly mới
        b3: thêm bộ 3 mới vao heap - kiêm tra trùng - kiêm ra đi đến n chưa


        *** 3/ Lưu ý

        ****** 3.1/ Tại sao là minheap không phải maxheap?
        lấy lần lượt các sô nhỏ trước để tạo các số ugly tiếp theo 

        vd: heap: [2, 3, 5] 
        lấy 2 ra trước để tạo 4
        lấy 3 tạo 6
        lấy 5 tạo 10


        ****** 3.2/ tại sao minheap dung long thay cho int?
        theo constrain n = 1690 tức worst case tìm số ugly ở vị trí 1690 tức hơn 2ty
        Chính xác ở n = 1690, số Ugly là 2.123.366.400.
        
        nếu ở n = 1690 mà vẫn nhỏ hơn int32 mà vẫn dung int
        
        do trong heap vẫn phải nhân thử với factor sau đó mới lọc ra

        nếu 1.073.741.824 * 2 = 2.147.483.648 vượt quá int sẽ quay về Integet.MIN_VALUE
     */


 /*
        time    O(nlogk)
        space   O(n)
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        minHeap.offer(1L);
        visited.add(1L);

        int[] primeFactors = {2, 3, 5};
        long currentUgly = 1;

        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll();

            for (int factor : primeFactors) {
                long nextUgly = currentUgly * factor;

                if (!visited.contains(nextUgly)) {
                    visited.add(nextUgly);
                    minHeap.offer(nextUgly);
                }
            }
        }

        return (int) currentUgly;
    }
}
