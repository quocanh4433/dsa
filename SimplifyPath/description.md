# Simplify Path
You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.


### The rules of a Unix-style file system are as follows:
<br>A single period '.' represents the current directory.
<br>A double period '..' represents the previous/parent directory.
<br>Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
<br>Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.

### The simplified canonical path should follow these rules:
<br>The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
<br>The path must not end with a slash '/', unless it is the root directory.
<br>The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
<br>Return the simplified canonical path.


### Example 1:
Input: path = "/neetcode/practice//...///../courses"
<br>Output: "/neetcode/practice/courses"


### Example 2:
Input: path = "/..//"
<br>Output: "/"


### Example 3:
Input: path = "/..//_home/a/b/..///"
<br>Output: "/_home/a"


### Constraints:
1 <= path.length <= 3000
<br>path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
