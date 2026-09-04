package ARRAY.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    /*
        Time compleixity: O(n)
        Space complexity: O(1)
    */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } 
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
