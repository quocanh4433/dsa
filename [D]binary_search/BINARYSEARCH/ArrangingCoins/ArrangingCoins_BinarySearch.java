public class ArrangingCoins_BinarySearch {
    /*
        SOLUTION: BINARY SEARCH
        Time: O(logn)
        Space: O(1)

        ✅ Ý tưởng
        👉 k nằm trong khoảng [0, n]
        👉 tìm k lớn sao cho k * (k + 1) / 2 <= n
    */
    public int arrangeCoins(int n) {
        long l = 0, r = n; // left right không phải index mà là vùng tìm kiếm

        while (l <= r) {
            long k = l + (r - l) / 2;
            /*
                k = số hàng ta đang “thử nghiệm”

                VD: 
                k = 3 -> có 3 hàng -> số đồng xu tối đa của cả 3 hàng = 6 (chính là biến coins)
                🔘
                🔘🔘
                🔘🔘🔘

                k = 4 -> có 4 hàng -> số đồng xu tối đa của cả 3 hàng = 6 (chính là biến coins)
                🔘
                🔘🔘
                🔘🔘🔘
                🔘🔘🔘🔘


                Tam giác này có k hàng. Nếu lật ngược & ghép với một tam giác giống nó:
                ▲ + ▼ = hình chữ nhật
                Chiều cao: k
                Chiều rộng: k+1
                👉 Diện tích hình chữ nhật: k * (k + 1);
                👉 Tam giác = 1/2 hình chữ nhật:  k * (k + 1) / 2 

                Chính là biến coins ⬇️🔻 bên dưới
             */
            long coins = k * (k + 1) / 2;

            if (coins == n) {
                return (int) k; // Số xu cần có bằng đúng n
            }
            if (coins > n) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return (int) r;
        /*
            Tại sao return về right và không phải left?
            n = 5
            [1 2 3 4 5]
            
            loop 1 
                l = 0, r = 5
                k = 2
                coins = 3 < n -> tăng left = k + 1 = 3 
            loop 2 
                l = 3, r = 5
                k = 4
                coins = 10 > n -> giảm right = k - 1 = 3 
            loop 3
                l = 3, r = 3
                k = 3
                coins = 6 > n -> giảm right = k - 1 = 2 
            loop 4 
                l = 3, r = 2
                l > r dừng loop -> return r = 2;



            👉 left right không phải index mà là vùng tìm kiếm
            ở vị trí khởi tạo
            left = 0    👉 luôn trỏ tới giá trị KHÔNG HỢP LỆ đầu tiên
            right = n   👉 luôn trỏ tới giá trị HỢP LỆ

            Hợp lệ = xếp được   
            Không hợp lệ = không đủ xu

            👉 Khi return cần lấy giá trị hợp lệ là right

         */
    }
    public static void main(String[] args) {
        
    }
}
