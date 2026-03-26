
class ReverseNodesInEvenLengthGroups {
    /*
        note: 
            we reverse base on actual group length, not the intended group size, 
            because the last group may be shorter
            
     */
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode prevGroup = dummy;
        ListNode cur = head;
        ListNode nextGroup = head;

        int groupLength = 1;

        while(cur != null) {
            // đếm số node
            int count = 0;

            while(nextGroup != null && count < groupLength) {
                count++;
                nextGroup = nextGroup.next;
            }

            if(count % 2 == 0) {
                // cô lặp group cần reverse
                ListNode node = cur;
                ListNode headGroup = new ListNode(-1);
                ListNode tailGroup = headGroup;


                for(int i = 0; i <= count; i++) {
                    if(i == count) {
                        tailGroup.next = null;
                        break;
                    } 
                    tailGroup.next = node;
                    node == node.next;
                }

                // reverse
                headGroup = reverse(headGroup, tailGroup);


                // nối lại
                prevGroup.next = headGroup;
                tailGroup.next = nextGroup;

            } else {
                for(int i = 0; i < groupLength; i++) {
                    cur = cur.next;
                    prevGroup = prevGroup.next;
                }
            }

            groupLength++;
        }


        return dummy.next;
    }

    public ListNode reverse (ListNode head, ListNode tail) {
        return null;
    }
}

class ListNode {

    @SuppressWarnings("unused")
    int val;
    ListNode next;

    @SuppressWarnings("unused")
    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
