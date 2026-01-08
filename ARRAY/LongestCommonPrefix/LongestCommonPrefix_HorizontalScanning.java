
public class LongestCommonPrefix_HorizontalScanning {

    // DUYỆT THEO CHIỀU NGANG - HORIZONTAL SCANNING

    /*
        Time: O(n * m)
        Space: O(1)

        Kiểm tra vơi indexOf()

         s1.indexOf(s2): vị trí dầu tiên của String con khi nằm trọn trong String gốc

        📌 s1.length > s2.length
        s1 = "flower"
        s2 = "flow"
        👉 s1.indexOf(s2) = 0

        Kiểm tra s2 có xuất hiện trong s1 hay không?
        ➡️ Vì s2 nàm trọn trong s1 nên trả về 0


        📌 s1.length < s2.length
        s1 = "flow"
        s2 = "flower"
        👉 s1.indexOf(s2) = -1
        ➡️ Vì s2.length lớn hơn s1.length nên trả về -1
    
     */
    public static String longestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    /*
        Time: O(n * m)
        Space: O(1)

        Kiểm tra với startWith()
     */
    public static String longestPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0]; // flower

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i]; // flow

            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestPrefix(strs));
        System.out.println(longestPrefix_2(strs));
    }
}
