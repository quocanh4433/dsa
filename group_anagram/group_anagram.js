/**
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

/*
strs = ["aabb","bbaa"]
aabb = [2,2 ...0](26) => '22000...0'
bbaa = [2,2 ...0](26) => '22000...0'

hasmap  result {key: string, value:  [aabb, bbaa]}
return res
*/

var groupAnagrams = function(strs) {
    if(!strs) return []
    const res = {}

    for(let s of strs) {
        const count = new Array(26).fill(0)

        // Count frequent of each letter in the string
        for(let c of s) {
            count[c.charCodeAt(0) - 'a'.charCodeAt(0)]++
        }
        let key = count.join('#') // Use a string as a key

        if(!res[key]) {
            res[key] = [] 
        }
        res[key].push(s)
    }
    return Object.values(res)
};

console.log(groupAnagrams(["bdddddddddd","bbbbbbbbbbc"])) // [["bbbbbbbbbbc"],["bdddddddddd"]]
console.log(groupAnagrams(["eat","tea","tan","ate","nat","bat"])) // [["bbbbbbbbbbc"],["bdddddddddd"]]