
public class GuessNumberHigherOrLower {

    /*
     * NÊN LÀM TRÊN NỀN TẢN CỦA LEETCODE
     * 
     * Time complexity: O(logn)
     * Space complexity: O(1)
     * 
     */
    public int guessNumber(int n) {
        if (n < 0) {
            return -1;
        }

        int l = 1, r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = guess(m);

            switch (res) {
                case 0 -> {
                    return m;
                }
                case 1 ->
                    r = m - 1;
                case -1 ->
                    l = m + 1;
            }

        }
        return -1;
    }

    private int guess(int m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guess'");
    }

    public static void main(String[] args) {

    }
}
