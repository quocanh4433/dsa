import java.util.ArrayList;
import java.util.List;

class PartitionLabels {

    /*
        ✔️ phân tich yếu cầu: 
            - cho string s
            - chia s thành nhiều đoạn nhất sau cho
                - mỗi ký tự chỉ xuất hiên trong 1 đoạn duy nhất
                vd: s = 'abbcc' chia thành
                
                ['a', 'bb', 'cc'] VALID 

                ['abb', 'cc'] VALID

                ['ab, 'bcc'] INVALID 
                vì ký tự 'b' trong 'bcc' đã xuất hiện trong 'ab' trước đó

                ['abb, 'c', 'c'] INVALID tương tự với 'c' cuối cùng

            tra về kết quả [1, 2, 3] do chi được làm 3 đoạn (nhiều nhất)

        ✔️ insignt greedy:
            nếu đã chọn một đoạn thì đoạn đó phải kéo dài đến lần xuất hiện cuối cùng 
            của tất cả ký tự bên trong nó 

            👉 "Expand until valid, then cut immediately"

        ✔️ Quyết định local:

            👉 "cứ mở rộng đến max(lastIndex)"

        ✔️ Quyết định cắt sớm nhất có thể:

            👉 khi đủ điều kiện (i == end) thì cắt ngay


        time O(n)
        space O(1)
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // lưu vị trí cuối cùng của từng ký tự

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // cập nhât end xa nhất
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // khi đi đến điểm xa nhất thì ngắt
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
