
import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        if (s == null) {
            return "";
        }

        Stack<String> wordStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder word = new StringBuilder();
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                word.append(c);
            } else if (Character.isDigit(c)) {
                number = Character.getNumericValue(c);
                // if (!w.isEmpty()) {
                //     words.push(w.toString());
                //     count.push(n);
                // }
                // w.setLength(0);
                // n = Character.getNumericValue(c);
            } else if (c == '[') {
                wordStack.push(word.toString());
                countStack.push(number);
                word.setLength(0);
                number = 0;
            } else {
                int count = countStack.pop();
                StringBuilder duplicateWord = new StringBuilder(wordStack.pop());
                for (int j = 0; j < count; j++) {
                    duplicateWord.append(word);
                }
                word = duplicateWord;
                // StringBuilder w2 = new StringBuilder();
                // for (int j = 0; j < n; j++) {
                //     w2.append(w);
                // }
                // if (!words.isEmpty() && !count.isEmpty()) {
                //     StringBuilder newWord = new StringBuilder();
                //     newWord.append(words.pop()).append(w2).append(decode);
                //     // decode.setLength(0);
                //     int m = count.pop();
                //     for (int k = 0; k < m; k++) {
                //         decode.append(newWord);
                //     }
                //     w.setLength(0);
                //     n = 1;
                // } else {
                //     decode.append(w2);
                // }
            }
        }

        return word.toString();
    }

    public static void main(String[] args) {
        String s = "2[a2[bc2[d]]]";
        // System.out.println(decodeString(s)); // expected: abcddbcddabcddbcdd
        String s2 = "xyz3[a]2[b]";
        // System.out.println(decodeString(s2)); // expected: xyzaaabb
        String s3 = "2[abc]3[cd]ef";
        // System.out.println(decodeString(s3)); // expected: abcabccdcdcdef
        String s4 = "3[a2[c]]";
        // System.out.println(decodeString(s4)); // expected: accaccacc 
        String s5 = "100[leetcode]";
        System.out.println(decodeString(s5)); // expected: accaccacc 

    }
}

/*
Stack  words:             
 
Stack  count:            


2[a2[bc2[d]]]        //   abcddbcddabcddbcdd
             
xyz3[a]2[b]          // xyzaaabb
         |           

w = "b"

n = 2

decode = xyzaaa

cur_char == "["  -> continue

cur_char.isNumberic()
    if w != ""
        words.push(w)
        count.push(n)

    w = ""
    n = cur_char

    continue;


cur_char == "]"
    if !stack.empty
        w1 = words.pop = xyz
        - for (i < n ) ->  w2 = aaa
        - for (i < count.pop) (w1 + w2 + decode = xyzaaa) -> decode = xyzaaa

        w = ""
        n = 1
    else 
        for (i < n ) ->  w2 = bb
        decode += w2  = xyzaaabb

return decode

 */
