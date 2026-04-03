
@SuppressWarnings("unused")
class DeleteNodeInALinkedList {

    /*
        time O(1)
        space O(1)    


        description:
    
            a singly linked-list head, but you not access it

            you given one of the nodes in singly -linked-list above, it is not a last node

            your task is delete it

            for example:

            head: 1 -> *4* -> 5 -> 9

            you given node 4, delete it to head become: 1 -> 5 -> 9 

        
        
        idea: 
            - set value cur node to next node
            - set cur.next = nextnode.next

            1 -> *4* -> 5 -> 9

            set 4 -> 5

            1 -> *5* -> 5 -> 9

            set *5*.next to 9

            1 -> 5 -> 9

        delete node but do not need prevnode
     */
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
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
