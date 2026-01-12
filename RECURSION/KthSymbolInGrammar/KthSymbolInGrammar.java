
public class KthSymbolInGrammar {
    /*
        Time: O(n)
        Space: O(n)
    */

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int mid = 1 << (n - 2); // 2^(n-2)
        /*
            Biểu thị 8bit
            0000 0001 << 3   -> 0000 1000 = 8  
            -> mid = 8
         */

        if (k <= mid) {
            /*
                Row 3:  0 1 1 0
                Row 4:  0 1 1 0 | 1 0 0 1
                        ↑
                        nửa trái = Row 3
                
                khi k <= mid thi k năm ở nữa trái mà nữa trái chính là Row n -1
             */
            return kthGrammar(n - 1, k);
        } else {
            /*
                Row 3:  0 1 1 0
                Row 4:  0 1 1 0 | 1 0 0 1
                                    ↑
                                    nửa phải = Row 3
                
                khi k > mid thi k năm ở nữa phải và đảo bit của row n - 1 

                🚀 Tại sao phải lấy 1 trừ kết quả?
                1 - kết quả là cách đảo bit giồn x ^ 1
             */
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
    public static void main(String[] args) {

    }
}
