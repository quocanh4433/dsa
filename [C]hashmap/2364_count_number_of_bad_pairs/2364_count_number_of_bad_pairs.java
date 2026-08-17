import java.util.HashMap;
import java.util.Map;

class CountNumberOfBadPairs {
    /*
        bad pair: j - i != nums[j] - nums[i]

        good pair: j - nums[j] == i - nums[i] tương đương key = i - nums[i]

        thay vì tìm bad pair ta tìm good pair

        bad pair = tổng cặp mà i là phần tử thứ 2 - số good pair

        tương đương

        res += i - goodpair


        time O(n)
        space O(n)
              

     */
    public long countBadPairs(int[] nums) {
        // map để đếm số goodpairs của 1 key
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;

        for(int i = 0; i < nums.length; i++) {
            int key = i - nums[i];

            int goodPairs = map.getOrDefault(key, 0);

            res += i - goodPairs;

            map.put(key, goodPairs + 1);
        }

        return res;
    }
}