
class MinimumNumberOfSwapsToMakeTheBinaryString {

    /*
        ý tưởng
            - đếm 0, 1 để biết chuỗi mẫu bắt đầu từ 0 hay 1 hoặc có thể từ cả 2
            - đếm vị trí chuỗi mẫu với chuỗi được cho
            - kết quar là sô vị trí khác / 2

        time O(n)
        space O(1)
     */
    public int minSwaps(String s) {
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            } else {
                count0++;
            }
        }

        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }

        int swap = 0;

        if (count0 > count1) {
            swap = diff('0', s);
        } else if (count0 < count1) {
            swap = diff('1', s);
        } else {
            swap = Math.min(diff('0', s), diff('1', s));
        }

        return swap / 2;
    }

    public int diff(char start, String s) {
        int swap = 0;
        int i = 0;
        while (i < s.length()) {
            if (start != s.charAt(i)) {
                swap++;
            }
            i++;
            start = start == '1' ? '0' : '1';
        }
        return swap;
    }
}
