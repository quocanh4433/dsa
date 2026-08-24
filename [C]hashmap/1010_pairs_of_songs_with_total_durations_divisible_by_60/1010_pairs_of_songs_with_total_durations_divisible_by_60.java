
class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /*
        navie approach: using two for wwith i = 0 and j = i + 1
        time O(n**2)
        space O(1)

        how to reduce time complexity to O(n)?




        ta có:      a = time[i] và b = time[j]
        mà:         a + b % 60 == 0
        thì:        ( (a % 60) + (b % 60) ) % 60 cũng bằng 0
        
        tức nếu 2 số cộng lại mod60 bằng 0 thì phần dư của 2 số khi mod60 cộng lại rồi tiếp tục mod60 cũng bằng 0






        vd: a = 30 và b = 150
        remainA = 30 % 60 = 30
        remainB = 150 % 60 = 30
        (30 + 30) % 60 = 60 % 60 == 0



        
        (remainA + remainB) % 60 == 0
        Để tổng ở trên bằng 0 thì có 2 trường hợp




        TH1: remainA + remainB = 60
        tức         remainA > 0 và remainB > 0
        suy ra:     remainB = 60 - remainA


        TH2: remainA + remainB = 0
        tức         remainA = remainB = 0
        suy ra:     remainB = 0


        từ 2 trường hợp trên suy ra
        remianB = (60 - remainA) % 60




        


        ý tưởng là:
        - tạo biến lưu trữ phân dư khi mod 60 của từng số
        - duyệt qua từng số cur
            - tính phần dư của cur khi mod60 gọi remainA
            - tình phần dư còn lại remainB = (60 - reaminA) % 60






        time O(n)
        space O(1)


     */

    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60]; // tại sao lại là 60
        int res = 0;

        for (int t : time) {
            int remainA = t % 60;
            int remainB = (60 - remainA) % 60;

            // tìm bài hát trước đó có thời gian đúng với remainB
            res += count[remainB];

            // cập nhật số lần xuất hiện hiên tại
            count[remainA]++;
        }

        return res;
    }
}
