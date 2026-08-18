
class FindSmallestLetterGreaterThanTarget {
    /*
        time O(logn)
        space O(1)
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m; // do m có thể là đáp án
            }
        }

        // return letters[l];
        // nhưng có trường hợp letters = [c, f, j] target = j
        // khi kết thúc l = 2 r = 2 nhưng kết qua là c nê return về letters[l] là sai
        
        
        
        // tại s chi lấy dư là đê tạo hiệu ứng uquay vong khi cuối mảng
        return letters[l % letters.length];
    }
}
