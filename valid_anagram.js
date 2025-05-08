/**
 * 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

 

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
*/ 


/**
 * Cách 1: 
 * 
 * Do yêu cầu chỉ có chữ cái in thường nên chỉ cần 26 phần từ
 * 
 * Sử dụng Array counter với 26 phần tử, tương ứng với 26 cữ cái [0, 0, 0 ....., 0]
 * 
 * Vòng lặp 1: duyệt qua string 1, mỗi lần duyệt TĂNG giá trị ở index tương ứng trong Array
 * 
 * Vòng lặp 2: duyệt qua string 2, mỗi lần duyệt GIẢM giá trị ở index tương ứng trong Array
 * 
 * Vòng lặp 3: duyệt qua array counter nếu có bất ky phần từ nào khác 0 => invalid anagram => ngược lại valid anagram
 */

var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    if(!s || !t) return false;

    const chars = Array(26).fill(0)

    for(let c of s) {
        const idx = c.charCodeAt(0) - 'a'.charCodeAt(0)
        chars[idx] += 1
    }

    for(let c of t) {
        const idx = c.charCodeAt(0) - 'a'.charCodeAt(0)
        chars[idx] -= 1
    }

    for (let c of chars) {
        if(c !== 0) return false
    }

    return true
};


/**
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * 
 * Do yêu cầu input là unicode 
 * 
 * Nên không biết chính xác số phần từ có trong mảng nên bài sử dụng hashmap(key:char - value:freq)
 * 
 * Vòng lặp 1: duyệt qua string 1, lưu số lần lặp và hashmap
 * 
 * Vòng lặp 2: duyệt qua string 1, giảm lần lặp và hashmap
 * 
 * Vòng lặp 3: duyệt qua hashmap nếu tất cả phần từ có value là 0 => valide anagram => ngược lại invalid
 * 
 */

var isAnagram = function(s, t) {
    if(s.length != t.length) return false
    if(!s || !t) return false;

    const count = {}

    for(let c of s) count[c] = (count[c] || 0) + 1
    for(let c of t) count[c] -= 1
    for (let c of Object.values(count)) {
        if(c !== 0) return false
    }
    return true
}

console.log(isAnagram('プロ', 'ロェ'))