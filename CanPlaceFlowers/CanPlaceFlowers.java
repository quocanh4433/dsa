
public class CanPlaceFlowers {

    /**
     *
     * I BRAIN STORM BUT LIKE SHIIIIIIT
     *
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n < 0) {
            return false;
        }

        // Trường hợp đặc biệt: mảng chỉ có 1 phần tử
        int length = flowerbed.length;
        if (length == 1) {
            if (flowerbed[0] == 0) {
                n--;
            }
            return n <= 0;
        }

        int i = 0;

        while (i < length) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                } else if (i == length - 1 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                } else if (i > 0 && i < length - 1 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            i++;
        }

        if (n > 0) {
            return false;
        }

        return true;
    }


    /* SỬA LỖI TƯ DUY */
    public boolean canPlaceFlowers_2(int[] flowerbed, int n) {

    }

    public static void main(String[] args) {

    }
}
