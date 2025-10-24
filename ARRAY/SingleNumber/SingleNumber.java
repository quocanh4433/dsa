import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    /*
     * SOLUTION 1: HASHTABLE
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * 
     */
    public static  int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            seen.put(nums[i], seen.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : seen.keySet()) {
            if(seen.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    /*
     * SOLUTION 2: HASHSET
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * Do phần tử lặp lại chỉ xuất hiện đúng 2 lần theo đề bài nên kết thúc vòng lặp chỉ còn đúng 1 phàn từ
     */

    public static int singleNumber_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> seen = new HashSet<>(); // [1]

        for(int num : nums) {
            if(seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }

        if(seen.isEmpty()) {
            return -1;
        }

        return seen.iterator().next();
    }


    /*
     * SOLUTION 3: XOR 
     * 
     * TỐI ƯU NHẤT
     */

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(singleNumber(nums)); // 1
        System.out.println(singleNumber_2(nums)); // 1
    }
}
