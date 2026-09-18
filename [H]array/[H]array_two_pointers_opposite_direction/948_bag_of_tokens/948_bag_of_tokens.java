import java.util.Arrays;

class BagOfTokens {

    /*
        time O(nlogn)
        space O(1)
    
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int n = tokens.length;
        int score = 0;
        int maxScore = 0;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            // Face Up: dùng power để tăng score
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;

                maxScore = Math.max(maxScore, score);

                // Face Down: dùng score để lấy thêm power
            } else if (score > 0 && left < right) {
                // tai sao kiểm tra score > 0 và left < right ?
                // score > 0 thi mới score có thể đổi power
                // left < right để còn 2 token khác nhau 
                power += tokens[right];
                score--;
                right--;

                // Không thể làm gì nữa
                // không có score để đổi cũng không đủ power để faceup 
            } else {
                break;
            }
        }

        return maxScore;
    }
}
