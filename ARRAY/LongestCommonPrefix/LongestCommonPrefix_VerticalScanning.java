public class LongestCommonPrefix_VerticalScanning {

    /*
        Time: O(n * m)
        Space: O(1)

        Giai thich
        https://www.youtube.com/watch?v=COtXh4aM1a8
    
    */

    public static String longestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++) { // 👉 So sánh ký tự thứ i của tất cả chuỗi khác
                /*
                    Có 2 trường hợp khiến prefix bị gãy

                    ❌ Trường hợp 1: Chuỗi ngắn hơn vị trí đang xét (CHƯA HIỂU CHÔ NÀY)
                    strs[j].length() == i
                    
                    ❌ Trường hợp 2: Ký tự khác nhau
                     strs[j].charAt(i) != c
                */


                if(strs[j].length() == i &&  strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestPrefix(strs));
    }
}
