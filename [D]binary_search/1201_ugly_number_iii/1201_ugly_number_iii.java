
class UblyNumberIII {

    /*
        input:  1 <= n, a, b, c <= 10^9
        output: 
            tìm tập hợp S = {%a or %b or %c} = {s1, s2, s3, ..., sn, ....}
            trả về vị trí Sn

        lưu ý

            n trong worst case = 10^9
            tức tập S phải có ít nhất 10^9 phần tử

            nhưng n = 10^9 và a = b = c = 2
            lúc này tập S chỉ có (10^9 / 2) ~ 500tr phần tử. 
            KHÔNG thể lấy được phần tử thứ 10^9
            Do đó, cần mở rộng phạm vị của tập S là 2 * 10^9 


        tại sao không phải là 3 4 hay 5 mà lại là 2 * 10^9?
        chính xác hơn sức chưa của tập S là min(a, b, c) * n

        nếu n = 10 và a = b = c = 3 tập S = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30} 
        min(3, 3, 3) * 10 = 30 -> trả về phân từ thứ 10 trong tập S là 30


        nếu n = 10 và a = 2,  b = c = 3 tập S = {2, 4, 3, 6, 8, 9, 10, 12, 15, 18} 
        min(2, 3, 3) * 10 = 20 -> trả về phân từ thứ 10 trong tập S là 18





        binary search O(log(high))
        tìm lcm và gcd O(log(min(a,b,c)))
        -> time O(log(high) * log(min(a,b,c)))
        -> space O(1)
        

    
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        // Áp dụng Thuật toán Euclid
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);

        // tại sao dùng 'long'?
        // worst case: min(a, b, c) = n = 10^9 -> high = 10^18 lớn hơn int32
        long low = 1;
        long minABC = Math.min(a, Math.min(b, c));
        long high = minABC * n;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Đếm số lượng số <= mid chia hết cho a, b hoặc c
            long count = mid / a + mid / b + mid / c
                    - mid / ab - mid / bc - mid / ac
                    + mid / abc;

            if (count >= n) {
                result = mid;
                high = mid - 1; // Thu hẹp phạm vi để tìm số nhỏ nhất thỏa mãn
            } else {
                low = mid + 1;  // Tăng giá trị mid lên
            }
        }

        return (int) result;
    }

    // tìm ức chung lớn nhất gcb (greatest common divisor)
    public long gcp(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    // tìm bội chung nhỏ nhất lcm (least common multiple)
    public long lcm(long x, long y) {
        return (x * y) / gcp(x, y);
    }
}
