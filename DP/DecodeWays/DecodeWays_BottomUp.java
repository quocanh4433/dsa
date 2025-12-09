package DP.DecodeWays;

public class DecodeWays_BottomUp {

    /*
    Time -> O(n)
    Space -> O(n)

    Xây dựng dp[n + 1]
    - Trong đó dp[i]: số cách decode từ i đến hết chuỗi
    

     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // base case: decode xong hết chuỗi → 1 cách

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1];

            if (i + 1 < n) {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                    // i + 2 không bao giờ outOfRange
                    // do điều kiện i + 1 < n -> i + 2 <= n
                }
            }
        }

        return dp[0];

    }


    /*
    Time -> O(n)
    Space -> O(1)    
     */
    public int numDecodings_2(String s) {
        int n = s.length();

        int dp = 0; // dp[i]
        int dp1 = 1; // dp[i + 1]
        int dp2 = 0; // dp[i + 2]

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp = 0;
            } else {
                // decode 1 ký tự
                dp = dp1;
    
                // decode 2 ký tự
                if (i + 1 < n) {
                    int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                    if (num >= 10 && num <= 26) {
                        dp += dp2;
                    }
                }

            }

            // cập nhật để chuẩn bị cho vòng lặp tiếp theo
            dp2 = dp1;  // dịch dp[i+1] thành dp[i+2]
            dp1 = dp;      // dịch dp[i] thành dp[i+1]

        }

        return dp1;
    }

    public static void main(String[] args) {

    }
}
