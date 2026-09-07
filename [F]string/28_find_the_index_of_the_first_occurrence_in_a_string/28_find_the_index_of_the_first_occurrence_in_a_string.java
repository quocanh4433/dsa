

class FindTheIndexOfTheFirstOccurrenceInAString {
    /*
        time O(n * m)
        space O(1)

        easy solution
    */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(n < m) return -1;
        if(m == 0) return 0;

        for(int i = 0; i < n - m; i++) { // chỉ duyệt string đến n - m
            if( haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
