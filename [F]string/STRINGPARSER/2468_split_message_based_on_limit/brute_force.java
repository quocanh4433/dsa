
class Solution {

    /*
        time: O(n)
        space: O(n)
     */
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        String[] res = new String[0];

        /*
            tổng số chỉ phần
            
            vd: k = 10

            part 1 : 1 chữ sô -> summIndex = 1
            part 2 : 1 chữ sô -> summIndex = 2
            part 3 : 1 chữ sô -> summIndex = 3
            ...
            part 10 : 2 chữ sô -> summIndex = 11
         */
        int sumIndex = 0;

        // số phần cần tìm là k với 1 <= k <= n
        for (int k = 1; k <= n; k++) {
            // số chữ của k
            // vd: k = 1 lenK = 1, k = 10 lenK = 2
            int lenK = (k + "").length();

            sumIndex += lenK;

            /*  
                tổng chữ số trong toàn bộ k phần
                sumk = lenK * k

                vd: k = 12 -> lenK = 2
                chia làm 12 (k) phần môi phần 2 (lenK) chữ số
                -> có 24 (12 * 2) chữ số k trong toàn bộ 12 phần  
             */
            int sumK = lenK * k;
            /*
                tổng ký tự <, >, / trong k phần
             */
            int sumChar = 3 * k;

            /*
                tổng độ dài suffix
             */
            int sumSuffix = sumChar + sumK + sumIndex;


            /*
                chia làm k phần mỗi phần chứ tôi đa limit
                tổng sức chứa của k phần tính luôn cả content + suffix
             */
            int sumCapacity = limit * k;

            /*
                tổng sức chứa chỉ của content
             */
            int sumContent = sumCapacity - sumSuffix;


            /*
                nếu tông sức chứa của content lớn hơn tổng số kí tự trong message
                tức là k đúng
             */
            if (sumContent >= n) {
                res = new String[k];
                int idx = 0; // index trong messeage

                // build từng phần
                // j là số phần
                for (int j = 1; j <= k; j++) {
                    String suffix = String.format("<%d/%d>", j, k);

                    // build content
                    int end = Math.min(n, idx + limit - suffix.length());
                    String content = message.substring(idx, end);

                    res[j - 1] = content + suffix;
                    idx = end;
                }

                break;
            }
        }

        return res;
    }
}
