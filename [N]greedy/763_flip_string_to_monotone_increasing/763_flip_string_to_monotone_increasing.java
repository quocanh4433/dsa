
class FlipStringToMonotoneIncreasing {

    /*
        phân tích đề
            - cho binary string s (vd: 00101)
            - trả về số lần lật ít nhất sau cho s trơ thành tăng dần đều
                vd: s = '00101'

                flip '0' 3 lần -> '11111'
                flip '1' 2 lần -> '00000'
                flip '0' 1 lần -> '00111' 🎯
    
            kết quả trẻ về là 1 số lần flip ít nhất


        tư duy thông thường:
            - duyệt từ trái sang phải
            - nếu gặp 1
                - flip 
                - hoặc không flip
            - nếu gặp 0 cũng tương tự

        nhược điểm của tư duy thông tường là gì?
            - không biết quyết định ở hiện tại có ảnh hưởng đến trước đó hoặc sau này
            - xem xét quá nhiều trường hợp


        tư duy greedy
            - chuyển tất cả về 0
            - vẫn duyệt từ trái sang phải
            - gặp 1 - xem như sai flip về 0 luôn -> chỉ giả định chưa flip
            - găp 0 
                - mà trước đó không có 1 -> đi tiếp
                - mà trước đó có 1
                    - vẫn tiếp tục giữ 0 
                        -> tức là flip tất cả số 0 trước đó
                        -> cost = ones
                    - flip 0 thành 1
                        -> cost = flip + 1

                    lấy chi phí thấp nhất min(ones, flip + 1);


        time O(n)
        space O(1)

     */
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int ones = 0; // sô lần 1 xuất hiện
        int flip = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '1') {
                ones++;
                continue;
            }

            if (ones != 0) {
                flip = Math.min(flip + 1, ones);
            }
        }

        return flip;
    }
}
