import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public static String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            if (freq.containsKey(c)) {
                int count = freq.get(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
            }
            freq.remove(c);
        }

        for (char c : freq.keySet()) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();

    }

    public static void main(String[] args) {

    }
}
