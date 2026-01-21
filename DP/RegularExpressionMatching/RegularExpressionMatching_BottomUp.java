
public class RegularExpressionMatching_BottomUp {
    /*
        time O(m*n)
        space O(m*n)
    */

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        /*
            Xét trường hợp s = "" p = a*

                    ∅   a   *   
            s   ∅   t   f   t   
                a   f   f   f   
                a   f   f   f           
                            🖕
                        dp[0][j]      
        
        */ 
        for(int j = 2; j <= m; j++) { 
            // Tại sao j = 2 vì * không đứng một mình nên có độ dài la 2 j = 2
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j-2]; 
            }
        }


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);

                if(cp == '.' || cs == cp) {
                    dp[i][j] = dp[i - 1][j - 1];
                }  
                
                if (cp == '*') {
                    /*
                        match 0 lần
                        s = abc  p = abx*

                        match 0 lần bỏ x*

                        s = abc so với p = ab
                        👉 dp[3][4] = dp[3][2]
                    */
                   dp[i][j] = dp[i][j-2];


                    /*
                        match >= 1 lần

                        * đứng 1 mình cần tìm ký tự trước đó

                        prev = p.charAt(j-2)

                        prev == sc || prev == '.'
                        -> ăn 1 ký tự, giữ nguyên pattern

                        s = a  p = a*
                        -> ăn 1 ký tự
                        s = "" so với p = a*
                        👉dp[1][2] = dp[0][2] = false
 
                                ∅   a   *   
                        s   ∅   t   f   t   
                            a   f   t   t   
                            a   f   f   t   
                               
                    
                    */

                    char prev = p.charAt(j-2);
                    if(prev == cs || prev == '.') {
                        // Toán tử OR (|)
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }    
                }                
            }
        }

        return dp[n][m];
    }

    

    public static void main(String[] args) {
        
    }
}
