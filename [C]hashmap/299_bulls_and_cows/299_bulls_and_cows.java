
class BullsAndCows {

    /*
        clarify problem
        Ý nghĩa của A (Bulls) và B (Cows)
            xA (Bulls - Bò tót): Số lượng chữ số xuất hiện đúng giá trị và đúng vị trí.

            yB (Cows - Bò): Số lượng chữ số xuất hiện đúng giá trị nhưng sai vị trí.

            lưu ý với cows:  chữ số đoán phải xuất hiện trong secret và sai vị trí

        vd: secret "11" và guess "12" -> '1A0B' do số '2' trong guess không xuất hiện trong secret

        vd: secret "12" và guess "21" -> '0A2B' do số '2' và '1' trong guess đều xuất hiện trong secret chỉ sai vị trí




        time O(n)
        space O(1)
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        // tại sao chỉ có 10?
        // do mỗi char bản chất là một số từ 0 đến 9

        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretMap[s - '0']++;
                guessMap[g - '0']++;
                // tại sao trừ cho char '0'?
                // vi char g và s thúc chất là char của số '2', '4',...
            }
        }

        // đếm số lượng cow
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretMap[i], guessMap[i]);
            // tại sao đếm cow với Math.min?

            // vd: secret = "111" và guess = "010"
            // secretMap    = [0, 2, ..., 0] 
            // guessMap     = [2, 0, ..., 0]
            // xét i = 0
            // secretMap[0] = 0 tức số 0 không xuất hiện trong secret
            // guessMap[0] = 2  tức người chơi dự đoán có 2 số 2
            // cow = 0 do sô 2 không xuất hiện trong secret
            // secret = "2113" và guess = "0122"
            // secretMap    = [0, 1, 1, 1..., 0] 
            // guessMap     = [1, 0, 2, 0 ..., 0]
            // ***xét i = 0
            // secretMap[0] = 0 tức số 0 không xuất hiện trong secret
            // guessMap[0] = 1  tức người chơi dự đoán có 2 số 2
            // cow = min(0, 1) = 0 do sô 2 không xuất hiện trong secret
            // ***xét i = 2
            // secretMap[2] = 1 tức số 2 xuất hiện trong secret 1 lần
            // guessMap[2] = 2  tức người chơi dự đoán có 2 số 2
            // cow = min(1, 2) = 1 do sô 2 chi xuất hiện tron secret 1 lân
            // bản chất cho dù guess nhiều hơn secret hay ngược lại
            // thì luôn chọn bên ít hơn
        }

        return bulls + "A" + cows + "B";
    }
}
