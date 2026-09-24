import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortCharactersByFrequency {
    /**
        time O(n)
        space O(n)
    
     */
    public String frequencySort(String s) {
        int n = s.length();

        // 1. đếm freq
        Map<Character, Integer> freqs = new HashMap<>();

        for(char ch : s.toCharArray()) {
            freqs.put(ch, freqs.getOrDefault(ch, 0) + 1);
        }

        // 2. tạo bucket
        List<List<Character>> buckets = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }

        for(char key : freqs.keySet()) {
            int freq = freqs.get(key);
            buckets.get(freq).add(key);
        }


        // 2. build từ bucket có freq lớn đến nhỏ
        StringBuilder sb = new StringBuilder();
        for(int freq = n; freq >= 1; freq--) {
            for(char ch : buckets.get(freq)) {
                for(int i = 0; i < freq; i++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}