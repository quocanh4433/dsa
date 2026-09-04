package STRING.PalindromicSubstrings;

public class PalindromicSubstrings {

    /**
     * 💡 Ý TƯỞNG:

     *      - Mỗi ký tự (hoặc giữa 2 ký tự) có thể là tâm của palindrome.

     *      - Mở rộng sang trái và phải cho đến khi không còn palindrome.

     *      - Đếm tất cả.
     * 
     * n = s.length
     * 
     * Time complexity: O(n^2)
     * 
     * Space complexity: O(1)
     * 
     */

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // 1. Palindrome lẻ: tâm tại i
            count += expandAroundCenter(s, i, i);
            // 2. Palindrome chẵn: tâm giữa i và i+1

            // 👉 Tại sao không phải là i - 1 ?

            // 👉 Có thể dùng i - 1 được không ?
            count += expandAroundCenter(s, i, i + 1); 

            // 👉 Tại sao lại tính 2 lần ?

            // 👉 Tại sao 2 lần tính kết quả không trùng nhau ?
        }
        return count;
    }

    public int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
