
class MaximizeDistanceToClosestPerson {

    /*
        edge case: only one person 
        [1, 0, 0, 0]
        [0, 0, 0, 1]
        [1, 0, 0, 1]
        [0, 0, 1, 0, 0, 1, 0, 0]


        nhận xét:
        - vân đề xảy ra khi số 0 ở cuối mảng nên cần thêm điều kiện cho riêng trương hợp này

        time O(n)
        space O(1)

     */
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1; // 1
        int res = 0; // 1

        for (int i = 0; i < seats.length; i++) {
            if (i == n - 1 && seats[i] == 0) {
                // At least one seat is occupied.
                res = Math.max(res, i - prev);
            }

            if (seats[i] == 1) {
                if (prev >= 0) { // trước đó có người ngồi
                    res = Math.max(res, (i - prev) / 2);
                } else { // trước đó chưa có người ngồi
                    res = Math.max(res, i);
                }

                prev = i;
            }
        }

        return res;
    }
}
