
public class RegularExpressionMatching {
    /*
        time O(2**(n+m))
        space O(n+m)
    */
    public boolean isMatch(String s, String p) {
        // base case
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        /*
            1. check first character
                true -> both chars are the same OR first char of p is '.' 
                false -> both character are not the same
        */
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        /*
            🧠 Tại sao firstMatch == false không return false ?
            firstMatch == false không đồng nghĩa 2 string không match
            2 string không match khi
                - firstMatch == false
                - pattern không có '*' phía sau

            VD: 
            s = "a"
            b = "b*a"

            firstMatch = false ❌ nhưng 2 string vẫn match ✅ do không dùng "b*"

        */
        

        /*
            2. Khi có '*'
                - Không dùng '*'
                    - giữ s xóa p đi 2 ký tự
                - Dùng '*' từ 1 lần trở lên
                    - xóa s 1 ký tự giữ p (chỉ thực hiện khi firstMatch = true)
        */
        if(p.length() >= 2 && p.charAt(1) == '*') {
            boolean useZeroTime = isMatch(s, p.substring(2));
            boolean useOneMoreTimes = false;
            if(firstMatch) {
                useOneMoreTimes = isMatch(s.substring(1), p);
            }
            return useZeroTime || useOneMoreTimes;

            /*
                Viết gọn hơn
                return isMatch(s, p.substring(2)); || (firstMatch && isMatch(s.substring(1), p);)
             */
        }
        
        /*
            3. Khi không có '*'
                - firstMatch = true
                - phần còn lại cung match()

        */
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
        
    }
}
