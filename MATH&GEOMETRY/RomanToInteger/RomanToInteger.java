
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        // Cộng thêm chữ cuối cùng do vòng lặp ở trên không chạy đến phần từ cuối cùng
        return res + roman.get(s.charAt(s.length() - 1));
    }

    /*
     * NOT USING HASHMAP - BETTER PERFORMANCE
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     * 
     */
    public int romanToInt_2(String s) {
        int res = 0;
        int[] roman = new int[26];
        roman['I' - 'A'] = 1;
        roman['V' - 'A'] = 5;
        roman['X' - 'A'] = 10;
        roman['L' - 'A'] = 50;
        roman['C' - 'A'] = 100;
        roman['D' - 'A'] = 500;
        roman['M' - 'A'] = 1000;

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman[s.charAt(i) - 'A'] < roman[s.charAt(i + 1) - 'A']) {
                res -= roman[s.charAt(i) - 'A'];
            } else {
                res += roman[s.charAt(i) - 'A'];;
            }
        }

        return res + roman[s.charAt(s.length() - 1) - 'A'];
    }

    public static void main(String[] args) {

    }
}
