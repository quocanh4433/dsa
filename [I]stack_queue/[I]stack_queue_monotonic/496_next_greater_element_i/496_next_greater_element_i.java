import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterElement_i {
    /*
        time O(n1 + n2) ~ O(n2) (n2 >= n1)
        space O(n)
    
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums2.length < nums1.length) return null;
            
        // [key, value] key là item trong nums2 - value số lớn hơn item đó
        Map<Integer, Integer> map = new HashMap<>(); 
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);

        for(int i = 1; i < nums2.length; i++) {
            
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
