
public class BaseSeven {

    public String convertToBase7(int num) {
        // Bản chất là chuyển base 10 -> base 7
        // Time: O(log7num) - Space: O(log7num)

        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;
        num = Math.abs(num); // QUAN TRỌNG

        while (num > 0) {
            sb.append(num % 7);
            num /= 7; // Mỗi lần giảm đi 7
        }

        if (negative) {
            sb.append('-'); // "202-"
        }
        return sb.reverse().toString(); // sau khi reverse: "-202"
    }

    public static void main(String[] args) {

    }
}
