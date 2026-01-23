

public class LongestPalindrome {
    /*
        time O(n)
        space: O(1)
    */
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        // Tại sao là 128 vì a-z và A-Z nằm trong khoảng 65 dến 122 trong ASCII. 
        // Nên có thể để số bất kỳ lớn hơn 122
        // char c là mà ASCII nên có thể là index của int[] count
        int[] count = new int[128];
        for(char c : s.toCharArray()) {
            count[c]++;
        }

        int longest = 0;
        boolean hasOdd = false;

        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 0) {
                longest += count[i];
            } else {
                longest += count[i] - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? longest + 1: longest;
    }

    public static void main(String[] args) {
        LongestPalindrome LP = new LongestPalindrome();
        System.out.println(LP.longestPalindrome("abccccdd"));
    }
}
