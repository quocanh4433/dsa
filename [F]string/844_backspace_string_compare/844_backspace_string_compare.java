import java.util.Objects;

class BackspaceStringCompare {
    /*
        time O(n + m)
        space O(1)
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            Character iChar = null;
            Character jChar = null;

            while (i >= 0) {
                char charS = s.charAt(i);
                if (charS == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    iChar = s.charAt(i);
                    i--;
                    break;
                }
            }

            while (j >= 0) {
                char charT = t.charAt(j);
                if (charT == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    jChar = t.charAt(j);
                    j--;
                    break;
                }
            }

            if (!Objects.equals(iChar, jChar)) {
                return false;
            }
        }

        return true;
    }
}
