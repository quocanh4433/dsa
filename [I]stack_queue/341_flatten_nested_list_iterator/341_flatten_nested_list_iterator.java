
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class FlattenNestedListIterator {

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.

        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    /*

    ** phân tích
    thiết kế class NestedIterator để khi user gọi
    - hashNext(): nếu có phân từ kế tiếp thì in ra


    - Approach 1: flattern toàn bộ mảng sau đó duyệt từ trái sang phải để in ra từ phân tử
        - ưu điểm: để triển khai
        - nhược điêm: phải xử lí toàn bộ mang trong khi user chi cần lấy 1 phần được flattern

    - Approach 2: sử dụng stack cho phép in ra tưng phần tử
        - ưu điểm: triển khai phức tạp
        - nhược điểm: kiểm soát qua trinh flattern 



    ** ý nghĩa:
    cho biết cach stack duyệt mảng lòng nhau mà không sử dụng đệ quy hay flatten toàn bộ ngay từ đầu

    nhìn mảng như tree [1, [5,7] 6]
        [5,7]
          /\
        1    6
   


    time: O(n)
    space: O(n)
    next(): O(1)

    
     */
    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() { // lấy phần từ đó ra
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() { // kiểm tra có phân tử nào để lấy không
            while (!stack.isEmpty()) {
                NestedInteger curr = stack.peek();

                if (curr.isInteger()) {
                    return true;
                }

                stack.pop();

                List<NestedInteger> list = curr.getList();

                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }

            return false;
        }
    }
}
