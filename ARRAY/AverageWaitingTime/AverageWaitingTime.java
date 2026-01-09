public class AverageWaitingTime {

    /*
    SOLUTION 1: 

    Time complexity: O(n)
    Space complexity: O(1)


    [[1,2],[2,5],[4,3]]
    [[5,2],[5,4],[10,3],[20,1]]

    timeToStartSer: 21
    wait: 13

    i = 0
        arrive: 5h - service: 2 hours

        delay = timeToStartSer - customer[i][1] = 0  
        done: customer[i][1] + customer[i][2] + delay = 7h -> timeToStartSer
        wait: done[i] - customer[i][1] += 2 hours

    i = 1
        arrive: 5h - service: 4 hours

        delay: 2 hours 
        done: 9 + 2 = 11h -> timeToStartSer
        wait += 6 hours

    i = 2
        arrive: 10h - service: 3 hours
        
        delay: 1 hours
        done: 13 + 1 = 14h -> timeToStartSer
        wait += 4 hours

    i = 3
        arrive: 20h - service: 1 hours
        
        delay: 0 hours
        done: 20 + 1 = 21h -> timeToStartSer
        wait += 1 hours


    return wait/len(customers)
      
     */
    public static double averageWaitingTime(int[][] customers) {
        if (customers == null) {
            return 0;
        }

        int timeToStartServe = 0;
        int totalWaitingTime = 0;

        for (int[] customer : customers) {
            int timeLater = Math.max(0, timeToStartServe - customer[0]);
            timeToStartServe = customer[0] + customer[1] + timeLater;
            totalWaitingTime += timeToStartServe - customer[0];
        }

        return (double) totalWaitingTime / customers.length;

    }

    /*
    SOLUTION 2: PRIORITY QUEUE (HEAP)

    QUAY LẠI KHI HỌC ĐẾN HEAP    
     */
    public static void main(String[] args) {
        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        int[][] customers2 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers)); // exception: 3.25
        System.out.println(averageWaitingTime(customers2)); // exception: 5.0
    }
}
