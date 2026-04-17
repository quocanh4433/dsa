
class MyCalendarI_SegmentTree {

    /*
        treemap: 
            ▪︎ friendly-interview
            ▪︎ nhanh gọn

        segment-tree:
            ▪︎ scalable tốt hơn
            ▪︎ nhưng nặng hơn
            ▪︎ sử dụng segment tree cho bài này overskill


        ý tưởng với segmenttree:
            mỗi node đại điện cho một khoảng thời gian
     */
    
    class Node {
        Node left, right;
        boolean booked; // bất kỳ phần nào trong đoạn đã bị book, thì "booked" được xem là true
    }

    int START = 0, END = (int) 1e9;
    Node root;

    public MyCalendarI_SegmentTree() {
        root = new Node();
    }
    
    public boolean book(int start, int end) {
        // nêu overlap thì dừng lại
        if(hasOverlap(root, start, end - 1, START, END)){
            return false;
        }

        // nếu không overlap thì update về tree
        update(root, START, END, start, end - 1);
        return true;
    }

    /*
        @param: nodeStart, nodeEnd: range của node đang quản lý
        @param: start, end: range đang xét
     */
    public boolean hasOverlap(Node node, int start, int end, int nodeStart, int nodeEnd) {
        // nếu node == null hoặc đoạn đang xét hoàn toàn nằm bên ngoài range của node 
        // không overlap -> return false
        if(node == null || start > nodeEnd || end < nodeStart) return false;

        // early stop
        if(node.booked) return true;

        // đi đến node leaf
        // không overlap -> return false;
        if(nodeStart == nodeEnd) return false;

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        return hasOverlap(node.left, start, end, nodeStart, mid) || hasOverlap(node.right, start, end, mid + 1, nodeEnd);
    }

    public void update(Node node, int start, int end, int nodeStart, int nodeEnd) {
        // nếu node == null hoặc đoạn đang xét hoàn toàn nằm bên ngoài range của node 
        if(node == null || start > nodeEnd || end < nodeStart) return;

        // đoạn cần book nằm hoàn toàn trong range của node
        if(start >= nodeStart && end <= nodeEnd) {
            node.booked = true;
            return; // đoạn này đã bị chiếm không cần đi tiếp nữa
        }

    }
}
