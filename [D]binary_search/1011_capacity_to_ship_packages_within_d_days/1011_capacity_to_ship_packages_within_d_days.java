
class CapacityToShipPackagesWithinDDays {

    /*
        tìm capacity là X thì tau có thể chở hết hàng trong days ngày không

        mà X chắc chắn nhỏ hơn hoặc bằng tổng khối lương hàng hóa sum(weight)

        và X chắc chắn lớn hơn hoặc bằng khối lượng của thùng hàng lớn nhất

        theo example 1: 

        tìm sức chưa X của tàu để chở hết hàng trong 5 ngày

        10 <= X <= 55 


        binary search: O(log(sum - max))
        for trong hàm canShip: O(n)
        -> time O(nlog(sum - max))
        -> space O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        // step 1: xác định left và right
        int left = 0;
        int right = 0;

        for (int w : weights) {
            right += w;
            left = Math.max(left, w);
        }

        // step 2: thử tất cả các kết qua trong left và right
        while (left < right) { // nếu left <= right sẽ xay ra vong lặp vô tân
            int mid = left + (right - left) / 2;

            if (canShip(mid, days, weights)) {
                right = mid; // mid có thể là đáp án nhưng cần tìm mid nhở nhất nên thu hẹp right
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public boolean canShip(int capacity, int days, int[] weights) {
        int daysNeeded = 1;
        int currentWeight = 0;

        for (int w : weights) {
            if (currentWeight + w > capacity) {
                daysNeeded++;
                currentWeight = 0; // reset currentweight cho ngày hôm sau
            }
            currentWeight += w;
        }

        return daysNeeded <= days;
    }
}
