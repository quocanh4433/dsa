import java.util.ArrayList;
import java.util.List;

class FindAllAnagramsInAString {

    /*
        - count string p
        - mở rông window đến p.length
            - nếu len(window) < len(p) tăng len(window)
            - nếu len(window) == len(p): kiểm tra count(p) và count(window)
                - bằng nhau them left vào result
                - tăng left tính tại count(window)

        time O(n)
        space O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        if (n < m) {
            return res;
        }

        int[] countP = new int[26];
        int[] countW = new int[26];

        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (left <= right && right < n) {
            char charRight = s.charAt(right);
            countW[charRight - 'a']++;

            if (right - left + 1 == m) {

                if (isSame(countP, countW)) {
                    res.add(left);
                }

                char charLeft = s.charAt(left);
                countW[charLeft - 'a']--;
                left++;
            }

            right++;
        }

        return res;
    }

    public boolean isSame(int[] countP, int[] countW) {
        for (int i = 0; i < 26; i++) {
            if (countP[i] != countW[i]) {
                return false;
            }
        }

        return true;
    }
}
