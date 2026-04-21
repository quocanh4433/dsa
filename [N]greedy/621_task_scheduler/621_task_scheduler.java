import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class TaskScheduler_Heap {
    /*
        time    O(N log26)  ~   O(N)
        space   O(26)       ~   O(1)
    */

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            /*
                tại sao cần n + 1?

                một task chạy ở thời điêm t, nó chỉ chạy lại ít nhất sau n khoảng cách 

                vd: n = 2 A _ _ A. task A chạy ở 0 thì đến 3 mới chạy lại
             */
            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    int cur = maxHeap.poll();
                    if (cur - 1 > 0) {
                        temp.add(cur - 1);
                    }
                }

                // nếu maxHeap rỗng time vẫn tăng bằng cách truyền "idle"
                time++;

                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            // cập nhật danh sách chờ vao lại heap
            for (int t : temp) {
                maxHeap.add(t);
            }
        }

        return time;
    }
}
