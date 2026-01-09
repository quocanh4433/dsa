public class GoalParserInterpretation {
    /*
        Time: O(n)
        Space: O(n)
    */


    public static String interpret(String command) {
        if (command == null || command.length() == 0) {
            return "";
        }
        if (command.length() == 1) {
            return command;
        }

        int i = 0;
        int n = command.length();
        StringBuilder res = new StringBuilder();

        while (i < n) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                    i += 2;
                    continue;
                }

                if (command.charAt(i + 1) == 'a') {
                    res.append("al");
                    i += 4;
                }
            } else {
                res.append("G");
                i++;
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
}
