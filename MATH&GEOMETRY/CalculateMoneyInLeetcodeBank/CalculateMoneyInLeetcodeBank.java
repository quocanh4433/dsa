
public class CalculateMoneyInLeetcodeBank {
    public static int totalMoney(int n) {
        if(n == 1) return 1;
        int res = 0;
        int week = 0;
        int DAY_OF_WEEK = 7;

        for(int i = 1; i <= n; i++) {
            int day = i % DAY_OF_WEEK;

            if(day == 0) {
                // day == 0 là ngày chủ nhật value = 7
                day = 7;
                res += day + week;
                // tăng số tiền tiết kiệm cho tuần sau
                week++;
                continue;
            }

            res += day + week;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(totalMoney(10));
        
    }
}
