package DP.DecodeWays;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_TopDown {

    /*
    Time -> O(n)
    Space -> O(n)
    
    
    */

    private String s;
    private Map<Integer, Integer> dp;

    public int numDecodings(String s) {
        this.s = s;
        this.dp = new HashMap<>();
        return dfs(0);
    }

    public int dfs(int i) {
        // Base case: đi hết chuỗi → là 1 cách thành công
        if (i >= s.length()) {
            return 1;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        // Có 2 lựa chón
        // 1️⃣ Decode 1 ký tự
        int res = dfs(i + 1);

        // 2️⃣ Decode 2 ký tự nếu hợp lệ
        if (i + 1 < s.length()) {
            // Lấy 2 số s[i] và s[i+1] ghép lại thành số 2 chữ số:
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num >= 10 && num <= 26) {
                res += dfs(i + 2);
            }
        }

        dp.put(i, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
