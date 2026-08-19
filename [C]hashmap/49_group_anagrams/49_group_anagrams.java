import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            int[] count = new int[26];
            char[] chars = string.toCharArray();

            for (char c : chars) {
                count[c - 'a']++;
            }

            String s = Arrays.toString(count);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(string);
        }

        return new ArrayList<>(map.values());
    }
}
