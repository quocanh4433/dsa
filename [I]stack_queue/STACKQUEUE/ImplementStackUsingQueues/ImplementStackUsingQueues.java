
package ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        // Push phần tử
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top hiện tại: " + stack.top()); // 30
        System.out.println("Pop: " + stack.pop());          // 30
        System.out.println("Top sau pop: " + stack.top());  // 20
        System.out.println("Stack rỗng? " + stack.empty()); // false

        stack.pop(); // xóa 20
        stack.pop(); // xóa 10

        System.out.println("Stack rỗng sau khi pop hết? " + stack.empty()); // true
    }
}

class MyStack {

    Queue<Integer> q;

    /*
    -----------------------
    ->            1  2 3   
    -----------------------
     */
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            int last = q.poll();
            q.add(last);
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();

    }

    public boolean empty() {
        return q.isEmpty();
    }
}
