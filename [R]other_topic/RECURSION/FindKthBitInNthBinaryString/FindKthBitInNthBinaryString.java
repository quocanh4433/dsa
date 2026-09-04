public class FindKthBitInNthBinaryString {
    /*
        Time: O(2^n)
        Space: O(2^n) = 2^1 + 2^2 + ... + 2^n 

        KHÔNG ĐAT YÊU CẦU 
    */



    String[] strs;

    public char findKthBit(int n, int k) {
        this.strs = new String[n + 1];
        strs[1] = "0";

        // create string s + index
        for (int i = 2; i <= n; i++) {
            strs[i] = strs[i - 1] + "1" + revert(invert(strs[i - 1]));
        }

        // find kth bit
        /*
            char res = ' ';
            for (int i = 0; i < strs[n].length(); i++) {
                if (i == k - 1) {
                    res = ;
                }
            }
            return res;
        */

        // Chỉ cần viết ngắn gọn
        return strs[n].charAt(k - 1);
    }

    public String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
        return new String(chars);
    }

    public String revert(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        FindKthBitInNthBinaryString FindKth = new FindKthBitInNthBinaryString();
        System.out.println(FindKth.findKthBit(3, 1));
    }
}
