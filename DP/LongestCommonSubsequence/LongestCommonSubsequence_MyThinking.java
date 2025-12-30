package DP.LongestCommonSubsequence;

public class LongestCommonSubsequence_MyThinking {


    /*
    
        My thinking but Error
    
    */


    public int longestCommonSubsequence(String text1, String text2) {
        String shortText = text1.length() >= text2.length() ? text2 : text1;
        String longText = text1.length() >= text2.length() ? text1 : text2;
        int minLen = Math.min(text1.length(), text2.length());
        int count = 0;
        int k = 0;

        for (int i = 0; i < minLen; i++) {
            char c = shortText.charAt(i);
            while (k < longText.length()) {
                if (c == longText.charAt(k)) {
                    count++;
                    k = i + 1;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
