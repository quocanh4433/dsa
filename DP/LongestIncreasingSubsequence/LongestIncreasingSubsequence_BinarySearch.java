
public class LongestIncreasingSubsequence_BinarySearch {

    /*
        tim O(nlogn)
        space: O(n)

        prop
            - tăng hiệu năng
        cons    
            - chỉ có độ dài - không biết được phần tử trong subsequeces 


        🧪 ý tưởng

        dùng mảng tail để lưu num nhỏ nhất trong LIS

        tail[i] = value
            i: cho biết độ dài i + 1
            value: giá trị nhỏ nhất trong trong LIS 
        🔥 tail[i] có thể bị thay thế hoặc ghi đè

        ⚠️ example: nums = [3, 7, 5, 9]

        nums[0] = 3 
            tail = [3]
        nums[1] = 7
            tail = [3, 7]
        nums[2] = 5 < 7 → Tìm vị trí đầu tiên ≥ 5 → vị trí 1 (7)
            tail = [3, 5]
        nums[2] = 9
            tail = [3, 5, 9]

        → res = 3

     */
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int size = 1;

        for (int num : nums) {
            int l = 0, r = size;

            // ở mỗi num luôn luôn tìm phần tử đầu tiên trong tail lớn hơn num
            while (l < r) {

                int mid = l + (r - l) / 2;

                if (tail[mid] >= num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            tail[l] = num; // or tail[r] = num đều đúng

            // vừa tạo được subsequence dài hơn nên tăng size
            if (l == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_BinarySearch LIS = new LongestIncreasingSubsequence_BinarySearch();
        int[] nums = {1, 2, 4, 3};
        LIS.lengthOfLIS(nums);
    }
}
