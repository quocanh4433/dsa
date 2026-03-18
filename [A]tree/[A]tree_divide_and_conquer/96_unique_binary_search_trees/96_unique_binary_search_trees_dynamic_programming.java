
class UniqueBinarySearchTrees_DynamicProgramming {

    /*
        time O(n**2)
        space O(n)

        ý tưởng

        số node là 1 tạo được 1 path
        số node là 2 tạo được 2 path = 1*1 + 1*1
        số node là 3 tạo được 5 path = 1*1
        
        dp = số cách trái * sô cách phải
     */
    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        }

        // dp[i]: số lượng path tối đa tạo bởi i node
        int[] dp = new int[n + 1];

        dp[0] = 1; // cây rỗng vẫn được xem là 1 cách tạo
        dp[1] = 1; // cây có 1 node có 1 cách tạo

        // fill vào dp[]
        for (int i = 2; i <= n; i++) {
            // chọn số j làm node chia left và right
            // tại sao j bắt đầu từ 1 - i mà không phải từ 0 - i?
            // do j = 0 không có node chi trái - phải
            for (int j = 1; j <= i; j++) {
                // j chi làm 2 phần
                // bên trái node j: j - 1 node
                // bên phải node j: i - j node
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
