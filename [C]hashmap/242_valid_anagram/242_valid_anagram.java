
class ValidAnagram {

    /*
        time O(n)
        space O(1)

        lơi giải phù hợp khi t và s chi gồm chữ thường

        nếu có thêm ý tự khác dùng map
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // có thể gọp 2 vong for trên thanh 1 vòng for


        for (int c : count) {
            if (c > 0 || c < 0) { // viết gọn hơn với c != 0
                return false;
            }
        }

        return true;
    }
}
