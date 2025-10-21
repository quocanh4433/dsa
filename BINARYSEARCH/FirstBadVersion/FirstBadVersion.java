
public class FirstBadVersion {

    /* BAI NAY NEN ALM TREN NEN TANG CUA LEETCODE */
    public static int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }

        int l = 0, r = n;

        while (l < r) {
            int m = l + (r - l) / 2; // Nếu l và r quá lớn thì int m = (l + r) / 2 gây OVERFLOW

            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;

    }

    public static boolean isBadVersion(int num) {
        return true;
    }

    public static void main(String[] args) {

    }
}
