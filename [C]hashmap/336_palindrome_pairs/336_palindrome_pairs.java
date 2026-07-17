import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PalindromePairs {
       /*
        ★ paldirome: là chuỗi đọc xuôi hay ngược đều như nhau
        "sss"
        - đọc xuôi: sss
        - đọc ngược: sss
        -> palidrome

        "abba"
        -> đọc xuôi: abba
        -> đọc ngược: abba
        -> palidrome


        ★ Case 1: palindrome word + empty string
        "a" + "" = "a" ✅
        "abba" + "" = "abba" ✅

        ★ Case 2: empty string + palindrome word
            "" + "a" = "a" ✅
            "" + "abba" = "abba" ✅

        ★ Case 3: word + reverse(word)
            "abcd" + "dcba" = "abcddcba" ✅

        ★ Case 4: word1 + word2 
            s + llsa = asllsa ✅ 

            Với case 4 chính xác hơn 1 phần của word1 hoặc word2 là palidrome theo ví dụ trên 
            ta có thể chia word2 như sau

            "" | "llsa"
            "l" | "lsa"
            "ll" | "sa"
            "lls" | "a"
            "llsa" | ""

            trong đó ở lần chia thứ 3 ta được

            "ll" : palidrome

            "sa" : suffix

            nếu word1 là reverse(suffix) thì

            word1 + word2 = palidrome ✅



        ★ Case 5: word1 + word2 

            cũng tương tự case 4 nhưng cho preffix


        nhìn chung có 2 trường hợp word = prefix | suffix

        ★ prefix là palidrome thì tìm reverse(suffix)
        ★ suffix là palidrome thì time reverse(prefix)



        n = số lượng từ (words.length)
        k = độ dài trung bình của mỗi từ

        time O(n × k²)
        space O(n × k) (không tính danh sách kết quả res)

    
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            String word = words[i];

            for(int j = 0; j <= word.length(); j++) {

                String left = word.substring(0, j);
                String right = word.substring(j); // từ j + 1 đến hết

                if(j != 0 && isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();

                    if(map.containsKey(revRight) && map.get(revRight) != i) {
                        res.add(Arrays.asList(map.get(revRight), i));
                    }
                }

                if(isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();

                    if(map.containsKey(revLeft) && map.get(revLeft) != i) {
                        res.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
