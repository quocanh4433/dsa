import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentWords {

    /*
        time O(nlogk)
        space O(n)
    
     */
    class Pair {

        String str;
        int freq;

        Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return Integer.compare(a.freq, b.freq);
            }
            return b.str.compareTo(a.str); // Alphabet giảm dần
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();
            minHeap.offer(new Pair(str, freq));

            if (minHeap.size() > k) {
                minHeap.poll(); // nếu vượt qua k thi lấy ra phần tử có số lần nhỏ nhất
            }
        }

        List<String> res = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().str);
        }

        Collections.reverse(res);

        return res;
    }
}
