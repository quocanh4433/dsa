class RomanToInteger {
    /*
        time O(n)
        space O(26) ~ O(1)

        mấu chốt là số hiện tại nhỏ hơn số phía sau thì trừ
     */
    public int romanToInt(String s) {
        int[] roman = new int[26];
        roman['I' - 'A'] = 1;
        roman['V' - 'A'] = 5;
        roman['X' - 'A'] = 10;
        roman['L' - 'A'] = 50;
        roman['C' - 'A'] = 100;
        roman['D' - 'A'] = 500;
        roman['M' - 'A'] = 1000;

        int res = 0;
        int n = s.length();

        for(int i = 0; i < n - 1; i++) {
            int cur_val = roman[s.charAt(i) - 'A'];
            int next_val = roman[s.charAt(i + 1) - 'A'];

            if(cur_val < next_val) {
                res -= cur_val;
            } else {
                res += cur_val;
            }
        }

        return res + roman[s.charAt(n - 1) - 'A'];
    }
}