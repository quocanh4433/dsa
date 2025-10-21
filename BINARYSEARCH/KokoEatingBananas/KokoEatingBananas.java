
public class KokoEatingBananas {

    /*
     * 
     * 
     * 👉 Tại sao  while (minRate < maxRate) mà không phải  while (minRate <= maxRate)?
     * 👉 Tại sao  hour += (pile + rate - 1) / rate; tương đương với hour += Math.ceil(pile / rate);?
     * 👉 Tại sao  maxRate = midRate; mà không phải maxRate = midRate - 1;?
     * 
     * 
     */
    public static int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }

        int minRate = 1;
        int maxRate = getMaxPile(piles);

        while (minRate < maxRate) {
            int midRate = minRate + (maxRate - minRate) / 2;

            // Tổng thời gian để ăn hết piles với tốc độ midRate
            int hours = getHour(piles, midRate);

            if (hours > h) {
                // Ăn qua chậm cần tăng thời gian lên
                minRate = midRate + 1;
            } else {
                maxRate = midRate;
            }
        }

        return minRate;

    }

    public static int getHour(int[] piles, int rate) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + rate - 1) / rate;
            // hour += Math.ceil(pile / rate); (vì ceil trả về double).
        }
        return hour;
    }

    public static int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int[] piles_2 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 8)); // 4
        System.out.println(minEatingSpeed(piles_2, 6)); // 23
    }
}
