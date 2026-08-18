
class ValidPerfectSquare {
    /*
        time O(lognum)
        space O(1)
    */

    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;

        while(l <= r) {
            int m = l + (r - l)/2;
            long sqr = (long) m * m; 
            /*
                do m * m có thẻ vượt qua giớ hạn int nên dung long

                ✅ (long) m * m
                → m được chuyển sang long
                → phép nhân được thực hiện bằng long

                ❌ m * m 
                → m * m vẫn được tính bằng int trước
                → có thể bị integer overflow

                hoặc

                đổi l và r sang long từ đầu
            */
            
            if(sqr == num) { // java hiêu sqr == (long) num
                return true;
            } else if(sqr > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

       return false;
    }
}
