/*
Concatenation of Array
You are given an integer array nums of length n. Create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.
Return the array ans.

Example 1:
Input: nums = [1,4,1,2]
Output: [1,4,1,2,1,4,1,2]

Example 2:
Input: nums = [22,21,20,1]
Output: [22,21,20,1,22,21,20,1]

Constraints:
1 <= nums.length <= 1000.
1 <= nums[i] <= 1000

*/


/**
 * 
 * Solution 1: two pass 
 * 
 * Time complexity: O(2n) -> O(n)
 * Space complexity: O(2n) -> O(n)
 * 
 */
var getConcatenation = (nums) => {
    if(!nums) return []
    let ans = []

    for(i = 0; i < 2; i++) {
        for(let num of nums) {
            ans.push(num)
        }
    }
    return ans

}

// console.log(getConcatenation([22,21,20,1]))


/**
 * 
 * Solution 2: one pass 
 * 
 * Time complexity: O(2n) -> O(n)
 * Space complexity: O(n + n) -> O(n)
 * 
 */

/**
[22,21,20,1]
i          j 


[22,    21,     20,     1,  22  ,  21 ,   ,   ]
        i                 j 

 i = j

 i++
 j + n
 */

var getConcatenation_2 = (nums) => {
    if(!nums) return []
    let n = nums.length
    for(let i = 0; i < n; i++) {
        let j = i + n
        nums[j] = nums[i]
    }
    return nums
}

console.log("2_", getConcatenation_2([22,21,20,1]))