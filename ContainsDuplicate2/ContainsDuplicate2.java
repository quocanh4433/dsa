
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    /* 
     SOLUTION 1: tự nghĩ ra

     Ưu điểm: dễ tư duy theo cá nhân
     Nhược điểm: 2 điều kiện if lòng nhau


     public static boolean containsNearbyDuplicate(int[] nums, int k) {
         if (nums == null || nums.length == 0 || k <= 0) {
             return false;
         }
 
         Map<Integer, Integer> seen = new HashMap();
         boolean flag = false;
 
         for (int i = 0; i < nums.length; i++) {
             if (seen.containsKey(nums[i])) {
                 if (i - seen.get(nums[i]) <= k) {
                    flag = true;
                 }
             }
 
             seen.put(nums[i], i);
         }
 
         return flag;
     }
     
     */
    /**
     * SOLUTION 2: Code gọn hơn
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        Map<Integer, Integer> seen = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i]) && i - seen.get(nums[i]) <= k) {
                return true;
            }
            seen.put(nums[i], i);
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }
}
