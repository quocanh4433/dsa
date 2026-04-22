import java.util.HashMap;
import java.util.Map;

class SplitArrayIntoConsecutiveSubsequences {

    /*
        phân tích yêu cầu:
            - cho mảng đã sắp xếp tăng dần
            - chia mảng thì các phần thỏa điều kiện
                1. phần tử chỉ hơn nhau 1 đơn vị
                    vd: [1 2 3] or [7 8 9]  còn [1 4 5] loại
                2. chuỗi không liên tiếp phải có từ 3 phần tử trở lên
                3. [quan trọng]: phải sử dụng toàn bộ phần tử trong mảng
                    vd: mảng ban đầu [1 2 3 4 4 5]
                    [1* 2* 3* 4* 4 5] -> 1 2 3 4 
                    [1 2 3 4 4* 5*] -> 4 5 không đủ 3  

        ý tưởng:
            - hashmap freqMap lưu freq của từng phần tử trong
            - hashmap wantMap lưu các 

        ưu tiên nối vào dãi đang có trước
        nếu không có mới tạo mới

        mỗi lần tạo day gồm 3 phần từ trước
        phần tử thứ 4 làm phần tử chờ



        
        time O(n)
        space O(n)
     */

    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> wantMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freqMap.get(num) <= 0) {
                continue;
            }

            // 1. nối với dãy cũ
            if (wantMap.getOrDefault(num, 0) > 0) {
                wantMap.put(num, wantMap.get(num) - 1);
                wantMap.put(num + 1, wantMap.getOrDefault(num + 1, 0) + 1);
            } 
            
            // 2. tạo dãy mới 
            else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                wantMap.put(num + 3, wantMap.getOrDefault(num + 3, 0) + 1);
            } 
            
            // 3. fail
            // [1 2 3 5* 8 9 10] tại 5 không thể nối với dãy trước cung không thể tạo dãy mới 
            else {
                return false;
            }

            freqMap.put(num, freqMap.get(num) - 1);
        }

        return true;

    }
}
