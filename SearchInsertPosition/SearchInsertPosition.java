
public class SearchInsertPosition {

    /*
     * 🧠 Ý tưởng: Phần tử lớn hơn target đều là kết quả
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        int res = nums.length;

        while (l <= r) {
            int m = (l + r) / 2; // Do 1 <= nums.length <= 10^4. Nên dùng công thức này

            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    /*
     * 🧠 Ý tưởng: Khi vòng lặp dừng thị l > r. l chính là kết quả
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     */
    public static int searchInsert_2(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5)); // 2
        System.out.println(searchInsert(nums, 2)); // 1 
        System.out.println(searchInsert(nums, 7)); // 4
        System.out.println("----------------");
        System.out.println(searchInsert_2(nums, 5)); // 2
        System.out.println(searchInsert_2(nums, 2)); // 1 
        System.out.println(searchInsert_2(nums, 7)); // 4
    }
}

/*
[1, 5, 6, 8] target = 4
    |

l=0, r=3, m = 1, nums[1] = 5 > 4 




 */
