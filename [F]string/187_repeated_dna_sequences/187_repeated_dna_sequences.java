import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatedDNASequences {

    /*
        time O(n)
        space O(n)
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }

        long BASE = 31;
        int L = 10; // do dai cua window

        // Tính 31^9 (Lũy thừa cao nhất của ký tự đầu cửa sổ)
        long highPower = 1;
        for (int i = 0; i < L - 1; i++) {
            highPower = highPower * BASE;
        }

        Set<Long> seen = new HashSet<>();
        Set<Long> added = new HashSet<>(); // quan string da xuat hien hon 1 lan chua

        // hash 10 ky tu dau
        long hash = 0;
        for (int i = 0; i < L; i++) {
            hash = hash * BASE + s.charAt(i); // java tu dong chuyen ky tu  'A' -> 65, 'C' -> 67,...
        }
        seen.add(hash);

        // truot tren window
        // trong vong lap i dai dien cho ky tu CUOI CUNG cuar window
        for (int i = L; i < s.length(); i++) {
            int addVal = s.charAt(i);
            int removeVal = s.charAt(i - L);

            // tru phan dong gop cuar ky tu cu
            long removeContribution = removeVal * highPower;

            hash = hash - removeContribution;
            hash = hash * BASE + addVal;

            if (seen.contains(hash)) {
                if (!added.contains(hash)) { // chua xuat hien lan thu 2
                    res.add(s.substring(i - L + 1, i + 1));
                    added.add(hash);
                }
            } else {
                seen.add(hash);
            }
        }

        return res;
    }
}
