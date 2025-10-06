
import java.util.Stack;

public class ImplementQueueUsingStacks {

    /**
     * Time complexity: O(n): pop(), peek() - O(1): còn lại
     *
     * Space complexity: O(n) mặc dù, dung 2 stack nhưng tông chỉ có n phần từ
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // push(1), push(2), push(3), push(4)
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop()); // expected 1

        queue.push(5);
        queue.push(6);

        System.out.println(queue.peek()); // expected 2
        System.out.println(queue.pop());  // expected 2
        System.out.println(queue.pop());  // expected 3
        System.out.println(queue.pop());  // expected 4

        queue.push(7);
        queue.push(8);

        System.out.println(queue.peek()); // expected 5
        System.out.println(queue.pop());  // expected 5
        System.out.println(queue.pop());  // expected 6
        System.out.println(queue.pop());  // expected 7
        System.out.println(queue.pop());  // expected 8

        System.out.println(queue.empty()); // expected true
    }
}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
    STACK 1
    -----------------------|
    <--           
    -----------------------|

    STACK 2 
    -----------------------|
    <--             5 6 7 8
    -----------------------|

    push(1) - push(2) - push(3) - push(4) 
    pop() // 1
    push(5) 
    push(6) 
    peek() // 2
    pop()
    pop()
    pop()
    push(7)
    push(8)
    peek() // 5
    pop()
    pop()
    empty() // true

     */
    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
