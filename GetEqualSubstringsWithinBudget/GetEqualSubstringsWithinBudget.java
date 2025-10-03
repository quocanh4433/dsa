
public class GetEqualSubstringsWithinBudget {

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int count = 0;
        int l = 0;
        int currentCost = 0;

        for (int r = 0; r < n; r++) {
            currentCost += Math.abs(s.charAt(r) - t.charAt(r));

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            count = Math.max(count, r - l + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3)); //exception: 3
        System.out.println(equalSubstring("abcd", "cdef", 3)); //exception: 1
        System.out.println(equalSubstring("abcd", "acde", 0)); //exception: 1
    }
}
