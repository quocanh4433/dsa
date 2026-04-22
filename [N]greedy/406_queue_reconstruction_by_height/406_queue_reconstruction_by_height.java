import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QueueReconstructionByHeight {

    /*
        time O(n**2  + nlogn) ~ O(n**2)    
            sort    O(nlogn)
            insert  O(n**2) 
                - mỗi lần insert O(n)
                - inser n lần O(n**2)
    
        space O(n) ~ List<> res
     */
    public int[][] reconstructQueue(int[][] people) {
        // 1. Sort:
        // - height giảm dần
        // - nếu height bằng nhau → k tăng dần

        // tại sao cần sort height giảm?
        // vì khi insert vào list res từ trái sang phải
        // các phần từ càng về sau height càng nhỏ
        // nếu các phần từ này có insert vào đầu list res cũng không ảnh hưởng phần tử có height lớn hơn phía sau
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        // 2. Insert theo k
        List<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            res.add(p[1], p); // insert vào index = k
        }

        // 3. Convert sang array
        return res.toArray(new int[people.length][]);
    }
}
