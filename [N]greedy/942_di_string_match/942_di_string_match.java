
class DIStringMatch {

    /*
        I: increasing
        D: decreasing
        mỗi kí tự trong s là ràng buộc lớn hơn hoặc nhỏ hơn kế bên


        ý tưởng greedy:

        ở mỗi chuôi s có chiều dài n thì low = 0 và high = n

        tham ở chỗ nếu gặp I thì cứ lấy low ra trước rồi tăng low, nếu gặp D thì lấy high tăng high

        dưng lại low == high
        
        time O(n)
        space O(n)

    
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1]; // 0 4 1 3
        int low = 0, high = n;
        int i = 0;

        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 'I':
                    perm[i] = low++;
                    break;
                case 'D':
                    perm[i] = high--;
            }

            i++;
        }

        perm[i] = low;
        return perm;
    }
}
