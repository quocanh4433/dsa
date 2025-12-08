import java.util.Arrays;

public class HouseRobber_TopDown {
    /*
    Time -> O(n): Môi ô chỉ đi qua một lần
    Space -> O(n)
    
    */

    private int[] cache;
    private int[] nums;

    public int rob(int[] nums) {
        this.cache = new int[nums.length];
        this.nums = nums;
        Arrays.fill(cache, -1);
        return dfs(0);
    }

    public int dfs(int i) {
        if(i >= nums.length) return 0;
        if(cache[i] != -1) return cache[i];
        // ❌ Nếu xét cache[i] != 0 sẽ bỏ qua trường hợp 0 là giá trị hợp lệ nếu nums[i] = 0.

        int skip = dfs(i + 1);
        int rob = nums[i] + dfs(i + 2);

        cache[i] =  Math.max(skip, rob);
        return cache[i];
    }


    public static void main(String[] args) {
        
    }
}
