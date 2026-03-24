
@SuppressWarnings("unused")
class MergeTwoSortedLists {
    /*
        time O(n + m)
        space O(1)

        we do not create new nodes, we only reuse existing nodes from list1 and list2, so space complexity is O(1);
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }

        ListNode ans = new ListNode(-1);
        ListNode cur = ans;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return ans.next;
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
