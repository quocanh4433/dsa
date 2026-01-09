public class SplitAStringInBalancedStrings {
    /*
        Time: O(n)
        Space: O(1)
    
    */

    public int balancedStringSplit(String s) {
        int count = 0;
        int total = 0;

        for(char c : s.toCharArray()) {
            if(c == 'R'){
                total++;
            } else {
                total--;
            }
            if(total == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
