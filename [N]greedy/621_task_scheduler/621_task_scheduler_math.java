
class TaskScheduler_Math {

    /*  


        ưu điểm
            ▪︎ ngắn gọn
            ▪︎ nhanh hơn

        nhược điểm
            ▪︎ khó đút kết thành công thức
            ▪︎ khó mở rộng
    
     */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int t : tasks) {
            freq[t - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            if (f > 0) {
                maxFreq = Math.max(maxFreq, f);
            }
        }

        int maxCount = 0; // có bao nhiêu task đạt được maxFreq
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // độ dài toàn bộ chuỗi tính luôn A
        // [A _ _] [A _ _] [A _ _] A
        // theo ví dụ trên totalSlot = (4 - 1) * (2 + 1) = 9 thiếu A cuối cùng
        int totalSlot = (maxFreq - 1) * (n + 1);

        // công thêm những phần từ cuối
        int res = totalSlot + maxCount;

        // tại sao cần kiểm tra max
        return Math.max(tasks.length, res);
    }

}
