
import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_BinarySearch {

    /*
        🎯 BẢN CHẤT
        - Tìm từ cặp spell(i) * potions(i) >= sucess
    
        🧠 Ý TƯỞNG
        - sort mảng potions
        -  duyệt mảng spell
            + tìm need = ceil(success / spell)
            + tìm index mà potions >= need
        - kết quả len(potion) - index;


        n = spells.length
        m = potions.length

        - sort potions: O(mlogm)
        - mỗi spell search portion: O(nlogm)

        Time: O((m + n)logm)
        Space: O(1)
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int s = spells[i];
            long need = (success + s - 1) / s;
            /*
                Tại sao không thể dùng Math.ceil(success / s)? 
                👉 với 2 số INT success = 7 , s = 3 -> Math.ceil(7/3) = 2
                Nhưng bài toán cần làm tròn LÊN 3

                Cách sửa - Cộng thêm (s - 1) để “ép nhảy lên” nếu có dư
                👉 int success = 7, s = 3 -> (7 + 3 - 1) / 3 = 3
             */

            int l = 0, r = n - 1;
            int idx = n;

            while (l <= r) {
                int m = l + (r - l) / 2;
                if (potions[m] >= need) {
                    idx = m;
                    // m có thể là đáp án hoặc chưa nên cần dịch sang trái để kieemrr tra tiếp
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            res[i] = n - idx;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
