
public class StringToInteger {
    /*
        Time: O(n)
        Space: O(1)
    
    */


    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;

        // 1. ignore whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. determin signed
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? - 1 : 1;
            i++;
        }

        // 3. interative through the digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. check overflow
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && digit > 7) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }
    public static void main(String[] args) {
        
    }
}
