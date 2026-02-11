public class MaximumRepeatingSubstring {
    /*
        time O(n**2)
        space O(n)
    */
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String curr = word;

        for(int i = 0; i < sequence.length(); i++) {
            if(sequence.contains(curr)) {
                count++;
                curr += word;
            }
        }

        return count;
    }
}
