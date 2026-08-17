import java.util.HashMap;
import java.util.Map;

class IsomorphicStrings {

    /*
        isomorphic - đồng cấu - cùng cấu trúc 
        a suy ra b thì 
        b chỉ suy ra a

        time O(n)
        space O(2n) ~ O(n) nếu chi có chữ cái ~ O(1)
    
     */
    public boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> s1ToS2 = new HashMap<>();
        Map<Character, Character> s2ToS1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (s1ToS2.containsKey(a) && s1ToS2.get(a) != b) {
                return false;
            }
            if (s2ToS1.containsKey(b) && s2ToS1.get(b) != a) {
                return false;
            }

            s1ToS2.put(a, b);
            s2ToS1.put(b, a);
        }

        return true;
    }
}
