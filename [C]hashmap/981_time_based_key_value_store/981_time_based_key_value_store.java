import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    /*
        Nếu có tổng cộng N lần set():

        Time: set O(1), get O(log n)
        Space: O(N)
    
     */

    class Pair {
        int timestamp;
        String value;

        Pair(int t, String v) {
            this.timestamp = t;
            this.value = v;
        }
    }


    HashMap<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        //[(1,a), (4,b), (6,c), (10,d)] target = 8

        int l = 0;
        int r = list.size() - 1;

        while(l <= r) {
            /*
                tại sao l <= r mà không phải là l < r?
                - có 2 TH xảy ra là chính xác timestamp và TH không có timestamp lấy nhỏ hơn nên cần <=
             */

            int m = l + (r - l)/2;
            Pair pair = list.get(m); 

            if(pair.timestamp == timestamp) {
                return pair.value;
            } else if(pair.timestamp < timestamp) {
                // m có thể là đáp án,
                // nhưng cần tìm phần tử tốt hơn bên phải
                l = m + 1;
            } else {
                // m chắc chắn không phải đáp án
                r = m - 1;
            }
        }

        // r là index lớn nhất có timestamp < target
        if (r < 0) {
            return "";
        }

        return list.get(r).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */