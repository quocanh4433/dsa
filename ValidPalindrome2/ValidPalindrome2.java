
public class ValidPalindrome2 {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     *
     */
    static boolean isValidPalidrome(String s) {
        if (s == null) {
            return false;
        }

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return palidrome(s, l + 1, r) || palidrome(s, l, r - 1);
            }

            l++;
            r--;
        }

        return true;
    }

    static boolean palidrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalidrome("aba")); // exception: true
        System.out.println(isValidPalidrome("abca")); // exception: true
        System.out.println(isValidPalidrome("abc")); // exception: false
    }
}
