
class FindTheIndexOfTheFirstOccurrenceInAString_RapinKarp {

    /*
        Rapin_Karp solution

        time O(n + m)
        space O(1)
    
     */

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m) {
            return -1;
        }
        if (m == 0) {
            return 0;
        }

        long BASE = 31;
        long MOD = 1_000_000_007L;

        // Tính BASE^(m - 1) % MOD
        // Khởi tạo power = BASE^0 = 1
        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            // Mỗi bước nhân thêm BASE và lấy dư % MOD để tránh tràn số
            power = (power * BASE) % MOD;
        }

        long needleHash = 0;
        long windowHash = 0;

        // Tính Hash cho needle và cửa sổ m ký tự đầu tiên của haystack
        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * BASE + (needle.charAt(i) - 'a' + 1)) % MOD;
            windowHash = (windowHash * BASE + (haystack.charAt(i) - 'a' + 1)) % MOD;
        }

        // Duyệt từng cửa sổ trượt
        for (int i = 0; i <= n - m; i++) {
            // Nếu hash trùng, kiểm tra thực tế từng ký tự để xử lý Hash Collision
            if (windowHash == needleHash) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }

            // Tính Hash cho cửa sổ tiếp theo bằng Rolling Hash
            if (i < n - m) {
                long removeVal = (haystack.charAt(i) - 'a' + 1) * power % MOD;

                // tránh windowHash - removeVal ra số âm nên công thêm MOD
                // do cộng thêm MOD nên có nguy cơ tràn số nên % tiếp tục với MOD
                windowHash = (windowHash - removeVal + MOD) % MOD;
                windowHash = (windowHash * BASE + (haystack.charAt(i + m) - 'a' + 1)) % MOD;

            }
        }

        return -1;
    }
}
