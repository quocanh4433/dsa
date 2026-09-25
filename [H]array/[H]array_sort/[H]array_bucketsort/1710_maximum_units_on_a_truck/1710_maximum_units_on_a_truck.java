
class MaximumUnitsOnATsruck {

    /*
        time O(n)
        space O(1)
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] bucket = new int[1001];

        // Put boxes into buckets
        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            bucket[unitsPerBox] += numberOfBoxes;
        }

        int res = 0;

        for (int units = 1000; units >= 1 && truckSize > 0; units--) {

            int boxes = Math.min(bucket[units], truckSize);

            res += boxes * units;

            truckSize -= boxes;
        }

        return res;
    }
}
