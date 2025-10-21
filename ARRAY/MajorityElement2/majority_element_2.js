/**
Majority Element II (Medium)

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 

Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 
*/

/**
Follow up: Could you solve the problem in linear time and in O(1) space?

Vẫn sửa dụng hashmap nhưng số phần từ không vượt quá 3

🧠 Giải thích tại sao chỉ tối đa 2 phần tử thỏa mãn:
Giả sử tồn tại 3 phần tử trở lên đều xuất hiện > n/3 lần.
⇒ Tổng số lần xuất hiện > n
⇒ Mâu thuẫn, vì mảng chỉ có n phần tử.



 */

var majorityElement = function(nums) {
    if(!nums) return []
    if(nums.length == 1) return nums

    let count = new Map() // Chỉ lưu tối đa 3 số -> space complexity O(3) -> O(1)

    // Vòng lặp 1: lấy ra 2 số xuất hiện nhiều nhất -> O(n)
    for(let num of nums) {
        count.set(num, (count.get(num) || 0) + 1)
        
        if(count.size <= 2) continue

        let newCount = new Map()
        for(let [key, value] of count.entries()) {
            if(value > 1) {
                newCount.set(key, value - 1)
            }
        }
        count = newCount
    }

    let res = []


    // Vòng lặp 2: chỉ duyệt qua tối đa 2 số O(2) -> O(1)
    count.forEach((c, n) => {
        const frequency = nums.filter(num => num === n).length;
        if(frequency > Math.floor(nums.length/3)){
            res.push(n)
        }
    })


    return res
};

// var majorityElement = (nums) =>  {
//     let count = new Map();

//     for (const num of nums) {
//         count.set(num, (count.get(num) || 0) + 1);

//         if (count.size > 2) {
//             const newCount = new Map();
//             for (const [key, value] of count.entries()) {
//                 if (value > 1) {
//                     newCount.set(key, value - 1);
//                 }
//             }
//             count = newCount;
//         }
//     }

//     const res = [];
//     for (const [key] of count.entries()) {
//         const frequency = nums.filter(num => num === key).length;
//         if (frequency > Math.floor(nums.length / 3)) {
//             res.push(key);
//         }
//     }

//     return res;
// }
console.log(majorityElement([3,2,3]))
// console.log(majorityElement([1,2,3,1,2]))



