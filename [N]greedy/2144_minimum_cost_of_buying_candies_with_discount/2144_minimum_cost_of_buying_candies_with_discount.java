
class MinimumCostOfBuyingCandiesWithDiscount {

    /*
        time O(nlogn)
        space O(1)
    
     */
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int buy = 0;
        int free = 0;

        Arrays.sort(cost);

        for (int i = 0; i < n; i++) {
            buy += cost[i];
        }

        for (int i = n - 3; i >= 0; i -= 3) {
            free += cost[i];
        }

        return buy - free;
    }
}
