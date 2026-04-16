import java.util.TreeMap;

class MyCalendarI_TreeMap {
    /*
        time: 
            ▪︎ floorKey()        = O(logn)
            ▪︎ ceilingKey()      = O(logn)
            ▪︎ put()             = O(logn)
            ▪︎ gọi book() n lần  = O(nlogn)

        space: O(n) trong trường hợp không overlap gọi book() n lần, treemap lưu n interval
    */
    TreeMap<Integer, Integer> map;

    public MyCalendarI_TreeMap() {
        map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Integer prev = map.floorKey(startTime);
        if (prev != null && map.get(prev) > startTime) {
            return false;
        }

        Integer next = map.ceilingKey(startTime);
        if (next != null && endTime > next) {
            return false;
        }
        map.put(startTime, endTime);
        return true;
    }
}
