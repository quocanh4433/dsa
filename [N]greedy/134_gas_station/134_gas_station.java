
class GasStation {

    /*
        time O(n)
        space O(1)
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for (int g : gas) {
            totalGas += g;
        }

        int totalCost = 0;
        for (int c : cost) {
            totalCost += c;
        }

        if (totalGas < totalCost) {
            return -1;
        }

        // chắc chắn tồn tại circular route
        // do đó, chắc chắn tồn tại i trong khoảng [0, n -1]
        
        int cur = 0;
        int index = -1;

        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];

            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }

        return index;
    }
}
