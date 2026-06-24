import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class AlienDictionary {
    /*
        N = số lượng từ
        L = độ dài trung bình của mỗi từ
        C = số ký tự khác nhau trong toàn bộ input
        E = số quan hệ (cạnh) được tạo ra
        
     
        time: O(N + L)
        space: O(C + E)
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

        // Tạo các cặp word liền kề từ các cặp liền kề
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // case prefix in valid: abc truoc ab
            // Tai sao case nay sai ?
            // do sắp xếp thứ tự trong từ điển
            // khi 2 từ cung tiền tố thì từ ngắn hơn phải năm trước
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

                    // tai sao break ngay lặp tức
                    // trong từ điển thông thường abc < axy
                    // vì b nhỏ hơn x
                    // dó đó chỉ cần 2 chữ cái khác là đủ đề sắp xếp 2 word đó 
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

/*
Dry run

words = ["hrn","hrf","er"]

01. build graph + indegree

graph = {
    h: {}
    r: {}
    n: {}
    f: {}
    e: {}
}

indegree = {
    h: 0
    r: 0
    n: 0
    f: 0
    e: 0
}


02. so sánh từ cặp

"hrn" và "hrf"
    - 'h' và 'h' giống bỏ qua
    - 'r' và 'r' giống bỏ qua 
    - 'n' và 'f' khác
        - graph.get(n) rỗng -> thêm f vào
        - indegree của 'f' tăng thêm 1 do có thêm 1 node trỏ tới 'f' là n
        graph = {
            h: {}
            r: {}
            n: {f}
            f: {}
            e: {}
        }

        indegree = {
            h: 0
            r: 0
            n: 0
            f: 1
            e: 0
        }


"hrf" và "er"
    - 'h' và 'e' khác nhau
        - graph.get(h) rỗng -> thêm e vào
        - indegree của 'e' tăng thêm 1 do có thêm 1 node trỏ tới 'e' là h
    đã tìm thấy cặp khác nhau nên break hoàn toàn không tìm tiếp

    graph = {
        h: {e}
        r: {}
        n: {f}
        f: {}
        e: {}
        }

    indegree = {
        h: 0
        r: 0
        n: 0
        f: 1
        e: 1
    }


03. đưa các node root vào queue xử lí trước là 'h', 'r, 'n''

q = {h, r, n}

04. xử lí trong queue và có node lần cận

'h' 
    - append và result = "h"
    - lấy node kề
        - 'e' trừ đi indegree[e]
        - mà indegree[e] == 0 offer vào queue 

        graph = {
            h: {e}
            r: {}
            n: {f}
            f: {}
            e: {}
        }

        indegree = {
            h: 0
            r: 0
            n: 0
            f: 1
            e: 0
        }

        result = "h"
        
        q = {r, n, e}


'r' 
    - append và result = "hr"
    - lấy node kề - không có bỏ qua

'n' 
    - append và result = "hrn"
    - lấy node kề 
        - 'f'  indegree[f]--
        - mà indegree[f] == 0 offer vào queue 

        graph = {
            h: {e}
            r: {}
            n: {f}
            f: {}
            e: {}
        }

        indegree = {
            h: 0
            r: 0
            n: 0
            f: 0
            e: 0
        }

        result = "hrn"
        
        q = {e, f}

'e'
    - append và result = "hrne"
    - lấy node kề - không có bỏ qua

'f'
    - append và result = "hrnef"
    - lấy node kề - không có bỏ qua


return về "hrnef"
*/
