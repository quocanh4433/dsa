import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MostCommonWord {
    /*
        time O(n)
        space O(n)
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1. đưa banned vao set để kiểm tra
        Set<String> bannedSet = new HashSet<>();
        for(String ban : banned) {
            bannedSet.add(ban);
        }


        // 2. đếm số lần xuất hiện
        Map<String, Integer> freqMap = new HashMap<>();
        for(String str : paragraph.toLowerCase().split("[^a-z]+")) { //  → tách mọi thứ không phải chữ cái
            if(bannedSet.contains(str))  continue;
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }


        // 3. tìm từ frequency nhiểu nhất
        String res = "";

        for(String key : freqMap.keySet()) {
            if(res.isEmpty() || freqMap.get(key) > freqMap.get(res)) {
                res = key;
            }
        }

        return res;
    }
}