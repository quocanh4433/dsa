
class ReverseWordsInAString_UingPointer {

    /*
        time O(n)
        space O(n)
     */
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {
            // tìm cuối word
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // tìm đầu word
            int j = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // thêm khoang trằng vào nếu đã có tù word trước đó
            if (res.length() > 0) {
                res.append(" ");
            }

            res.append(s, i + 1, j + 1);
        }

        return res.toString();
    }
}
