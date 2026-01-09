public class CalculateDigitSumOfAString {
    public static String digitSum(String s, int k) {
        if (s.length() < k) {
            return s;
        }

        while (s.length() > k) {
            StringBuilder temp = new StringBuilder();
            int i = 0;
            int sum = 0;

            for (char c : s.toCharArray()) {
                sum += c - '0';
                if (i == k - 1) {
                    temp.append(sum);
                    i = 0;
                    sum = 0;
                    continue;
                }
                i++;
            }

            if(i != 0) {
                temp.append(sum);
            }

            s = temp.toString();
        }

        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum("00000000", 3));
        System.out.println(digitSum("1234", 2)); // 37
        
    }
}
