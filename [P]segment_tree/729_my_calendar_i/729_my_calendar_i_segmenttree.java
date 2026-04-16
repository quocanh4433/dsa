
class MyCalendarI_SegmentTree {

    /*
        treemap: 
            ▪︎ friendly-interview
            ▪︎ nhanh gọn

        segment-tree:
            ▪︎ scalable tốt hơn
            ▪︎ nhưng nặng hơn

        Ta coi trục thời gian là đoạn rất lớn: [0, 1e9]
    
     */

    class Node {
        Node prev;
        Node next;
        boolean isBooked;
    }

    private Node root = new Node();
    private int START = 0;
    private int END = (int) 10e9;

    public boolean book(int start, int end) {

        if (query(root, START, END, start, end - 1)) {
            /*
                nếu không end - 1?

                book(10, 20)
                book(20, 30)

                trả về true không bị overlap

                nhưng trong segment tree 10-20 và 20-30 chạm nhau tại 20

                gây xung đột
            
             */

            return false; // bị overlap
        }

        // update(root, START, END, start, end - 1);
        return true;
    }

    private boolean query(Node node, int left, int right, int queryLeft, int queryRight) {
        if (node == null) {
            return false;
        }
        return true;
    }
}
