
public class ValidPalindrome {

    static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        // String s = "Was it a car or a cat I saw?";
        // System.out.println(isPalindrome(s));

        // String s2 = "tab a cat";
        // System.out.println(isPalindrome(s2));

        /* FAIL at testcase */
        // String s3 = "A man, a plan, a canal: Panama";
        // System.out.println(isPalindrome(s3));
        String s4 = ".,";
        System.out.println(isPalindrome(s4));

    }
}
