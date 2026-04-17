
class MyCalendarI_BinarySearchTree_Interval {

    /*
        time
            ▪︎ skewed tree       O(n)
            ▪︎ balenced tree     O(logn)
        space O(n)
     */
    class SegmentNode {

        int start, end;
        SegmentNode left, right;

        SegmentNode(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    SegmentNode root;

    public MyCalendarI_BinarySearchTree_Interval() {
        root = null;
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new SegmentNode(startTime, endTime);
            return true;
        }
        return update(root, startTime, endTime);
    }

    public boolean update(SegmentNode node, int start, int end) {
        // nếu đoạn đang xét hoàn toàn nằm bên trái của node
        if (end <= node.start) {

            // nếu left chưa có chỉ cần tạo node mới
            if (node.left == null) {
                node.left = new SegmentNode(start, end);
                return true;
            }

            // nếu left đã tồn tại quy về bài toán update node.left
            return update(node.left, start, end);
        }

        // nếu đoạn đang xét hoàn toàn nằm bên phải của node
        if (start >= node.end) {
            if (node.right == null) {
                node.right = new SegmentNode(start, end);
                return true;
            }
            return update(node.right, start, end);
        }

        return false;
    }
}
