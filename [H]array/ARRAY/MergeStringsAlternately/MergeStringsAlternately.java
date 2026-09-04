
public class MergeStringsAlternately {

    /*
     * THIS CODE IS NOT OPTIMIZED - THE BETTER CODE IS BELOW
     * 
     * Time complexity: O(max(m, n))
     * 
     * Space complexity: O(m + n)
     * 
     */
    public static String mergeAlternately(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return new String();
        }

        StringBuilder result = new StringBuilder(word1.length() + word2.length());
        int n = Math.max(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            if (i < word1.length() && i < word2.length()) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(i));
            }

            if (i >= word1.length() && i < word2.length()) {
                result.append(word2.charAt(i));
            }

            if (i < word1.length() && i >= word2.length()) {
                result.append(word1.charAt(i));
            }
        }

        return result.toString();
    }

    /*
     * THE BETTER CODE
     * 
     * Time complexity: O(max(m, n))
     * 
     * Space complexity: O(m + n)
     * 
     */
    public static String mergeAlternately_2(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return new String();
        }

        StringBuilder result = new StringBuilder(word1.length() + word2.length());
        int n = Math.max(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        /* HOẶC

        int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) result.append(word1.charAt(i++));
            if (j < word2.length()) result.append(word2.charAt(j++));
        }
         
         */
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr")); // exception: "apbqcr"
        System.out.println(mergeAlternately("ab", "pqrs")); // exception: "apbqrs"
        System.out.println(mergeAlternately("abcd", "pq")); // exception: "apbqcd" 
        System.out.println("----------------------------------");
        System.out.println(mergeAlternately_2("abc", "pqr")); // exception: "apbqcr"
        System.out.println(mergeAlternately_2("ab", "pqrs")); // exception: "apbqrs"
        System.out.println(mergeAlternately_2("abcd", "pq")); // exception: "apbqcd" 

    }

}
