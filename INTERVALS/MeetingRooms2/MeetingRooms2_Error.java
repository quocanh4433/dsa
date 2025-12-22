
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2_Error {

    /*
        1️⃣ Bản chất bài toán

        👉 Ta cần số phòng họp tối thiểu sao cho các meeting 
        chồng nhau không dùng chung phòng.
        
    
    */

    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 1 || n == 0) {
            return n;
        }

        int count = 0;
        int idx = 1;
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
       
        while (idx < n) {

            /*
                2️⃣ Vấn đề trong code của bạn
                ❌ Sai lầm cốt lõi:
                Bạn đang chỉ so sánh interval hiện tại với interval trước đó:


                ❗ Một meeting có thể không overlap với meeting liền trước,
                nhưng vẫn overlap với meeting trước nữa.
            
            */


            Interval curr = intervals.get(idx);
            Interval prev = intervals.get(idx - 1);

            if (curr.start < prev.end) {
                count++;
                idx++;
                continue;
            }
            count++;
            while (idx < n && curr.start >= prev.end) {
                idx++;
            }
        }

        return count;
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
