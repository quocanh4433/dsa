
class FindTheDuplicateNumber_HareAndTortoise {

    /*
        Hare and Totoise Algorithm

        cách này chỉ áp dụng được khi
            - mảng nums là mảng số nguyên dương và chiều dài là n
            - các phẩn từ bên trong chỉ có giá trị trong đoạn [1, n - 1];

        time O(n)
        space O(1)

     */
    public int findDuplicate(int[] nums) {

        // giai doan 1: xac dinh co cycle hay khong?
        // slow di 1 buoc - fast di 2 buoc
        int n = nums.length;
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            // tranh infinity loop if not cycle
            if (fast >= n || nums[fast] >= n) {
                return -1;
            }

            slow = nums[slow];
            fast = nums[nums[fast]];

            if (fast == slow) {
                break; // ton tai cycle chuyen sang giai doan 2
            }
        }

        // giai doan 2: xac dinh cycle o dau
        // slow vaf fast cung di 1 buoc
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

/*
*****dry run: 
nums = [3,1,3,4,2]

ban dau 
slow = 3
fast = 3

vong 1: 
slow = 4
fast = 2

vong 2: 
slow = 2
fast = 4

vong 3: 
slow = 3
fast = 3

co cycle chuyen sang giai doan 2

dua slow ve diem bat dau 

slow = nums[0] = 3
fast = 3

vo tinh slow va fast bang nhau return slow = 3


*****dry run: 
nums = [1,3,4,2,2]

ban dau 
slow = 1
fast = 1

vong 1:
slow = 3
fast = 2

vong 1:
slow = 2
fast = 2


co cycle chuyen sang giai doan 2

dua slow ve diem bat dau. moi loop slow và fast di 1 buoc

slow = nums[0] = 1
fast = 2

vong 1: 
slow = 3
fast = 4

vong 2: 
slow = 2
fast = 2

slow == fast return 2

 */
