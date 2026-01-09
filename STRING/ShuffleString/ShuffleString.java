
public class ShuffleString {

    /*
        Time: O(n)
        Space: O(n)
     */
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            chars[idx] = s.charAt(i);
        }

        return new String(chars);
    }

    /*
        Time: O(n)
        Space: O(n)

        Using StringBuilder + setCharAt()
     */
    public String restoreString_2(String s, int[] indices) {
        StringBuilder res = new StringBuilder(s);
        // ✅ QUAN TRONG
        // 👉tạo một StringBuilder có nội dung ban đầu giống hệt chuỗi s.

        for (int i = 0; i < s.length(); i++) {
            res.setCharAt(indices[i], s.charAt(i));
        }

        return res.toString();
    }
    public static void main(String[] args) {

    }
}
