import java.util.Arrays;

class AssignCookies {

    /*
        ý tưởng

        sort mảng greedy để khi duyệt sẽ bắt đầu từ đứa ít tham lam nhất?

        
        time O(nlog(n) + mlog(m))
        space O(1)
        n: len(greedy)
        m: len(cookie)
     */

    public int findContentChildren(int[] greedy, int[] cookie) {
        Arrays.sort(greedy);
        Arrays.sort(cookie);

        int i = 0, j = 0;

        while (i < greedy.length && j < cookie.length) {
            // nếu yêu cầu phù hợp với chiếc cookie hiện tại thi chuyển sang yêu cầu khác 
            if (greedy[i] <= cookie[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
