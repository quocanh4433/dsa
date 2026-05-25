
class JumpGame {

    /*
        time O(n)
        space O(1)


         Tư duy lazy-greedy?
    
        Khi ở i=0 có thể nhảy đến 3, thay vi tham làm nhảy đến 3.
        Chậm lại, biết đâu i=1, i=2 tốt hơn
    
        Mình cần tham lam thông minh hơn:
            - thay vì nhảy đến 3, chỉ ghi nhận current_end là phạm vị kết thúc, đồng thời ghi nhận max_reach
            
            - tiếp tục di chuyển qua từng ô và cập nhật điểm xa nhất max_reach
    
            - khi chạm đến current_end,
         
    
        Chỉ cần duyệt từ 0 đến n-2, vì bản chất bài toán đi "đến đích" không phải "nhảy từ đích" 
     */
    public int jump(int[] nums) {
        int jumps = 0; // sô bước nhảy
        int end = 0; // vùng hiện tại
        int farthest = 0;// điểm xa nhất
        for (int i = 0; i < nums.length - 1; i++) { // Tại sao i < nums.length - 1;
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}
