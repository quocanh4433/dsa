
public class SumOfTwoIntegers {

    /*
        🧩 Bản chất bài toán
        Khi cộng 2 số nhị phân, ta luôn có 2 phần:
        - Tổng không nhớ
        - Phần nhớ (carry)

        Time:   O(1)
        Space:  O(1)
    
     */

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // Lấy phần nhớ
            a = a ^ b; // cộng không nhớ
            b = carry; //  phần nhớ cho lần cộng tiếp
        }

        return a;
    }

    public static void main(String[] args) {

    }
}
