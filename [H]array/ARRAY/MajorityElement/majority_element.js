/*
Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times in the array. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [5,5,1,1,1,5,5]
Output: 5

Example 2:
Input: nums = [2,2,2]
Output: 2

Constraints:
1 <= nums.length <= 50,000
-1,000,000,000 <= nums[i] <= 1,000,000,000

*/

/**
 * SOLUTION 1: Hash Map
 * 
 * Time complexity O(n)
 * Space complexity O(n)
 */

var majorityElement = (nums) => {
    if(!nums) return 0
    if(nums.length == 1) return nums[0]
    
    const n = nums.length
    let count = new Map()

    for(let num of nums ) {
        count.set(num, (count.get(num) || 0) + 1)
    }

    let result = 0
    
    count.forEach((freq, num) => {
        if(freq > (n / 2)) {
            result = num
        } 
    })
    return result
}

// console.log(majorityElement([5,5,1,1,1,5,5]))

/**
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

/**
 * SOLUTION 2: Boyer-Moore Voting Algorithm
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 */

var majorityElement_2 = (nums) => {
    if(!nums) return 0
    if(nums.length == 1) return nums[0]

    let result = 0
    let majority = 0

    for(let num of nums) {
       if(majority == 0) {
            result = num
       }

       majority += num == result ? 1 : -1
    }

    return result
}

// console.log(majorityElement_2([5,5,1,1,1,5,5]))
// console.log(majorityElement_2([2,1,2,1,1]))



/**
 * SOLUTION 3: Bit Manipulation
 * 
 * Time complexity O(n * 32)
 * Space complexity O(32)
 * 
 * 
 * 32 represents the number of bits as the given numbers are integers.
 */

/*
[2, 2 , 1]
n  = 3 => n/2 = 1.5

Chuyển sang mảng 4 bit: [0010, 0010, 0001]

Loop từng phần tử - với mỗi phần tử duyệt từ phải sang trái
0: 1
1: 2
2: 0 
3: 0

Ở vị trí i = 1 có value = 2 thỏa điều kiện 
=> res |= 1 << i; => 0010 => res = 2

 */

var majorityElement_3 = (nums) => {
    if(!nums) return 0
    if(nums.length == 1) return nums[0]

    
    let bits = new Array(32).fill(0)

    for(let num of nums) {
        for(let i = 0; i < 32; i++) {
            const bitValue = (num >> i) & 1 // (0010 >> 0) & 1 -> 0010 & 0001 -> 0
            bits[i] += bitValue
        }
    }

    let result = 0
    let n = nums.length

    for(let i = 0 ; i < 323; i++) {
        if(bits[i] > Math.floor(n/2)) {
            result |= (1 << i) 
            /**
                i = 1 
                res |= (1 << i)
                res |= (0001 << 1)
                res |= 0010
                res = res || 0010 = 0000 || 0010 = 0010
                res = 2
            */
        }
    }

    return result
}

console.log(majorityElement_3([5,5,1,1,1,5,5]))
console.log(majorityElement_3([2,2,1]))