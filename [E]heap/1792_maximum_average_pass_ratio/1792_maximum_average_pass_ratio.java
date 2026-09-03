import java.util.PriorityQueue;

class MaximumAveragePassRatio {

    /*
        thêm extraStudent và lớp nào phụ thuộc vào phần trăm tăng trưởng

        lớp A: 1/2 = 50% -> thêm 1 học sinh 66.66% -> tăng thêm: 16.66%
        lớp B: 10/20 = 50% -> thêm 1 học sinh 52.4% -> tăng thêm 2.4%

        cùng tỷ lệ ban đầu nhưng % tăng thêm khác nhau

        do đó:
            - tính % tăng thêm ở mỗi lớp giả sử thêm 1 học sinh
            - xếp vào max-heap theo thứ tựu % tăng thêm giảm dần
            - lấy phần tư đầu tiên từ trong max-heap cung chính là phần tử tăng trương tốt nhất để phân bổ học sinh


        time O(nlogn)
        space O(n)
     */
    class ClassInfo {

        int pass;
        int total;

        ClassInfo(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        double getGain() {
            return (double) (pass + 1) / (total + 1) - (double) pass / total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> maxheap = new PriorityQueue<>((a, b) -> Double.compare(b.getGain(), a.getGain()));

        for (int[] cl : classes) {
            maxheap.offer(new ClassInfo(cl[0], cl[1]));
        }

        while (extraStudents > 0) {
            ClassInfo top = maxheap.poll();
            top.pass++;
            top.total++;
            extraStudents--;
            maxheap.offer(top);
        }

        double totalRaito = 0;
        while (!maxheap.isEmpty()) {
            ClassInfo cur = maxheap.poll();
            totalRaito += (double) cur.pass / cur.total;
        }

        return totalRaito / classes.length;
    }
}
