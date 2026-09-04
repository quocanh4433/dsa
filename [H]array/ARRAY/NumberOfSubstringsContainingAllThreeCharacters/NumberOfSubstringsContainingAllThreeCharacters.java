
public class NumberOfSubstringsContainingAllThreeCharacters {


    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(1)
     * 
     */
    public static int numberOfSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        int[] charCount = new int[3];
        int count = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) { // O(n)
            charCount[s.charAt(right) - 'a']++;

            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                /*
                Tại thời điểm right (i) cửa sổ đã có đủ 'a','b','c'
                Thì tất cả substring bắt đầu từ left và kết thúc từ right..n-1 đều hợp lệ
                
                for(int end = right; end < s.length(); end++) { count++ }
                 
                Viết ngắn gọn hơn
                 
                count += s.length() - right;
                 
                 */
                count += s.length() - right;
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str1 = "abcabc";
        String str2 = "aaacb";
        String str3 = "abc";

        System.out.println(numberOfSubstrings(str1)); // exception: 10
        System.out.println(numberOfSubstrings(str2)); // exception: 3
        System.out.println(numberOfSubstrings(str3)); // exception: 1
    }
}
