
public class ReverseString {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     */
    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(s2);
    }
}
