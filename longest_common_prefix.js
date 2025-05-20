/*
You are given an array of strings strs. Return the longest common prefix of all the strings.
If there is no longest common prefix, return an empty string "".

Example 1:
Input: strs = ["bat","bag","bank","band"]
Output: "ba"

Example 2:
Input: strs = ["dance","dag","danger","damage"]
Output: "da"

Example 3:
Input: strs = ["neet","feet"]
Output: ""

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] is made up of lowercase English letters if it is non-empty.

*/

/**
 * idx = 0
 * pre = strings[0]
 * 
 * for s : strings
 * [idx] == null -> pre = s cotinue
 * s[idx] != pre[idx] pre = pre.slice(0, idx) continue
 * s[idx] == pre[idx] idx++
 * 
 * return pre
 */

/*
Time complexity O(n)
Space complexity O(n * m) 
n is the number of strings
m is the length of the shortest string

*/


var longestCommonPrefix = (strs) => {
    if(!strs) return ''
    if(strs.length == 1) return strs[0]

    let prefix = strs[0]

    for(let i = 1; i < strs.length; i++) {

        // Không sử dụng inclues(prefix)
        // while(!strs[i].includes(prefix)) { // Xác nhận chuỗi prefix có thuộc chuỗi strs[i] 

        while(strs[i].indexOf(prefix) != 0) { // Tìm vị trí đầu tiên mà chuỗi con xuất hiện trong chuỗi gốc.
            prefix = prefix.substring(0, prefix.length - 1)
            if (!prefix) return ''          
        }
    }    
    return prefix;
}

console.log(longestCommonPrefix(["c","acc","ccc"]))
console.log(longestCommonPrefix(['nes', 'need']))
console.log(longestCommonPrefix(["dance","dag","danger","damage"]))
console.log(longestCommonPrefix(["bat","bag","bank","band"]))
console.log(longestCommonPrefix(["ab", "a"]))


