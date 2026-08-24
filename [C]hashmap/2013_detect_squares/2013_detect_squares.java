import java.util.ArrayList;
import java.util.List;

class DetectSquares {

    /*
        add()
        -> time O(1)
        -> space O(1)

        count()
        -> time O(N)
        -> space O(1)
    
     */

    private int[][] counts; // mảng 2D
    private List<int[]> list; // danh sách các điểm được thêm vào 

    public DetectSquares() {
        counts = new int[1001][1001];
        list = new ArrayList<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        counts[x][y]++;
        list.add(point);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int totalSquares = 0;

        // tìm các điểm trong list thảo điều kiện hình vuông
        for (int[] p : list) {
            // tìm đương chéo với px và py
            int x = p[0];
            int y = p[1];

            // -------------------------------------------------------------
            // BƯỚC 1: Tìm ứng viên điểm chéo P3(x, y)
            // -------------------------------------------------------------
            // 1.1 Kiểm tra cạnh có lớn hơn 0 không (P3 không trùng P về x hoặc y)
            if (x == px || y == py) {
                continue; // Không tạo thành đường chéo hợp lệ -> Bỏ qua
            }

            // 1.2 Kiểm tra xem P3 với P có tạo thành ĐƯỜNG CHÉO HÌNH VUÔNG không
            int width = Math.abs(x - px);  // Chiều rộng
            int height = Math.abs(y - py); // Chiều cao

            if (width != height) {
                continue; // Chiều rộng != chiều cao (chỉ là hình chữ nhật) -> Bỏ qua
            }

            // -------------------------------------------------------------
            // BƯỚC 2: Kiểm tra sự tồn tại của P1(px, y) và P2(x, py)
            // -------------------------------------------------------------
            int countP1 = counts[px][y]; // Số lượng điểm P1 tại (px, y)
            int countP2 = counts[x][py]; // Số lượng điểm P2 tại (x, py)

            // Nếu thiếu P1 hoặc thiếu P2 thì không tạo thành hình vuông được
            if (countP1 == 0 || countP2 == 0) {
                continue; // Thiếu đỉnh góc -> Bỏ qua
            }

            // -------------------------------------------------------------
            // BƯỚC 3: Đã đủ 4 đỉnh -> Tính số lượng hình vuông tạo thành
            // -------------------------------------------------------------
            totalSquares += countP1 * countP2;
            // tại sao ở đây là phép nhân không phải phép công?????????
        }

        return totalSquares;
    }
}
