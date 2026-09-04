public class CountingBits {
    /*
        SOLUTION 1: Bit manupaltion

        Time: O(nlogn)
        Space: O(n)

        Brian Kernighan’s Algorithm
    */


    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                res[i]++;
                num &= (num - 1);
                /*
                    👉 Mỗi lần thực hiện, xóa đi bit 1 thấp nhất của num.

                    Lần 1
                    num = 12 = 1100
                    num - 1 = 11 = 1011
                    num & (num - 1) = 1000 (xóa 1 bit 1)

                    Lần 2
                    num = 8 = 1000
                    num - 1 = 0111 
                    num & (num - 1) = 0000 

                    📌 Vòng while chạy 2 lần

                */
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}
