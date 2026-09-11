

class LongestMountainInArray {
     /*
        time O(n)
        space O(1)
     */
    public int longestMountain(int[] arr) {
        int state = 0; // 0: undefine - 1: uphill - 2: downhill
        int start = 0;
        int res = 0;
        
        // i giống người đi dò đường
        for(int i = 1; i < arr.length; i++) {
            switch (state) {
                case 0 -> {
                    // state = 0 đang đi ngang
                    // lúc này chỉ quan tâm khi nào lên dốc
                    if(arr[i - 1] < arr[i]) {
                        state = 1;
                        start = i - 1;
                    }
                }
                case 1 -> {
                    // state = 1 đang ở trạng thái lên dốc
                    // lúc này đi ngang hay đi xuống
                    if(arr[i - 1] == arr[i]) {
                        state = 0; // nếu đi ngang thì hủy ngọn núi hiện tại
                    } else if (arr[i - 1] > arr[i]) {
                        state = 2;
                        res = Math.max(res, i - start + 1); // tạo thành núi cập nhật độ dài mới
                    }
                }
                default -> {
                    // state == 2
                    // state = 2 tức đang ở trạng thái xuống dốc
                    // lúc này quan tâm đi ngang - đột ngột đi lên hay đi xuống tiếp
                    if(arr[i - 1] == arr[i]) {
                        state = 0; // nếu đi ngang thì hủy ngọn núi hiện tại
                    } else if(arr[i - 1] < arr[i]) {
                        state = 1;
                        start = i - 1; // ngọn núi cũ đã xong bắt đầu ngọn núi mới
                    } else {
                        res = Math.max(res, i - start + 1); // đi xuông tiếp thì cập nhật chiều dài mới
                    }
                }
            }
        }

        return res;
    }
}
