import java.util.Arrays;

class FindTheKthLargestIntegerInTheArray {

    public String kthLargestNumber(String[] nums, int k) {
        /*
            sắp xếp độ dài string tăng dần
            - nhưng string có cùng độ dài thi so sánh thứ tự
            vd: "355" và "343" -> sau khi sắp xếp ["343", "355"]


            ***lưu ý
            - tại sao không chuyển string sang int/long -> sắp xêp -> trả về kết quả?
            do độ dài của String rất lớn có thể vượt qua int/long nên không nên chuyển sang dạng số


            time O(nlogn * L)
            space O(n)

            n = số phần tử trong nums
            L = độ dài tối đa của một String
         */

        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        return nums[nums.length - k];
    }
}
