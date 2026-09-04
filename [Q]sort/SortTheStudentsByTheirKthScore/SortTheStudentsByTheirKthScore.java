
import java.util.Arrays;

public class SortTheStudentsByTheirKthScore {

    /*
        SOLUTION 1: 
        Time: O(n) - worst case: O(nlogn)
        Space: O(n)
     */
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }


    /*
        SOLUTION 2: Insertion sort

        Time: O(n) - worst case O(n^2)
        Space: O(1)

        Trong bài này không nên dùng cách này
        Do insertion sort phù hợp với dữ liệu gần như được sắp xếp
    
     */
    public int[][] sortTheStudents_InsertionSort(int[][] score, int k) {
        int n = score.length;

        for (int i = 1; i < n; i++) {
            int[] key = score[i]; // sinh viên đang xét
            int j = i - 1;
            while (j >= 0 && key[k] > score[j][k]) {
                score[j + 1] = score[j]; // dịch sang phải
                j--;
            }
            score[j + 1] = key;
        }

        return score;
    }

    public static void main(String[] args) {

    }
}
