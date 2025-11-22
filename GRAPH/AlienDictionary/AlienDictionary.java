import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    /*
     * N = số lượng từ
     * L = độ dài trung bình của mỗi từ
     * C = số ký tự khác nhau trong toàn bộ input
     * E = số quan hệ (cạnh) được tạo ra
     * 
     * 
     * Time complexity: O(N + L)
     * Space complexity: O(C + E)
     * 
     */


    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        // OR sử dụng List
        //  Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Khởi tạo tất cả các ký tự
        for(String w: words) {
            for(char c : w.toCharArray()) {
                graph.put(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Tạo các cách cạnh từ các cặp liền kề
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // case prefix in valid: abc truoc ab
            // Tai sao case nay sai
            if(w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for(int k = 0; k < len; k++) {
                char c1 = w1.charAt(k);
                char c2 = w2.charAt(k);
                
                if(c1 != c2 ) {
                    // Tại sao phai them dieu kien nay ?
                    if(!graph.get(c1).contains(c2)) { 
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Topological sort
        Queue<Character> q = new LinkedList<>();
        for(char c : inDegree.keySet()) {
            if(inDegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            char cur = q.poll();
            result.append(cur);
            
            for(char next : graph.get(cur)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }

        // Check neu co cycle
        if(result.length() != inDegree.size()) {
            return "";
        }

        return result.toString();
    }
    public static void main(String[] args) {
        
    }
}
