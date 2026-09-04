public class CheckIfDigitsAreEqualInStringAfterOperations1 {
    /*
     * Time: O(n^2)
     * 
     * Space: O(n)
     * 
     * 
     */


    public static  boolean hasSameDigits(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 2) {
            return chars[0] == chars[1];
        }

        int i = 0;
        StringBuilder res = new StringBuilder();

        while (i < chars.length - 1) {
            int num = ((chars[i] - 0) + (chars[i + 1] - 0)) % 10;
            res.append(Integer.toString(num));
            i++;
        }

        return hasSameDigits(res.toString());
    }

    /*
     * CODE GON HON - DE DOC HON
     * 
     * Time: O(n^2)
     * 
     * Space: O(n)
     */

    public static boolean hasSameDigits_2(String s) {
        if(s == null) return false;

        while(s.length() > 2) {
            char[] chars = s.toCharArray();
            StringBuilder res = new StringBuilder();
            
            for(int i = 0; i < chars.length - 1; i++) {
                int num = ((chars[i] - 0) + (chars[i + 1] - 0)) % 10;
                res.append(Integer.toString(num));
            }

            s = res.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }

    /*
     * FIND DIFFERENT SOLUTION
     * 
     * Time: O(n2)
     * 
     * Space: O(n)
     */




    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902")); // true
        System.out.println(hasSameDigits("34789")); // false
        System.out.println(hasSameDigits_2("3902")); // true
        System.out.println(hasSameDigits_2("34789")); // false
        }
}
