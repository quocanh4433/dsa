
class JumpGame {

    /*
        tim O(n)
        space O(1)
        
        
        thay vì hỏi
            " đứng ở i đi được bao xa "

        thay đổi GREEDY
            " đứng ở i đi xa nhất là bao nhiêu "

        cho i tăng và cập nhật maxreach

        nếu i > maxreach tức là các ô trước đó đi xa nhất cũng không tới i=
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
