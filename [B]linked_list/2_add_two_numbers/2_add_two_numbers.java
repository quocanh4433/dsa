
@SuppressWarnings("unused")
class AddTwoNumbers {
    /*
        time O(max(n, m))
        space O(max(n, m)) ~ create new list
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;

            /*
                sum = 8
                carry = 8 / 10 = 0.8 ~ 0;
                digit = 8 % 10 = 8
             */
            carry = sum / 10;
            int digit = sum % 10;

            cur.next = new ListNode(digit);;
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @SuppressWarnings("unused")
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
