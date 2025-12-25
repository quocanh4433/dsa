public class ReverseBits {
    /*
        🔥 Tóm tắt ý tưởng
        ✔ Lấy từng bit của n
        ✔ Đặt nó vào vị trí đối xứng trong res
        ✔ Làm đủ 32 bit → hoàn thành


        Time: O(32) ~ O(1)
        Space: O(1)
    
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {

            // Lấy bit cuối - sau đó shift ra
            int bit = (n >> i) & 1;
            /*
                n = 5 -> 0101

                Vòng 1
                0101 >> 0 = 0101
                & 0001     = 1   ← LẤY TRƯỚC

                Vòng 2
                0101 >> 1 = 0010
                & 0001     = 0

                Vòng 3
                0101 >> 2 = 0001
                & 0001     = 1   ← bit này vốn ở vị trí 2

                Vòng 4
                0001 >> 2 = 0000
                & 0001     = 0   ← bit này vốn ở vị trí 2
            
             */

            //  👉 Đặt bit vừa lấy được vào đúng vị trí đảo ngược trong res
            res += (bit << (31 - i));
        }

        return res;
    }
    
    public static void main(String[] args) {
        
    }
}
