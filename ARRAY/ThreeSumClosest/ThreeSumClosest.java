import java.util.Arrays;

public class ThreeSumClosest {
     public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        /*
            Cần 1 giá trị là tổng 3 số bất kì để so sánh
            👉 Tổng 3 sô đầu trong mảng
            👉 Hoặc tông 3 số cuối
            Không ảnh hương dến thuật toán
        */
        int best = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n - 2; i++) {
            /*
                Tại sao là n - 2?
                👉 ngoai nums[i] còn 2 vị trí có left và right
             */
            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                /*
                    Tại sao l < r mà không phải l <= r ?
                    👉 vì left và right phải tách biệt để sum là tông của 3 số riêng biệt;
                 */

                int sum = nums[i] + nums[l] + nums[r];

                if(Math.abs(best - target) > Math.abs(sum - target)) {
                    best = sum;
                }

                if(sum < target) {
                    l++;
                } else if(sum > target) {
                    r--;
                } else {
                    return target;
                    /*
                        Tại sao return target khi sum = target?
                        👉 Vì không thể có tổng nào gần target hơn chính target
                    */
                }

            }
        }

        return best;
    }
    public static void main(String[] args) {
        
    }
}
