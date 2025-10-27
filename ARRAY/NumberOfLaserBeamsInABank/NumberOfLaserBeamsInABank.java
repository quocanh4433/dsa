public class NumberOfLaserBeamsInABank {
    /**
     * IDEA: 
     * Lấy số lượng lazer beam hiện tại nhân với số lượng lazer ở hàng trước đó nếu có
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(1) 
     * 
     * 
     */
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;

        for (int i = 0; i < bank.length; i++) {
            int curr = 0;

            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    curr += 1;
                }
            }

            if (curr > 0) {
                ans += curr * prev;
                prev = curr;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}
