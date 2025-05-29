/*
First Missing Positive 


You are given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
Cho một mảng số nguyên chưa sắp xếp. Trả về số nguyên dương nhỏ nhất không xuất hiện trong mảng 


You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
Giải bài toán với độ phức tạp O(n) hoặc O(1)

Example 1:
Input: nums = [-2,-1,0]
Output: 1. Vì 1 là số nguyê nduowng nhỏ nhất không có trong mảng

Example 2:
Input: nums = [1,2,4]
Output: 3

Example 3:
Input: nums = [1,2,4,5,6,3,1]
Output: 7

Constraints:
1 <= nums.length <= 100,000
-(2^31) <= nums[i] <= ((2^31)-1)

*/


/*
SOLUTION 1: Sort

[-1, 0, 2, 3, -2]
After Sort
[-2, -1, 0, 2, 3]

let misssing = 1
for num: nums    
    if num > 0 && num == missing {
        misssing++
    }

reutn missing


Time comlexity: O(nlogn)
Space comlexity: O(1) or O(n) depending on sorting algorithm

*/

var firstMissingPositive = (nums) => {
    if(!nums) return 0

    nums.sort((a, b) => a - b)

    let missing = 1

    for(let num of nums) {
        if(num > 0 && num == missing) {
            missing++
        }
    }

    return missing
}

console.log("1_",firstMissingPositive([-2,-1,0])) // 1
console.log("1_",firstMissingPositive([1,2,4,5,6,3,1])) // 7
console.log("1_",firstMissingPositive([1,2,4])) // 3
console.log("1_",firstMissingPositive([1])) // 2
console.log("1_",firstMissingPositive([1, 3, 2, 4])) // 5
console.log("___________") // 5


/*
SOLUTION 2: Use Array as a Memory


Ý tưởng là: 
1/ Không cần quan tấm số âm -> nếu value là số âm thì gán bằng 0


2/ Một mảng có độ dài n. Kết quả (res) thuộc tập hợp [1,.... n+1]


VD1: 
Cho một mảng [56,2,-8]. Mảng có độ dài n=3. Kết quả thuộc tập hợp A = [1,2,3,4]. Thực tế kết quả = 1 thuộc tập A

VD2: 
Cho một mảng [0,1,-4,6]. Mảng có độ dài n=4. Kết quả thuộc tập hợp A = [1,2,3,4,5]. Thực tế kết quả = 2 thuôc tập A

*/

var firstMissingPositive_2 = (nums) => {
    if(!nums) return 0

    let n = nums.length

    // Bỏ số âm
    for(let i = 0; i < n; i++) {
        if(nums[i] < 0) nums[i] = 0
    }


    // Đánh dấu val có giá trị từ 1 -> n
    for(let i = 0; i < n; i++ ) {
        let val = Math.abs(nums[i])

        if(val >= 1 && val <= n) {  // Giả sử mảng có n phần tử, thì mọi số nguyên dương từ 1 đến n là những số "có thể tồn tại" trong mảng.
            if(nums[val - 1] > 0) {
                nums[val - 1] *= -1

            } else if (nums[val - 1] == 0) {
                nums[val - 1] = (-1)*(n + 1)
            }
        }
    }

    // Tìm số dương đầu tiên không được đánh dấu
    for(let i = 1; i <= n; i++) {
        if(nums[i - 1] >= 0) {
            return i
        }
    }

    return n + 1
}

console.log("2_",firstMissingPositive_2([-2,-1,0])) // 1
console.log("2_",firstMissingPositive_2([3,-3,6,0])) // 1
console.log("2_",firstMissingPositive_2([1,2,4,5,6,3,1])) // 7
console.log("2_",firstMissingPositive_2([1,2,4])) // 3
console.log("2_",firstMissingPositive_2([1])) // 2