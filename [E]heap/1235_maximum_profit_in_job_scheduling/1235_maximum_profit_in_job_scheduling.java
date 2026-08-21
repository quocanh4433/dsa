
class MaximumProfitInJobScheduling {

    /*
        time O(nlogn)
        space O(n)

        n: số lương công việc

        tương tự bài 2008, 2054
     */

    class Job {

        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // step 1: sắp xếp công việc theo thứ tự start_time tang dần
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        // step 2: cho vao heap<end, profit>
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int maxProfit = 0;

        for (Job job : jobs) {
            int start = job.start;
            int end = job.end;

            // giai phóng các công việc đã kết thúc 
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                maxProfit = Math.max(maxProfit, pq.poll()[1]);
            }

            // thêm công việc hiện tại vào heap với profit hiên tại + maxProfit trong quá khứ
            pq.offer(new int[]{end, maxProfit + job.profit});
        }

        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.poll()[1]);
        }

        return maxProfit;
    }
}
