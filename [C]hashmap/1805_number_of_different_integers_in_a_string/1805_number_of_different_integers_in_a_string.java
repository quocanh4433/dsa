import java.util.HashSet;
import java.util.Set;

class NumberOfDifferentIntegersInAString {

    public int numDifferentIntegers(String word) {
        /*
            time O(n)
            space O(n) toàn bộ word là số 
        
         */
        Set<String> set = new HashSet<>();
        int i = 0;
        int n = word.length();

        while (i < n) {
            if (!Character.isDigit(word.charAt(i))) {
                i++;
                continue;
            }

            int start = i;

            while (i < n && Character.isDigit(word.charAt(i))) {
                i++;
            }

            while (start < i && word.charAt(start) == '0') {
                start++;
            }

            if (start == i) {
                set.add("0");
            } else {
                set.add(word.substring(start, i));
            }
        }

        return set.size();
    }
}
