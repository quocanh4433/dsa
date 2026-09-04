import java.util.Arrays;
import java.util.List;

public class MeetingRooms2_TwoPointer {

    /*
        3️⃣ Tư duy đúng
        Ta cần biết:

        🔹 Tại cùng một thời điểm, có bao nhiêu meeting đang diễn ra?

        🔑 Chốt lại
        Two pointer không đếm số meeting, mà đếm số meeting đang diễn ra 
        tại cùng 1 thời điểm.



        Time -> O(nlogn)
        Space -> O(n)
    */

    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 1 || n == 0) return n;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0;
        int e = 0;
        int room = 0;
        int maxRoom = 0;

        while(s < n) { 
            //❓ Tại sao vòng while chỉ kiểm tra i < n (s < n), mà không cần j < n?
            // Vì mỗi vòng lặp luôn xử lý một start[i], và ta chỉ cần duyệt hết tất cả các cuộc họp bắt đầu.
            
            if(start[s] < end[e]) { // → meeting mới bắt đầu → tăng i
                room++;
                s++;
            } else { // → meeting cũ kết thúc → tăng j
                room--;
                e++;
            }
            maxRoom = Math.max(maxRoom, room);
        }

       return maxRoom;
    }

  

    public static void main(String[] args) {

    }
}

class Interval {

    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
