
import java.util.Stack;

public class OnlineStockSpan {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}

class StockSpanner {

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     */
    private final Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>(); // pair: [price, span]
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.peek()[1];
            stack.pop();
        }

        // if stack is empty or price less than previous stock
        stack.push(new int[]{price, span});
        return span;
    }
}
