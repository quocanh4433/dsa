public class MissingNumber {
    /*
        💡 IDEA: Dựa theo tính chất của XOR: 
        a^a = 0
        a^0 = a


        Cho tất "sô đang có" XOR với "số phải có" để cặp số trùng nhau
        thủ tiêu lẩn nhau

        Example:

        Số đang có: [0, 2, 3]
        Số phải có: [0, 1, 2, 3]

        Cho tất cả XOR với nhau: 
        res = 0 ^ 2 ^ 3 ^ 0 ^ 1 ^ 2 ^ 3
            = (0^0) ^ (2^2) ^ (3^3) ^ 1  // Những cặp trùng nhau sẽ trả về 0
            = 0 ^ 0 ^ 0 ^ 1
            = 1 // Kết qảu cuối cùng

            

        🕓 Time:   O(n)
        💾 Space:  O(1)
    */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;

        /*
            🧩 Vì sao bắt đầu bằng xorr = n ?
                Vì vòng i chỉ chạy từ 0 → n-1
                → chưa XOR số n (3)
                → phải thêm thủ công ngay từ đầu
        */

        for(int i =  0; i < n ; i++) {
            xorr ^= i ^ nums[i];
        }

        return xorr;
    }


    public static void main(String[] args) {
        
    }
}
