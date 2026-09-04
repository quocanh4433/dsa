

/*

    ONLY NEETCODE

    Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.

    Note: (0,8),(8,10) is not considered a conflict at 8

    Example 1:
    Input: intervals = [(0,30),(5,10),(15,20)]
    Output: false


    Example 2:
    Input: intervals = [(5,8),(9,15)]
    Output: true

    Example 3:
    Input: intervals = [(5,10),(0,4)]
    Output: true


 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    /*
        Time -> O(nlogn)
        Space -> O(1) or O(n) depending on the sorting algorithm.
    */

    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 1 || n == 0) {
            return true;
        }

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        
        for(int i = 1; i < n; i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if(i2.start < i1.end) {
                return false;
            }
        }
        return true;
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
