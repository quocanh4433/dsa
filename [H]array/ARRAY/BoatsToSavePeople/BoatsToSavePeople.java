import java.util.Arrays;

public class BoatsToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        if (people == null || limit <= 0) {
            return 0;
        }
        // [5,1,4,2], limit = 6
        Arrays.sort(people); // -> [1,2,4,5]

        int l = 0, r = people.length - 1;
        int res = 0;

        while (l <= r) {
            int remain = limit - people[r];
            r--;
            res++;

            if (l <= r && people[l] <= remain) {
                l++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 4, 2};
        System.out.println(numRescueBoats(nums, 6)); // exception: 2
    }
}
