public class JumpGame2 {
    /**
     * ⚠️ Lưu ý: Trong Jump Game 1, bạn chỉ cần biết "có đến được hay không".
     * Còn Jump Game 2 là tìm ít nhất bao nhiêu bước nhảy.
     * 
     * 🎯 Tư duy để hiểu đề
     * Bạn không phải tìm "nhảy tới đâu cho đúng", mà là:
     * 👉 Làm sao để luôn mở rộng phạm vi xa nhất có thể với số lần nhảy ít nhất
     */
    public int jump(int[] nums) {
        int jumps = 0; // sô bước nhảy

        int end = 0; 
        // end giới hạn vùng hiện tại có thể tới
        // Khi bạn vượt qua end, nghĩa là bạn đã đi hết vùng này → phải nhảy thêm 1 bước.


        int farthest = 0;// điểm xa nhất

        for (int i = 0; i < nums.length - 1; i++) { // Tại sao i < nums.length - 1;
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) { // Khi duyệt đến giới hạn vùng thi cập nhật giới hạn mới 
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
    public static void main(String[] args) {
        
    }
}
