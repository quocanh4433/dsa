
// MINH HỌA DỄ HIỂU
// https://www.geeksforgeeks.org/dsa/word-break-problem-dp-32/

import java.util.List;

public class WordBreak_BottomUp {

    /*
    Time -> O(n * m * t)
    Space -> O(n)
    
    n is the length of the string s
    m s the number of words in wordDict
    t is the maximum length of any word in wordDict
    */


    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // Why we need n + 1?
        dp[0] = true; // Why dp[0] = true ? chuỗi rỗng luôn tách được

        // Traverse through the given string
        for (int i = 1; i <= n; i++) {
            // Traverse through the dictionary words
            for (String w : wordDict) {
                int start = i - w.length();


                if (start >= 0 && dp[start] && s.substring(start, start + w.length()).equals(w)) {
                    // Tai sao kiểm tra dp[start] = true
                    //👉 dp[start] = true nghĩa là:
                    // Chuỗi s[0 : start] (từ đầu đến vị trí start – 1) có thể tách được theo wordDict

                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
