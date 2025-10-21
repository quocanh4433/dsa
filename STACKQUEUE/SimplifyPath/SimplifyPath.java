
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    /* CODE TỰ VIẾT
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     */
    public static String simplifyPath(String path) {
        if (path.isEmpty()) {
            return "";
        }

        Stack<String> pathStack = new Stack<>();
        StringBuilder word = new StringBuilder();

        // Duyệt qua tưng char trong String path
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '_' || c == '.') {
                word.append(c);

                // Phần từ cuối cùng là 1 ký tự thì push word vào stack - test case 5
                if (i == path.length() - 1) {
                    pathStack.push(word.toString());
                }

                continue;
            }

            // Đến đây char c chắn chắn == "/"
            // push word trước char c vào stack. Reset lại word
            pathStack.push(word.toString());
            word.setLength(0);
        }

        // lưu số lần xuất hiện ".."
        int back = 0;
        StringBuilder result = new StringBuilder();

        while (!pathStack.isEmpty()) {
            String s = pathStack.peek();

            if (s.isEmpty() || s.equals(".")) {
                pathStack.pop();
            } else if (s.equals("..")) {
                pathStack.pop();
                back += 1;
            } else {

                if (back >= 1) {
                    back--;
                    pathStack.pop();
                } else {
                    result.insert(0, s);
                    result.insert(0, "/");
                    pathStack.pop();
                }

            }

        }

        return result.isEmpty() ? "/" : result.toString();
    }

    /**
     *
     * THIS CODE IS OPTIMIZED
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     */
    public static String simplifyPath_2(String path) {
        if (path.isEmpty()) {
            return "";
        }

        Stack<String> pathStack = new Stack<>();
        StringBuilder word = new StringBuilder();
        String standardizedPath = path + "/";

        // Duyệt từng ký tự trong String path
        for (char ch : standardizedPath.toCharArray()) {
            if (ch == '/') {
                if (!word.isEmpty()) { // Tránh push chuỗi rỗng vào stack
                    pathStack.push(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(ch);
            }
        }

        // Duyệt xuôi dùng ArrayList
        List<String> validString = new ArrayList<>();
        for (String s : pathStack) {
            switch (s) {
                case "." -> {
                    // Do nothing for "."
                }
                case ".." -> {
                    if (!validString.isEmpty()) {
                        validString.remove(validString.size() - 1);
                    }
                }
                default -> {
                    validString.add(s);
                }
            }
        }

        // Nếu không có String thỏe điều kiện
        if (validString.isEmpty()) {
            return "/";
        }

        return "/" + String.join("/", validString);

    }

    public static void main(String[] args) {
        // Test case 1 (ví dụ đã cho)
        String path1 = "/..//_home/a/b/..///";
        System.out.println("Expected: /_home/a");
        System.out.println("Output_1: " + simplifyPath(path1));
        System.out.println("Output_2: " + simplifyPath_2(path1));
        System.out.println();

        // Test case 2
        String path2 = "/a/./b/../../c/";
        System.out.println("Expected: /c");
        System.out.println("Output_1: " + simplifyPath(path2));
        System.out.println("Output_2: " + simplifyPath_2(path2));
        System.out.println();

        // Test case 3
        String path3 = "/home//foo/";
        System.out.println("Expected: /home/foo");
        System.out.println("Output_1: " + simplifyPath(path3));
        System.out.println("Output_2: " + simplifyPath_2(path3));
        System.out.println();

        // Test case 4
        String path4 = "/../";
        System.out.println("Expected: /");
        System.out.println("Output_1: " + simplifyPath(path4));
        System.out.println("Output_2: " + simplifyPath_2(path4));
        System.out.println();

        // Test case 5
        String path5 = "/home/user/Documents/../Pictures";
        System.out.println("Expected: /home/user/Pictures");
        System.out.println("Output_1: " + simplifyPath(path5));
        System.out.println("Output_2: " + simplifyPath_2(path5));
        System.out.println();

        // Test case 6
        String path6 = "/home/foo/.ssh/../.ssh2/authorized_keys/";
        System.out.println("Expected: /home/foo/.ssh/../.ssh2/authorized_keys/");
        System.out.println("Output_1: " + simplifyPath(path6));
        System.out.println("Output_2: " + simplifyPath_2(path6));
        System.out.println();

        // Test case 7
        String path7 = "/.../a/../b/c/../d/./";
        System.out.println("Expected: /.../b/d");
        System.out.println("Output_1: " + simplifyPath(path7));
        System.out.println("Output_2: " + simplifyPath_2(path7));
        System.out.println();
    }
}
