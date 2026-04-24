
import java.util.HashMap;
import java.util.Map;

class MinimumNumberOfOperationsToMakeArrayEmpty {

    /*
        tư duy:
            - đếm freq num
            - để minimize xóa 3 nhiều nhất

            ⚡
            - thử với freq = 7 xóa 3 nhiều nhất -> 7 - 3 - 3 = 1 ❌
            - nhưng 7 - 3 - 2 - 2 = 0 ✅

            - thử với freq = 10 xóa 3 nhiều nhất -> 10 - 3 - 3 - 3 = 1 ❌
            - nhưng 10 - 3 - 3 - 2 - 2 = 0 ✅

            nhận thấy 7 và 10 % 3 == 1 luôn có 4 ở cuối

            - số lần swap của nhóm % 3 == 1 sẽ có 2 phần
                - sô 4 ở cuối -> count = 2 (chia 2 được 2 lần)
                - phần còn lại chỉ cần trừ đi 4 và chia cho 3

                👉 công thức count = 2 + (freq - 4) / 3;


            ⚡ 
            - thử với freq = 5 xóa 3 nhiều nhất -> 5 - 3 - 3 = -1 ❌
            - nhưng 5 - 3 - 2 = 0 ✅

            - thử với freq = 14 xóa 3 nhiều nhất -> 14 - 3 - 3 - 3 - 3 - 3 = -1 ❌
            - nhưng 14 - 3 - 3 - 3 - 3 - 2 = 0 ✅

            nhận thấy 5 và 14 % 3 == 2 luôn có 2 ở cuối

            - số lần swap của nhóm % 3 == 2 sẽ có 2 phần
                - sô 2 ở cuối -> count = 1 (chia 2 được 1 lần)
                - phần còn lại chỉ cần trừ đi 2 và chia cho 3

                👉 công thức count = 1 + (freq - 2) / 3 or count = 1 + freq/3
            
        
        time O(n)
        space O(n)

     */
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq == 1) {
                return -1;
            }

            // đề minimize ưu tiên chia 3 trước
            switch (freq % 3) {
                case 0 -> count += freq / 3;
                case 1 -> count += (freq - 4) / 3 + 2;
                default -> count += (freq - 2) / 3 + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayEmpty mn = new MinimumNumberOfOperationsToMakeArrayEmpty();
        // System.out.println(mn.minOperations(new int [] {2,3,3,2,2,4,2,3,4}));
        System.out.println(mn.minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));

    }
}
