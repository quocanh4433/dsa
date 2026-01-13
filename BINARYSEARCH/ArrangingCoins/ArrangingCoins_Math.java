public class ArrangingCoins_Math {
    /*
        SOLUTION TỐT NHẤT

        Time: O(1)
        Space: O(1)

        🧩 Bản chất bài toán

        Tổng số xu cần để xếp k hàng là:

        1   +   2   +   3   +   4   + ... k
        k   +   (k-1)   (k-2) + .....     1

        Mỗi cặp là (k+1) và có k cặp

        👉 Tổng của 2 lần dãy là: k * (k + 1)
        👉 Tổng của 1 dãy là: k * (k + 1) / 2
        

        k*(k+1) / 2 ​≤ n
        👉 k^2 + k − 2n = 0

        Giải phương trình bật 2 trên và lấy nghiệm dương
        k =  (-1 + Math.sprt(1 + 8n)) /  2
​​
    */
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
    public static void main(String[] args) {
        
    }
}
