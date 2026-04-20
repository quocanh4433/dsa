/*
    time O(log N)
        ▪︎ mỗi lần book O(log N)
        ▪︎ mỗi lần update O(log N)
        ▪︎ N = 1e9 -> log(1e9) ~ 30 -> rất nhanh

    space O(k log N)
        ▪︎ mỗi lần book tạo tối đa bao nhiêu node?
            ▪︎ mỗi lần update đi sâu tối đa O(log N)
            ▪︎ mỗi level tạo nhiều nhất 2 node
            ▪︎ suy ra, mỗi lần book tạo ra tối đa O(log N) = O(log(1e9)) ~ 30
        ▪︎ theo constrains có tối đa 1000 lần call book()
            ▪︎ suy ra, có tối đa 1000 * 30 = 30,000 node được tạo ra

 */
class MyCalendarTwo {

    class Node {

        Node left, right;
        int max; // số lần booking lớn nhất trong đoạn này
        int add; // lazy propagation (cộng dồn)
    }

    Node root;
    int START = 0;
    int END = (int) 1e9;

    public MyCalendarTwo() {
        root = new Node();
    }

    public boolean book(int start, int end) {
        if (maxBooking(root, START, END, start, end - 1) >= 2) {
            return false;
        }
        update(root, START, END, start, end - 1, 1);
        return true;
    }

    public int maxBooking(Node node, int nodeStart, int nodeEnd, int start, int end) {
        if (node == null || start > nodeEnd || end < nodeStart) {
            return 0;
        }

        // nếu đoạn đang xét cover toàn bộ node
        if (start <= nodeStart && nodeEnd <= end) {
            return node.max;
        }

        pushDown(node);

        int nodeMid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (end <= nodeMid) {
            return maxBooking(node.left, nodeStart, nodeMid, start, end);
        } else if (start > nodeMid) {
            return maxBooking(node.right, nodeMid + 1, nodeEnd, start, end);
        } else {
            return Math.max(
                    maxBooking(node.left, nodeStart, nodeMid, start, end),
                    maxBooking(node.right, nodeMid + 1, nodeEnd, start, end)
            );
        }
    }

    public void update(Node node, int nodeStart, int nodeEnd, int start, int end, int val) {
        if (node == null || start > nodeEnd || end < nodeStart) {
            return;
        }

        if (start <= nodeStart && nodeEnd <= end) {
            node.max += val;
            node.add += val;
            return;
        }

        pushDown(node);

        int nodeMid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (end <= nodeMid) {
            update(node.left, nodeStart, nodeMid, start, end, val);
        } else if (start > nodeMid) {
            update(node.right, nodeMid + 1, nodeEnd, start, end, val);
        } else {
            update(node.left, nodeStart, nodeMid, start, end, val);
            update(node.right, nodeMid + 1, nodeEnd, start, end, val);
        }

        node.max = Math.max(node.left.max, node.right.max);
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }

        if (node.add != 0) {
            node.left.max += node.add;
            node.right.max += node.add;

            node.left.add += node.add;
            node.right.add += node.add;

            node.add = 0;
        }
    }
}
