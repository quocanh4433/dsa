
class LemonadeChange {

    /*
        ý tưởng greedy năm ở chỗ khi khác trả 15

        ưu tiên chọn 10 trước sau đó đến 5

        time O(n)
        space O(1)
    
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;

                case 10:
                    if (five == 0) {
                        return false;
                    }
                    five--;
                    ten++;
                    break;

                case 20:
                    int charge = 15;

                    while (ten > 0 && charge >= 10) {
                        ten--;
                        charge -= 10;
                    }

                    while (five > 0 && charge >= 5) {
                        five--;
                        charge -= 5;
                    }

                    if (charge > 0) {
                        return false;
                    }
            }
        }

        return true;
    }
}
