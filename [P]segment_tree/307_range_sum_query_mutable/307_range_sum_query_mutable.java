
class NumArray {
    /*
        time:
            ▪︎ build   = O(n)
            ▪︎ update  = O(log n)
            ▪︎ query   = O(log n)

        space:
            ▪︎ tree    = O(4 * n) ~ O(n)
            ▪︎ stack   = O(log n)
    */



    int[] tree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0) return;   // 👈 thêm dòng này
        tree = new int[n * 4]; // đủ để chứa cây
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int node, int start, int end) {
        if(start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;
        build(nums, 2 * node + 1, start, mid);
        build(nums, 2 * node + 2, mid + 1, end);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    private void updateHelper(int node, int start, int end, int index, int val) {
        if(start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if(index <= mid) {
            updateHelper(2 * node + 1, start, mid, index, val);
        } else {
            updateHelper(2 * node + 2, mid + 1, end, index, val);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int l, int r) {
        // non overlap
        if(r < start || end < l) {
            return 0;
        }

        // total overlap
        if(l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        int leftSum = query(2 * node + 1, start, mid, l, r);
        int rightSum = query(2 * node + 2, mid + 1, end, l, r);

        return leftSum + rightSum;
    }
}