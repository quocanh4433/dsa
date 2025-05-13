/*
Longest Consecutive Sequence
Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.


Example 1:
Input: nums = [2,20,4,10,3,4,5]
Output: 4
Explanation: The longest consecutive sequence is [2, 3, 4, 5].


Example 2:
Input: nums = [0,3,2,5,4,6,1,1]
Output: 7


Constraints:
0 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

 */


// 
/**
Cách 1: Sử dụng hàm Set

Time complexity: O(n)
Space complexity: O(n)


Tại sao có cả vong lặp for và while nhưng time complexity chỉ có O(n)?
->
vòng for lặp qua tât cả num => O(n)
vòng while
nums = [100, 3, 1, 2]
for n = 100 - while 1
for n = 3 - while 0
for n = 1 - while 2
for n = 2 - while 0




nums = [7,1,6]
for n = 7 -> while 3
for n = 1 -> while 3
for n = 6 -> while 3 

 */
var longestConsecutive = function(nums) {
    const numSet = new Set(nums) 
    let longest = 0

    for(let num of numSet) { // O(n)
        if(!numSet.has(num - 1)) {
            let length = 1

            while(numSet.has(num + length)) {
                length++
            }

            longest = Math.max(longest, length)
        }
    }

    return longest
};

console.log("01_", longestConsecutive([1,1,3,4,2,50,51]))
console.log("01_", longestConsecutive([0,3,2,5,4,6,1,1]))


// Cách 2: Sort trước 
var longestConsecutive_02 = function(nums) {
    if(!nums) return 0

    nums.sort((a, b) => a - b)
    let longest = 0
    let length = 1

    for(let i = 0; i < nums.length; i++) {     
        if(nums[i + 1] == nums[i]) continue 

        if (nums[i + 1] == nums[i] + 1) {
            ++length
        } else {
            length = 1
        }

        longest = Math.max(longest, length)
    }
    return longest   
}

console.log("02_", longestConsecutive_02([9,1,4,7,3,-1,0,5,8,-1,6]))
console.log("02_", longestConsecutive_02([0, 0]))
console.log("02_", longestConsecutive_02([0]))
console.log("02_", longestConsecutive_02([1,1,3,4,2,50,51]))
console.log("02_", longestConsecutive_02([0,3,2,5,4,6,1,1]))