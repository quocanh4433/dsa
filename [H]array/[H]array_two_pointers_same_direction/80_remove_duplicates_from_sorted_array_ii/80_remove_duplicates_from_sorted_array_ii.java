
class RemoveDuplicatesFromSortedArrayII {

    /*
        time O(n)
        space O(1)
     */

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int write = 2;
        for (int read = 2; read < nums.length; read++) {
            if (nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
}

/*
    write: lưu vị trí cần ghi đè
    read: duyệt qua nums

    
    **loop 1:
    1   1   1   2   2   3
            w
            r

    read = 2
    write = 2

    nums[read] = 1
    nums[write - 2] = 1 

    giống nhau tức số 1 xuất hiện hơn 2 lần -> cần thay thế

    
    **loop 2:
    1   1   2*  2   2   3
                w
                r
    read = 3
    write = 2

    nums[read] = 2
    nums[write - 2] = 1 

    khác nhau -> nums[write] được thay thế bằng nums[read] và tăng write lên


    **loop 3:
    1   1   2   2*  2   3
                    w
                    r
    read = 4
    write = 3

    nums[read] = 2
    nums[write - 2] = 1

    khác nhau -> nums[write] được thay thế bằng nums[read] và tăng write lên


    **loop 4:
    1   1   2   2   3*   3
                        w
                        r
    read = 5
    write = 4

    nums[read] = 3
    nums[write - 2] = 2

    khác nhau -> nums[write] được thay thế bằng nums[read] và tăng write lên
 */
