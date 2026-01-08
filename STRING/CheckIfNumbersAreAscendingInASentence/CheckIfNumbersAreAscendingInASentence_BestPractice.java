public class CheckIfNumbersAreAscendingInASentence_BestPractice {
    /*
        Time: O(n)
        Space: O(1)
    */
    public boolean areNumbersAscending(String s) {
        int prev = -1;
        int num = 0;
        boolean inNum = true;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                inNum = true;
            } else {
                if (inNum) {
                    if (num <= prev) {
                        return false;
                    }
                    prev = num;
                    num = 0;
                    inNum = false;
                }
            }
        }

        // Vòng lặp vừa kết thúc nhưng ta vẫn đang đọc dở một số
        // s = "helooo 11" -> số 10 cuối ucngf
        if (inNum && num <= prev) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
