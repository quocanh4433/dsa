
public class FindKthBitInNthBinaryString_Recusion {

    /*
        Time: O(n)
        Space: O(n) 

        Sn = Sn - 1 + "1" + reverse(invert(Sn - 1))

        👉  len(n)  = len(n-1) + 1 + len(n-1)
                    = 2 * len(n-1) + 1

        mà len(n - 1) = 2^(n - 1) - 1    
        
        👉  len(n)  = 2 * (2^(n - 1) - 1) + 1 = 2^1 * 2^(n-1) - 1 
                    = 2^1 * 2^(n-1) - 1 = 2^(n - 1 + 1) - 1
                    = 2^n - 1

        👉 mid = (len(n-1) + 1) / 2

     */

    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (int) Math.pow(2, n) - 1;
        int mid = (len + 1) / 2;

        if (k == mid) {
            return '1'; 
        }else if (k < mid) {
            /*  
                k < mid -> k nằm trong phần S(n-1) ;
                
                Vì sao gọi findKthBit(n-1, k) (không đổi k)? ✅
                👉 k nằm trong phần S(n-1) MÀ vị trí các bit cố đinh
            */
            return findKthBit(n - 1, k); 
         }else {
            /*
                VD: 
                S2 = "001"

                S3  = S2 + "1" + S2
                    = 011  "1"    001

                n = 3 , k = 5
                len = 7 ,  mid = 3 
                👉 k > mid -> k năm bên phải số 1
                👉 trong vd là S2 tức S(n - 1)

                -> Bài toán lúc này quy về tìm với 
                n là  n-1 
                k là len - k + 1

                Vì sao gọi len - k + 1? ✅
                CHƯA HIỂU PHẦN NAY ❌
            */
            return (findKthBit(n - 1, len - k + 1) == '0') ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString_Recusion FindKth = new FindKthBitInNthBinaryString_Recusion();
        System.out.println(FindKth.findKthBit(3, 1));
    }
}
