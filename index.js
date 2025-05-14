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
 * 
 * 
 * 
 * 
 */


var longestCommonPrefix = (strs) => {
    if(!strs) return ''
    if(strs.length == 1) return strs[0]

    let i = 0
    let pre = strs[0]

    for(let s of strs) {
        const length = Math.min(s.length, pre.length)
        while(i < length) {
            if(s[i] !== pre[i]) {
                pre = pre.slice(0, i)
            }
            i++
        }
        i = 0  
    }
    
    return pre;
}

// console.log(longestCommonPrefix(['nes', 'need']))
// console.log(longestCommonPrefix(["dance","dag","danger","damage"]))
// console.log(longestCommonPrefix(["bat","bag","bank","band"]))
console.log(longestCommonPrefix(["ab", "a"]))


// console.log(longestCommonPrefix(['nes']))
// console.log(longestCommonPrefix(['nes']))

// var longestCommonPrefix = function(strs) {
//     let prefix = strs[0]

//     for(let i = 1; i < strs.length; i++) {
//         while(strs[i].indexOf(prefix) !== 0) {
//             prefix = prefix.substring(0, prefix.length - 1)
//             if (prefix === '') return ''
//         }
//     }
//     return prefix
// };