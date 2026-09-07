
class MultiplyStrings {

    /*
        n: len(num1)
        m: len(num2)

        length of result is n + m

        time O(n * m)
        space O(n + m)
     */
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                int mul = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                int sum = res[i + j + 1] + mul;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int p : res) {
            if (sb.length() == 0 && p == 0) {
                continue;
            }
            sb.append(p);
        }

        return sb.toString();
    }
}


/*
            1   4   5
            2   3   9    
            ----------
        1    3   0   5
        4    3   5
    2   9    0
    ----------------------
    3   4   6    5   5
    _ _ _ _ _ 5
 */ 
