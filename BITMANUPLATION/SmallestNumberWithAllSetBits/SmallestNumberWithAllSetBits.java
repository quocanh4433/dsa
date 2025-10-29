public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        // Bước 1: Tìm số bit cần biểu diễn n
        int k = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        // Integer.SIZE = 32 (số bit của int)
        // numberOfLeadingZeros(n) = số bit 0 đứng trước bit 1 đầu tiên
        // Ví dụ n = 5 (101₂), leading zeros = 29, k = 32 - 29 = 3 bit

        // Bước 2: Tạo số tất cả bit 1 với k bit
        int result = (1 << k) - 1;

        return result;
    }
    public static void main(String[] args) {
        
    }
}
