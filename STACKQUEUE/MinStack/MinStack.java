
package MinStack;


import java.util.Stack;

class MinStack {

    class Node {

        int val;
        int min;

        Node(int _val) {
            this.val = _val;
        }
    }

    Stack<Node> myStack;

    public MinStack() {
        myStack = new Stack<>();
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.min = myStack.isEmpty() ? val : Math.min(val, myStack.peek().min);
        myStack.add(newNode);
    }

    public void pop() {
        myStack.pop();
    }

    public int top() {
        return myStack.peek().val;
    }

    public int getMin() {
        return myStack.peek().min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(-5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
