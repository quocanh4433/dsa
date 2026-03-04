
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        /*
            time: O(K)
            space: O(K)

            K: tổng số ký tự của tất cả các từ

            🔎 ứng dụng: text rendering egine  
            tính năng justify alignment trong M.Words

         */

        int n = words.length;
        int i = 0;
        List<String> res = new ArrayList<>();

        while (i < n) {
            // chiều dài trên một dong 
            int lineLenght = words[i].length();
            // kiểm tra word kế tiếp
            int j = i + 1;

            // 1️⃣ gom các word đủ điều kiện lên một line
            // +1 chính là 1 space tối thiểu giữa 2 từ
            while (j < n && lineLenght + 1 + words[j].length() <= maxWidth) {
                lineLenght += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWord = j - i;

            /*
                nếu là dòng cuối (j == n) or dòng chỉ có 1 từ (numberOfWord == 1)
                ▪︎ space giữa các word là 1
                ▪︎ space còn lại nằm bên trái

                example: words = ["hello", "word"] maxWidth = 20
                -> "hello word            "

                example: words = ["abc", "j"] maxWidth = 3
                -> "abc", "j   "
             */
            if (j == n || numberOfWord == 1) {
                // thêm 1 space giữa các word
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) { // nếu không phải từ cuối thêm space
                        sb.append(" ");
                    }
                }

                // thêm space còn lại vào cuối
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // 3️⃣ Dòng bình thường
                int totalChar = 0;
                for (int k = i; k < j; k++) {
                    totalChar += words[k].length();
                }

                int totalSpaces = maxWidth - totalChar; // tổng số space
                int gaps = numberOfWord - 1; // số khoang trống giưa các word

                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) { // chưa phai lừ từ cuối
                        int spaces = spacePerGap;

                        // nếu có extraSpace thì phân bổ bên trái nhiều hơn
                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < spaces; s++) {
                            sb.append(" ");
                        }
                    }
                }

            }

            res.add(sb.toString());
            i = j; // chuyển sang dòng tiếp theo
        }

        return res;
    }
}
