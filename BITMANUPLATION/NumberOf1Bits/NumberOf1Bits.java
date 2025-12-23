public class NumberOf1Bits {
    /*
        Time: O(32)
        Space: O(1)
    
    */
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            // Kiểm tra bit cuối cung có phải bit 1
            // Nếu đúng trả về 1 
            // Nếu sai trả về 0
            n >>>= 1;        // dịch phải KHÔNG dấu
        }
        return count;
    }
    
    public static void main(String[] args) {
        
    }
}
