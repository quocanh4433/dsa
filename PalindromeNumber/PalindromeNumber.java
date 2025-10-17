
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int xcopy = x;
        int reverse = 0;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        /*
        💡 Tương đương với
        while (x > 0) {
            int digit = x % 10;           // lấy chữ số cuối
            reverse = reverse * 10 + digit; // thêm vào kết quả
            x = x / 10;                   // bỏ chữ số cuối
        }

         */
        return reverse == xcopy;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(235)); // false
    }
}
