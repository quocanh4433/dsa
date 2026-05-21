import java.util.Arrays;

class LargestNumber {

    public String largestNumber(int[] nums) {
        /*
            time O(nlogn * k)
                - convert num to string: O(n)
                - sort: O(nlogn * k)
                    - sort O(nlogn)
                    - mỗi compare phải duyệt k (k: là độ dài 2 chuỗi cộng lại)
                    - vd: a = "9999" b = "9998" -> k = 8

            space O(n * k)
                - duyệt tưng num: O(n)
                    - chuyển từng num sang string O(k) 
                    - k : number of digit
         */

        int n = nums.length;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        /*
            giải thích hàm so sánh

            x.compareTo(y)
                < 0 → x nhỏ hơn y
                > 0 → x lớn hơn y
                = 0 → bằng nhau


            a = "3"
            b = "30"

            (b + a) = "303"
            (a + b) = "330"

            "303".compareTo("330")  return < 0  

            khi đó hàm sort hiểu a đứng trước b

         */

        // handle all zero
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(s);
        }

        return res.toString();
    }

}
