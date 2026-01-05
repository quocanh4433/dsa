public class ReverseInteger {
    /*
        👏 Ý tưởng cốt lõi
        - Lấy từng chữ số cuối bằng % 10
        - Ghép vào kết quả bằng res = res * 10 + digit
        - Quan trọng nhất: kiểm tra overflow trước khi nhân 10 / cộng chữ số.
    
    
    */


    static int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Kiểm tra overflow
            if (reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE / 10 && digit > 7) {
                return 0;
            }

            /*
                👉 Tại sao Integer.MAX_VALUE / 10 ?
                - kiểm tra overflow trước khi nhân thêm 10

                👉 Tại sao  digit > 7 và digit < -8 ?
                - vì maxinteger = 2147483647 và mininteger = -2147483648. số 7 và -8 là 2 số cuối
             */
            if (reverse < Integer.MIN_VALUE / 10 || reverse == Integer.MIN_VALUE / 10 && digit < -8) {
                return 0;
            }

            reverse = reverse * 10 + digit;
        }
        return reverse;
    }
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}
