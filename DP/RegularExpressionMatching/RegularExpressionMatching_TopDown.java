
public class RegularExpressionMatching_TopDown {
    /*
        time O(n*m)
        space O(n*m)
    */
    Boolean[][] cache;
    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    public boolean dfs(String s, String p, int i, int j) {
        // base case
        if(j >= p.length()) {
            return i == s.length();
        }

        // check cache
        if(cache[i][j] != null) {
            return cache[i][j];
        }

        boolean ans;

        // kiểm tra ký tự đầu tiên
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // nếu có '*'
        if(j+1 < p.length() &&  p.charAt(j+1) == '*') { 
            boolean useZeroTime = dfs(s, p, i, j+2);
            boolean useOneMoreTime = firstMatch && dfs(s, p, i+1, j);
            ans = useZeroTime || useOneMoreTime;
        } else {
            // không có '*'
            ans = firstMatch && dfs(s, p, i + 1, j + 1);
        }

        cache[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
