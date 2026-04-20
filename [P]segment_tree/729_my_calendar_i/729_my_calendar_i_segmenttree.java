

/*
        treemap: 
            ▪︎ friendly-interview
            ▪︎ nhanh gọn

        segment-tree:
            ▪︎ scalable tốt hơn
            ▪︎ nhưng nặng hơn
            ▪︎ sử dụng segment tree cho bài này overskill


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
class MyCalendar {

    class Node {

        Node left, right;
        boolean booked; // booked = true ⇢ TOÀN BỘ đoạn này đã bị đoạn lớn hơn hoặc bằng cover
    }

    int START = 0;
    int END = (int) 1e9;
    Node root;

    public MyCalendar() {
        root = new Node();
    }

    public boolean book(int start, int end) {
        // kiểm tra thời gian cần book có nằm trong hoặc overlap với thời gian của node hay không?

        if (hasOverlap(root, start, end - 1, START, END)) {
            // nếu có -> không thể book 
            return false;
        }

        // nếu không -> update tree -> có thể book
        update(root, start, end - 1, START, END);
        return true;
    }

    /*
        @param: node: node đang xét
        @param: nodeStart, nodeEnd: thời gian của node trong segment tree
        @param: start, end: thời gian cần book

        thời gian cần book có nằm trong hay overlap với thời gian của node hay không?
     */
    public boolean hasOverlap(Node node, int start, int end, int nodeStart, int nodeEnd) {
        // nếu node == null hoặc đoạn cần book hoàn toàn nằm bên ngoài range của node 
        // không overlap -> return false
        if (node == null || start > nodeEnd || end < nodeStart) {
            return false;
        }

        // nếu node đang xét đã bị book
        // có overlap -> return true
        if (node.booked) {
            return true; // nên để đây đề tránh trường hợp node == null
        }
        // đi đến node leaf
        // không overlap -> return false;
        if (nodeStart == nodeEnd) {
            return false;
        }

        int nodeMid = nodeStart + (nodeEnd - nodeStart) / 2;

        // nên viết như vầy tránh trường hợp cây nghiên một phía nhưng vẫn kiểm tra 2 phía left và right
        if (end <= nodeMid) {
            return hasOverlap(node.left, start, end, nodeStart, nodeMid);
        } else if (start > nodeMid) {
            return hasOverlap(node.right, start, end, nodeMid + 1, nodeEnd);
        } else {
            return hasOverlap(node.left, start, end, nodeStart, nodeMid)
                    || hasOverlap(node.right, start, end, nodeMid + 1, nodeEnd);
        }
    }

    /*
        @param: node: node đang xét
        @param: nodeStart, nodeEnd: thời gian của node trong segment tree
        @param: start, end: thời gian cần book

        để update cần biết thời gian cần book đang cover hoặc overlap với thời gian của node nào?

            - nếu nằm hoàn toàn ngoài thời gian của node -> bỏ qua không quan tâm

            - nếu

     */
    public void update(Node node, int start, int end, int nodeStart, int nodeEnd) {
        // nếu node == null hoặc đoạn cần update hoàn toàn nằm bên ngoài thời gian của node
        // không cần update -> return
        if (node == null || end < nodeStart || nodeEnd < start) {
            return;
        }

        if (node.booked) {
            return;
        }

        // nếu thời gian cần update cover hoàn toàn thời gian của node
        // không cần update -> return
        if (start <= nodeStart && nodeEnd <= end) {
            node.booked = true;

            // đã full rồi không cần giữ cây con bên dưới
            // giúp cây gọn hơn tránh lãng phí bộ nhớ
            node.left = null;
            node.right = null;
            return;
        }

        // nếu thời gian cần update giao một phần với node
        // node: [9, 12] 
        // update: [10, 19]
        int nodeMid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }

        if (end <= nodeMid) {
            update(node.left, start, end, nodeStart, nodeMid);
        } else if (start > nodeMid) {
            update(node.right, start, end, nodeMid + 1, nodeEnd);
        } else {
            update(node.left, start, end, nodeStart, nodeMid);
            update(node.right, start, end, nodeMid + 1, nodeEnd);
        }

        node.booked = node.left.booked && node.right.booked;
    }
}
