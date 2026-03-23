
class VerifyPreorderSerializationOfABinaryTree {

    /*
        time O(n)
        space O(1)
        
        idea: thay vi build tree chỉ cần đếm số slot

        vd: [1, #, #]

        loop1: 
            slot = 2
            node = 1
        loop2:
            slot = 1
            node = #
        loop3:
            slot = 0
            node = #
        slot == 0 -> TRUE


        vd: [1, #]
        loop1: 
            slot = 2
            node = 1
        loop2:
            slot = 1
            node = #
        slot != 0 -> FALSE

     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slot = 1;

        for (String node : nodes) {
            slot--;

            if (slot < 0) {
                return false;
            }

            if (!node.equals("#")) {
                slot += 2;
            }
        }

        return slot == 0;
    }
}
