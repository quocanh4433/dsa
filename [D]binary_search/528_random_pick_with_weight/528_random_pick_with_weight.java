import java.util.Random;

/*
    ứng dụng trong thực tế weighted load balancing.

    ví dụ có 3 server

    Server A: weight = 1
    Server B: weight = 3
    Server C: weight = 6

    muốn phân phối request

    A ≈ 10%
    B ≈ 30%
    C ≈ 60%
 */


/*
    Nhận diện pattern cho bài này

    w = [1, 3, 6]

    w[i]: value càng lớn thì độ ưu tiên càng lớn

    muốn biết độ ưu tiên thì cần biết xác suất
    nếu tổng của sum(w) = 1 + 3 + 6 = 10

    P(w) = [1/10, 3/10, 6/10] = [10%, 30%, 60%]

    


    **VẤN ĐỀ 1 và GẢI QUYẾT:

    chỉ dựa vào xác suất thì không biết phân bổ số được chọn random như thế nào

    lúc này sẽ tạo không gian random với 10 vùng

    index 0: [1]             → 1 số
    index 1: [2, 3, 4]       → 3 số
    index 2: [5,6,7,8,9,10]  → 6 số

    chọn random 1 số từ 1 đến 10 số thuộc vùng nào thi trả về index vùng đó

    random = 3 thuộc vùng 1 trả về 1
    random = 1 thuộc vùng 1 trả về 0




    **VẤN ĐỀ 2 và GIẢI QUYẾT

    với sum(w) = 10 có thể tạo không gian random 

    khi sum(w) lên đến hàng triệu hàng tỉ thi tạo không gain random không còn khả thi

    chú ý ở index 1: [2, 3, 4] số 4 cuối cùng được tạo ra từ w[0] + w[1] = 1 + 3 = 4 đây chính là prefix

    nếu vây chỉ cần một mảng lưu prefix cho biết điểm kết thúc của vùng đó

    prefix = [1, 4, 10]

    prefix[0] = 1   không gian random kết thúc ở 1      [1....1]
    prefix[1] = 4   không gian random kết thúc ở 4      [2....4]
    prefix[2] = 10  không gian random kết thúc ở 10     [1....1]
    

    mà trong prefix thì sắp xếp tăng dần 

    mà mảng được sắp xếp thì binary search

    bài toán trở thành tìm prefix >= số random (lower bound)

  */


/*
    constructor: O(n)
    pickIndex O(logn)
    → time: O(n)

    constructor: O(n)
    pickIndex O(1)
    → space: O(n)

 */

    class RandomPickWithWeight {

    int[] prefix;
    Random random;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        prefix = new int[w.length];

        prefix[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(prefix[prefix.length - 1]) + 1;

        int l = 0;
        int r = prefix.length - 1;

        while (l < r) { // do không tìm chính xác nên chỉ cần l < r thay vi l <= r
            int m = l + (r - l) / 2;

            if (prefix[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
